/**
 * 错误代码是code
 * errMessage是错误代码对应的信息
 * to是要发生该错误时需要跳转的url，可选参数
 *
 * codeMap
 *    code: [errMessage, to？]
 */
const codeMap = new Map();

const codes = [
  [10001, '参数无效'],
  [10002, '参数为空'],
  [10003, '参数格式错误'],
  [10004, '参数缺失'],
  [20001, '用户未登录，请先登录', '/login'],
  [40001, '系统繁忙，请稍后重试'],
  [50001, '数据未找到'],
  [50002, '数据有误'],
  [50003, '数据已存在'],
  [60001, '接口请求超时'],
  [70001, '权限不足'],
  [70002, '登录状态过期，请重新登录'],
];

for (const item of codes) {
  codeMap.set(item[0], [item[1], item[2]]);
}

export default codeMap;
