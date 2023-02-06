interface IUserInfo {
  username: string;
  password: string;
}

export interface ILoginForm extends IUserInfo {
  // 1 管理员 2 用户
  role: '1' | '2' | '';
}

export interface IRegisterForm extends IUserInfo {}

export interface IRefreshToken {
  loginInfo: { username: string };
  refreshToken: string;
}
