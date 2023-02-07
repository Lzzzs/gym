import { ILoginResUser } from '@/network/login/type';

export function isLogin(): boolean {
  const token = localStorage.getItem('token');
  const refreshToken = localStorage.getItem('refreshToken');
  const user = localStorage.getItem('user');

  return token && refreshToken && user ? true : false;
}

export function logout() {
  localStorage.setItem('token', '');
  localStorage.setItem('refreshToken', '');
  localStorage.setItem('user', '');
}

export function login(
  token: string,
  refreshToken: string,
  user: ILoginResUser
) {
  localStorage.setItem('token', JSON.stringify(token));
  localStorage.setItem('refreshToken', JSON.stringify(refreshToken));
  localStorage.setItem('user', JSON.stringify(user));
}
