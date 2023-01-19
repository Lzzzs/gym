import { instance } from './index';
import NProgress from 'nprogress';
import type { AxiosRequestConfig } from 'axios';

NProgress.configure({ showSpinner: false }); // 关闭进度条圆环

/**
 * 根据localStorage中的token生成对应后端响应的请求头
 * @param {*} config
 */
function generateAuthorizationHeader(config: AxiosRequestConfig) {
  const token = localStorage.getItem('token');

  if (token) {
    config.headers.Authorization = `Bearer ${JSON.parse(token)}`;
  }

  return config;
}

instance.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    // 开启进度条
    NProgress.start();
    // 添加请求头，里面放入与服务器约定好的格式
    return generateAuthorizationHeader(config);
  },
  (err) => {
    // Message.error(err);

    return Promise.reject(err);
  }
);
