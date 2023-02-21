import { RouteRecordRaw } from 'vue-router';

export type UserPathType = keyof typeof userPath;

export const userPath = {
  subscribe: '/subscribe',
  course: '/course',
  consult: '/consult',
  muscleBuilding: '/muscleBuilding',
  fatReduction: '/fatReduction',
  privateCustom: '/privateCustom',
  actionLibrary: '/actionLibrary',
  personal: '/personal',
};

export type AdminPathType =
  | 'userInfo'
  | 'coachInfo'
  | 'gymInfo'
  | 'courseInfo'
  | 'passwordInfo';

export const adminPath: { [k in AdminPathType]: string } = {
  userInfo: 'userInfo',
  coachInfo: 'coachInfo',
  gymInfo: 'gymInfo',
  courseInfo: 'courseInfo',
  passwordInfo: 'passwordInfo',
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
    path: '/admin',
    component: () => import('@/pages/admin/index.vue'),
    meta: {
      requiresAuth: true,
    },
    redirect: `/admin/${adminPath.userInfo}`,
    children: [
      {
        path: adminPath.userInfo,
        component: () => import('@/pages/admin/c-pages/userInfo/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: adminPath.coachInfo,
        component: () => import('@/pages/admin/c-pages/coachInfo/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: adminPath.gymInfo,
        component: () => import('@/pages/admin/c-pages/gymInfo/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: adminPath.courseInfo,
        component: () => import('@/pages/admin/c-pages/courseInfo/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: adminPath.passwordInfo,
        component: () => import('@/pages/admin/c-pages/passwordInfo/index.vue'),
        meta: {
          requiresAuth: true,
        },
      },
    ],
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
        path: userPath.muscleBuilding,
        component: () =>
          import('@/pages/user/c-pages/plan/muscle-building.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.fatReduction,
        component: () => import('@/pages/user/c-pages/plan/fat-reduction.vue'),
        meta: {
          requiresAuth: true,
        },
      },
      {
        path: userPath.privateCustom,
        component: () => import('@/pages/user/c-pages/plan/private-custom.vue'),
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
