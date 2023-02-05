import instance from '../index';
import type { ILogin } from './type';
import type { ILoginForm } from '@/types/login/index';

export const fetchLogin = (loginInfo: ILoginForm) => {
  return instance<ILogin>({
    method: 'post',
    url: '/data',
    data: loginInfo,
  });
};
