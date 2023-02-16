import instance from '../index';
import { IUser, IUpdatePassword, ILeaveWord } from '@/types/user/index';
import { IGymnasiumInfoRes } from './type';

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

export const getGymnasiumInfo = (page: number, limit: number) => {
  return instance<IGymnasiumInfoRes>({
    method: 'get',
    url: `getGymnasiumInfo?page=${page}&limit=${limit}`,
  });
};
