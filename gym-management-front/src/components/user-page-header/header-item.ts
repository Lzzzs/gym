import { UserPathType } from '@/router/routes';

export interface IHeaderItems {
  name: string;
  to: UserPathType;
}
export const headerItems: IHeaderItems[] = [
  {
    name: '健身房预约',
    to: 'subscribe',
  },
  {
    name: '线上课程',
    to: 'course',
  },
  {
    name: '咨询服务',
    to: 'consult',
  },
  {
    name: '健身计划查询',
    to: 'plan',
  },
  {
    name: '动作库',
    to: 'actionLibrary',
  },
  {
    name: '个人信息',
    to: 'personal',
  },
];
