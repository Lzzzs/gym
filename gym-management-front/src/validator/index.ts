const checkName = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入姓名`));

  // 中文和英文名称都可以
  // if (
  //   !/^(?:[\u4e00-\u9fa5·]{2,16})$/.test(value) &&
  //   !/(^[a-zA-Z][a-zA-Z\s]{0,20}[a-zA-Z]$)/.test(value)
  // ) {
  //   return callback(new Error('请输入正确的姓名'));
  // }

  callback();
};

const checkUserName = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入用户名`));

  // 中文和英文名称都可以
  if (value.length < 5) {
    return callback(new Error('用户名的长度不能少于5位'));
  }

  callback();
};

const checkPhone = (rule: any, value: any, callback: any) => {
  if (!value) callback();

  if (!/^(?:(?:\+|00)86)?1[3-9]\d{9}$/.test(value)) {
    return callback(new Error('请输入正确的手机号码'));
  }

  callback();
};

const checkAge = (rule: any, value: any, callback: any) => {
  if (!value) callback();

  if (!/^\d+$/.test(value) || value > 200 || value < 1) {
    return callback(new Error('请输入正确的年龄'));
  }

  callback();
};

export default {
  checkName,
  checkUserName,
  checkPhone,
  checkAge,
};
