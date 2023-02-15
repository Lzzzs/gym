import instance from '../index';
import { IUser, IUpdatePassword, ILeaveWord } from '@/types/user/index';

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

export const addLeaveWord = (leaveWordInfo: ILeaveWord) => {
  return instance({
    method: 'post',
    url: `/addLeaveWord`,
    data: leaveWordInfo,
  });
};
