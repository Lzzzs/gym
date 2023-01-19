import { createRouter, createWebHistory } from 'vue-router';
import { App } from 'vue';
import routes from './routes';

import NProgress from 'nprogress';
NProgress.configure({ showSpinner: false }); // 关闭进度条圆环

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  // 开启进度条
  NProgress.start();

  // const result = isLogin();
  // const result = true;

  // // 用户已登录，自行进入登录和注册页面，不让进入，跳转回之前页面
  // if ((to.fullPath == '/login' || to.fullPath == '/register') && result) {
  //   // Message.warning('已登录，请勿重复登录与注册');
  //   next(from.fullPath);
  // }

  // // 判断用户进入的页面是否需要权限，未登录跳转登录页面，已登录放行用户
  // if (to.meta.requiresAuth) {
  //   if (result) {
  //     next();
  //   } else {
  //     // Message.warning('请先登录');
  //     next('/login');
  //   }
  // }

  next();
});

router.afterEach(() => {
  // 关闭进度条
  NProgress.done();
});

export const installRouter = (app: App<Element>) => {
  app.use(router);
};
export default router;
