import instance from '../index';
import { IUser, IUpdatePassword, ILeaveWord } from '@/types/user/index';
import {
  IGymnasiumInfoRes,
  IReplyInfoRes,
  ICourseInfoRes,
  IGymnasiumSubscribeInfo,
} from './type';

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

export const getReplyInfo = (userId: string) => {
  return instance<IReplyInfoRes>({
    method: 'get',
    url: `getReplyInfo?userId=${userId}`,
  });
};

export const getCourseInfo = (page: number, limit: number) => {
  return instance<ICourseInfoRes>({
    method: 'get',
    url: `getCourseInfo?page=${page}&limit=${limit}`,
  });
};

export const saveGymnasiumSubscribe = (
  gymnasiumSubscribeInfo: IGymnasiumSubscribeInfo
) => {
  return instance({
    method: 'post',
    url: `saveGymnasiumSubscribe`,
    data: gymnasiumSubscribeInfo,
  });
};

export const getAllUser = () => {
  return instance<IUser[]>({
    method: 'get',
    url: `user/getAllUser`,
  });
};
