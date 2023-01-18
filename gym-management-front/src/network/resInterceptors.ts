import { instance } from './index';

import type { AxiosResponse } from 'axios';

instance.interceptors.response.use(
  (res: AxiosResponse) => {
    return res.data;
  },
  () => {}
);
