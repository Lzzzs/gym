import instance from '../index';
import { IData } from './type';
import { IUser } from '@/types/user/index';

const baseURl = '/user';

export const updateUserById = (userInfo: IUser) => {
  return instance<IData>({
    method: 'put',
    url: `${baseURl}/updateUserById`,
    data: userInfo,
  });
};
