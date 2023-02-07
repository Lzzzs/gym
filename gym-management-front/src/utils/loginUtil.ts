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
