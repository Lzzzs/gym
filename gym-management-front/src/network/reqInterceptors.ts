import { instance } from './index';

import type { AxiosRequestConfig } from 'axios';

instance.interceptors.request.use(
  (config: AxiosRequestConfig) => {
    return config;
  },
  () => {}
);
