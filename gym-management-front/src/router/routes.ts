import { RouteRecordRaw } from 'vue-router';

export type UserPathType =
  | 'subscribe'
  | 'course'
  | 'consult'
  | 'plan'
  | 'actionLibrary'
  | 'personal';

export const userPath: { [k in UserPathType]: string } = {
  subscribe: '/subscribe',
  course: '/course',
  consult: '/consult',
  plan: '/plan',
  actionLibrary: '/actionLibrary',
  personal: '/personal',
};

const routes: RouteRecordRaw[] = [
  {
    path: '/login',
    component: () => import('@/pages/login/login.vue'),
  },
  {
    path: '/register',
    component: () => import('@/pages/login/register.vue'),
  },
  {
    path: '/',
    component: () => import('@/pages/user/index.vue'),
    meta: {
      requiresAuth: true,
    },
    redirect: userPath.subscribe,
    children: [
      {
        path: userPath.subscribe,
        component: () => import('@/pages/user/c-pages/subscribe/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.course,
        component: () => import('@/pages/user/c-pages/course/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.consult,
        component: () => import('@/pages/user/c-pages/consult/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.plan,
        component: () => import('@/pages/user/c-pages/plan/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.actionLibrary,
        component: () => import('@/pages/user/c-pages/actionLibrary/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.personal,
        component: () => import('@/pages/user/c-pages/personal/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
    ],
  },
];

export default routes;
