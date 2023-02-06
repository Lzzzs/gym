import instance from '../index';
import type { ILoginRes, IRefreshTokenRes } from './type';
import type {
  ILoginForm,
  IRegisterForm,
  IRefreshToken,
} from '@/types/login/index';

export const fetchLogin = (loginInfo: ILoginForm) => {
  return instance<ILoginRes>({
    method: 'post',
    url: 'user/login',
    data: loginInfo,
  });
};

export const fetchRegister = (registerInfo: IRegisterForm) => {
  return instance({
    method: 'post',
    url: 'user/register',
    data: registerInfo,
  });
};

export const fetchRefreshToken = (refreshTokenInfo: IRefreshToken) => {
  return instance<IRefreshTokenRes>({
    method: 'post',
    url: 'user/refresh-token',
    data: refreshTokenInfo,
    headers: {
      Authorization:
        'Bearer ' + JSON.parse(localStorage.getItem('refreshToken')!),
    },
  });
};

export const test = () => {
  return instance({
    url: 'test',
  });
};
