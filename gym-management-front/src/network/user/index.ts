import instance from '../index';
import { IUser, IUpdatePassword, ILeaveWord } from '@/types/user/index';
import {
  IGymnasiumInfoRes,
  IReplyInfoRes,
  ICourseInfoRes,
  IGymnasiumSubscribeInfo,
  ILeaveWordRes,
  IReplyInfo,
  ICourseSubscribeInfo,
  ICourseSubscribeRes,
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

export const getReplyInfoByUserId = (userId: string) => {
  return instance<IReplyInfoRes>({
    method: 'get',
    url: `getReplyInfoByUserId?userId=${userId}`,
  });
};

export const getAllLeaveWord = () => {
  return instance<ILeaveWordRes>({
    method: 'get',
    url: `getAllLeaveWord`,
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

export const deleteUserById = (id: string) => {
  return instance({
    method: 'delete',
    url: `user/deleteUserById?id=${id}`,
  });
};

export const addUserByUserInfo = (userInfo: IUser) => {
  return instance({
    method: 'post',
    url: `user/addUser`,
    data: userInfo,
  });
};

export const replyLeaveWord = (replyInfo: IReplyInfo) => {
  return instance({
    method: 'post',
    url: `replyLeaveWord`,
    data: replyInfo,
  });
};

export const saveCourseSubscribe = (
  courseSubscribeInfo: ICourseSubscribeInfo
) => {
  return instance({
    method: 'post',
    url: `saveCourseSubscribe`,
    data: courseSubscribeInfo,
  });
};

export const getAllCourseSubscribe = () => {
  return instance<ICourseSubscribeRes[]>({
    method: 'get',
    url: `getAllCourseSubscribe`,
  });
};

export const deleteCourseSubscribe = (id: number) => {
  return instance({
    method: 'delete',
    url: `deleteCourseSubscribe/${id}`,
  });
};
