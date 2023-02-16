export interface ICardInfo {
  id: number;
  imgUrl: string;
  detailList?: { name: string; value: string }[];
  detail: ICardInfoDetail;
}
export interface ICardInfoDetail {
  text: string;
  title?: string;
  imgs?: string[];
}

export interface IUser {
  id: string;
  username: string;
  name: string;
  address: string;
  createdTime: string;
  phone: string;
  role: '1' | '2';
  age: number;
}

export interface IUpdatePassword {
  id: string;
  oldPassword: string;
  newPassword: string;
}

export interface ILeaveWord {
  userId: string;
  phone: string;
  name: string;
  content: string;
}
