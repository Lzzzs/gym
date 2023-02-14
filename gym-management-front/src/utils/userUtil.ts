import { IUser } from '@/types/user/index';

export function getCurrentUser(): IUser | null {
  const u = localStorage.getItem('user');
  if (!u) return null;

  const currentUser = JSON.parse(u);
  return currentUser;
}
