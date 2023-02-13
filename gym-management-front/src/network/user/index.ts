import instance from '../index';
import { IUser, IUpdatePassword } from '@/types/user/index';

const baseURl = '/user';

export const updateUserById = (userInfo: IUser) => {
  return instance({
    method: 'put',
    url: `${baseURl}/updateUserById`,
    data: userInfo,
  });
};

export const updatePasswordById = (passwordInfo: IUpdatePassword) => {
  return instance({
    method: 'put',
    url: `${baseURl}/updatePasswordById`,
    data: passwordInfo,
  });
};
