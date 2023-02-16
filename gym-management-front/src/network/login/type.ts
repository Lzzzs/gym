import { IUser } from '@/types/user/index';

interface IToken {
  token: string;
  refreshToken: string;
}

export interface ILoginRes extends IToken {
  user: IUser;
}
export interface IRefreshTokenRes extends IToken {}
