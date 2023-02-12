export const checkName = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入姓名`));

  if (!/^(?:[\u4e00-\u9fa5·]{2,16})$/.test(value)) {
    return callback(new Error('请输入正确的姓名'));
  }

  callback();
};

export const checkPhone = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入手机号码`));

  if (!/^(?:(?:\+|00)86)?1[3-9]\d{9}$/.test(value)) {
    return callback(new Error('请输入正确的手机号码'));
  }

  callback();
};

export const checkLeaveWord = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入留言内容`));

  callback();
};
