import { UserPathType } from '@/router/routes';

export interface IHeaderItem {
  name: string;
  to: UserPathType | null;
}
export interface IHeaderItems extends IHeaderItem {
  list?: IHeaderItem[];
}
export const headerItems: IHeaderItems[] = [
  {
    name: '首页',
    to: 'index',
  },
  {
    name: '健身房预约',
    to: 'subscribe',
  },
  {
    name: '课程查询与预约',
    to: 'course',
  },
  {
    name: '咨询服务',
    to: 'consult',
  },
  {
    name: '健身计划查询',
    to: 'muscleBuilding',
    list: [
      {
        name: '增肌计划',
        to: 'muscleBuilding',
      },
      {
        name: '减脂计划',
        to: 'fatReduction',
      },
      {
        name: '私人订制计划',
        to: 'privateCustom',
      },
    ],
  },
  {
    name: '动作库',
    to: 'actionLibrary',
  },
  {
    name: '个人信息',
    to: 'personal',
  },
  {
    name: '退出登录',
    to: null,
  },
];
