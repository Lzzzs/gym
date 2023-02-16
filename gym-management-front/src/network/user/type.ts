export interface IGymnasiumInfoRes {
  records: IGymnasiumInfoRecords[];
  total: number;
}

export interface IGymnasiumInfoRecords {
  id: number;
  curnum: number;
  totalnum: number;
  detailImg: string;
  detailText: string;
  img: string;
  place: string;
  name: string;
}

export interface ICourseInfoRes {
  records: ICourseInfoRecords[];
  total: number;
}

export interface ICourseInfoRecords {
  id: number;
  img: string;
  detailText: string;
}

export interface IReplyInfoRes {
  list: IReplyItem[];
}

export interface IReplyItem {
  content: string;
  replyContent: string;
  replyTime: string;
}
