import axios, { RawAxiosRequestConfig } from 'axios';
import { requestSuccessHandler, requestErrorHandler } from './reqInterceptors';
import {
  responseSuccessHandler,
  responseErrorHandler,
} from './resInterceptors';

export const instance = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 10000,
});

instance.interceptors.request.use(requestSuccessHandler, requestErrorHandler);
instance.interceptors.response.use(
  responseSuccessHandler,
  responseErrorHandler
);

export default function <T>(config: RawAxiosRequestConfig): Promise<T> {
  return instance(config);
}
