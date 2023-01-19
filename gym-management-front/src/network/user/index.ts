import instance from '../index';

interface IData {
  a: number;
  b: string;
}

const test = instance<IData>({
  method: 'get',
  url: '/data',
});
