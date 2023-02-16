import {
  createRouter,
  createWebHistory,
  NavigationGuardNext,
} from 'vue-router';
import { App } from 'vue';
import routes from './routes';
import NProgress from 'nprogress';
import { isLogin, logout } from '@/utils/loginUtil';
import { getCurrentUser } from '@/utils/userUtil';
import { ElMessage } from 'element-plus';

NProgress.configure({ showSpinner: false }); // 关闭进度条圆环

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  // 开启进度条
  NProgress.start();

  const loginStatus = isLogin();

  const handle = handleRoute(next);

  // 用户已登录，自行进入登录和注册页面，不让进入，跳转回之前页面
  if ((to.fullPath == '/login' || to.fullPath == '/register') && loginStatus) {
    handle(from.fullPath, '已登录，请勿重复登录与注册');
    return;
  }

  // 判断用户进入的页面是否需要权限，未登录跳转登录页面，已登录放行用户
  if (to.meta.requiresAuth) {
    if (loginStatus) {
      const currentUser = getCurrentUser();
      // 如果访问admin页面，验证role是否为1
      if (to.fullPath.indexOf('/admin') !== -1) {
        if (currentUser!.role == '1') {
          next();
          return;
        } else {
          handle('/login', '权限不匹配', logout);
          return;
        }
      } else {
        // 访问用户页面，验证role是否为2
        if (currentUser!.role == '2') {
          next();
          return;
        } else {
          handle('/login', '权限不匹配', logout);
          return;
        }
      }
    } else {
      handle('/login', '请先登录');
      return;
    }
  }

  next();
});

router.afterEach(() => {
  // 关闭进度条
  NProgress.done();
});

// 科里化
function handleRoute(next: NavigationGuardNext) {
  return (nextUrl?: string | null, tip?: string | null, cb?: () => void) => {
    if (tip) ElMessage.warning(tip);
    if (cb) cb();
    nextUrl ? next(nextUrl) : next();
  };
}

export const installRouter = (app: App<Element>) => {
  app.use(router);
};
export default router;
