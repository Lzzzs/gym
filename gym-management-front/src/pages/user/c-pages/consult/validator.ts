export const checkName = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入姓名`));

  // 中文和英文名称都可以
  if (
    !/^(?:[\u4e00-\u9fa5·]{2,16})$/.test(value) &&
    !/(^[a-zA-Z][a-zA-Z\s]{0,20}[a-zA-Z]$)/.test(value)
  ) {
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

export const checkContent = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入留言内容`));

  callback();
};
