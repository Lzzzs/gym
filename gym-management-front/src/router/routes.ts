import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/login',
    component: () => import('@/pages/login/login.vue'),
  },
  {
    path: '/',
    component: () => import('@/pages/user/index.vue'),
    children: [
      {
        path: '/subscribe',
        component: () => import('@/pages/user/c-pages/subscribe/index.vue'),
      },
      {
        path: '/course',
        component: () => import('@/pages/user/c-pages/course/index.vue'),
      },
      {
        path: '/consult',
        component: () => import('@/pages/user/c-pages/consult/index.vue'),
      },
      {
        path: '/plan',
        component: () => import('@/pages/user/c-pages/plan/index.vue'),
      },
      {
        path: '/action-library',
        component: () => import('@/pages/user/c-pages/actionLibrary/index.vue'),
      },
      {
        path: '/personal',
        component: () => import('@/pages/user/c-pages/personal/index.vue'),
      },
    ],
  },
];

export default routes;
