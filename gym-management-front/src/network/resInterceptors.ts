import instance from './index';
import NProgress from 'nprogress';
import router from '@/router';
import codeMap from './ResultCode';
import { isJSON } from '@/utils/jsonUtil';
import type { AxiosResponse } from 'axios';
import { ElMessage } from 'element-plus';
import { fetchRefreshToken } from './login/index';
import { generateAuthorization } from '@/utils/tokenUtils';
import { logout } from '@/utils/loginUtil';

const successCode = 6666;

let isRefreshing = true;
let subscribers: (() => void)[] = [];

export function responseSuccessHandler(
  res: AxiosResponse
): Promise<AxiosResponse> {
  // 关闭进度条
  NProgress.done();

  const code = res.data.code;
  const message = res.data.message;

  if (!code) {
    ElMessage.error('网络错误');
    return Promise.reject(null);
  }

  // 错误信息都从接口获取
  if (code !== successCode) {
    // token过期处理
    if (code === 70002) {
      return handleExpiredToken(res);
    }

    // 配置前端配置的err映射表
    if (codeMap.has(code)) {
      // [errMessage, to?]
      const [errMessage, to] = codeMap.get(code);
      ElMessage.error(errMessage);

      // 如果需要跳转
      if (to !== '') {
        if (to === '/login') {
          /**
           * 跳转前 先把localStorage中关于用户的信息先删除
           * 因为在router.beforeEach拦截了关于用户有localStorage的信息无法跳转登录和注册页面
           */
          logout();
        }
        router.push(to);
      }
      return Promise.reject(errMessage);
    }

    ElMessage.error(message);
    // 返回reject 不进入到业务中的then函数回调中
    return Promise.reject(message);
  } else {
    return res.data.data;
  }
}

export function responseErrorHandler(err: any) {
  return Promise.reject(err);
}

function handleExpiredToken(res: AxiosResponse): Promise<AxiosResponse> {
  // 刷新token的函数,这需要添加一个开关，防止重复请求
  if (isRefreshing) {
    refreshTokenRequest();
  }
  isRefreshing = false;

  // 因为请求体中有数据，然后token失效之后，收集这个失败的请求，这个时候请求体的数据就会变成json格式，会影响到接口
  if (isJSON(res.config.data)) {
    res.config.data = JSON.parse(res.config.data);
  }
  // 这个Promise函数很关键
  const retryOriginalRequest: Promise<AxiosResponse> = new Promise(
    (resolve) => {
      addSubscriber(() => {
        // 更新最新的token，防止递归调用
        res.config.headers.Authorization = generateAuthorization();
        resolve(instance(res.config));
      });
    }
  );
  return retryOriginalRequest;
}

// 遍历执行需要执行的函数
function onAccessTokenFetched() {
  subscribers.forEach((callback) => {
    callback();
  });
  subscribers = [];
}

// 收集需要执行的函数
function addSubscriber(callback: () => void) {
  subscribers.push(callback);
}

function refreshTokenRequest(): void {
  const refreshToken = JSON.parse(localStorage.getItem('refreshToken')!);
  const userInfo = JSON.parse(localStorage.getItem('user')!);
  fetchRefreshToken({
    loginInfo: {
      username: userInfo.username,
    },
    refreshToken,
  }).then(({ refreshToken, token }) => {
    localStorage.setItem('refreshToken', JSON.stringify(refreshToken));
    localStorage.setItem('token', JSON.stringify(token));
    onAccessTokenFetched();
    isRefreshing = true;
  });
}
