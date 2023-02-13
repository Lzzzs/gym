import { IUser } from '@/types/user/index';

export default function (): IUser | false {
  const user = localStorage.getItem('user');
  if (!user) {
    console.error('localStorage user对象不存在');
    return false;
  }
  const currentUser: IUser = JSON.parse(user);
  return currentUser;
}
