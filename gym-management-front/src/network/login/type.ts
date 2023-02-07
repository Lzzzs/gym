export interface ILoginResUser {
  username: string;
  role: '1' | '2' | '';
  createdTime: string;
}

interface IToken {
  token: string;
  refreshToken: string;
}

export interface ILoginRes extends IToken {
  user: ILoginResUser;
}
export interface IRefreshTokenRes extends IToken {}
