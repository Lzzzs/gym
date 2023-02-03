import instance from '../index';
import { IData } from './type';

const test = instance<IData>({
  method: 'get',
  url: '/data',
});
