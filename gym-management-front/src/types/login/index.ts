export interface ILoginForm {
  username: string;
  password: string;
  // 1 管理员 2 用户
  role: 1 | 2 | '';
}
