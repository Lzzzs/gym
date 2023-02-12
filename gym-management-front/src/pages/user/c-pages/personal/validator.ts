export const checkName = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入姓名`));

  if (!/^(?:[\u4e00-\u9fa5·]{2,16})$/.test(value)) {
    return callback(new Error('请输入正确的姓名'));
  }

  callback();
};

export const checkPhone = (rule: any, value: any, callback: any) => {
  if (!value) callback();

  if (!/^(?:(?:\+|00)86)?1[3-9]\d{9}$/.test(value)) {
    return callback(new Error('请输入正确的手机号码'));
  }

  callback();
};

export const checkAge = (rule: any, value: any, callback: any) => {
  if (!value) callback();

  if (!/^\d+$/.test(value) || value > 200 || value < 1) {
    return callback(new Error('请输入正确的年龄'));
  }

  callback();
};

// password
export const checkOldPassword = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入密码`));

  callback();
};

let curPassword = '';
export const checkNewPassword = (rule: any, value: any, callback: any) => {
  if (!value) return callback(new Error(`请输入密码`));
  curPassword = value;
  callback();
};
export const checkCfPassword = (rule: any, value: any, callback: any) => {
  if (curPassword !== value) return callback(new Error(`两次输入的密码不一致`));

  callback();
};
