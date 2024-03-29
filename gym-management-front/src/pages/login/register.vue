<template>
  <div class="h-screen">
    <div class="register-page flexc h-screen">
      <div
        class="login-form p-10 b border-black border-rd-4 max-w-xl border-base"
      >
        <el-form
          :model="registerForm"
          label-width="100px"
          label-position="left"
          :rules="rules"
          ref="registerFormRef"
          style="min-width: 300px"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="registerForm.username" />
          </el-form-item>
          <el-form-item label="密码" prop="password" class="mt-6">
            <el-input
              v-model="registerForm.password"
              type="password"
              show-password
            />
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="registerForm.name" />
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input v-model="registerForm.age" type="number" />
          </el-form-item>
          <el-form-item label="电话号码" prop="phone">
            <el-input v-model="registerForm.phone" type="phone" />
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="registerForm.address" />
          </el-form-item>
          <el-button
            @click="handleRegister(registerFormRef)"
            type="primary"
            class="login-btn mt-6"
            >注册</el-button
          >
          <div class="flex justify-between mt-10">
            <el-link :underline="false" href="/login" style="color: #fff"
              >去登录</el-link
            >
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { FormRules, FormInstance, ElMessage } from 'element-plus';
import { fetchRegister } from '@/network/login/index';
import type { IRegisterForm } from '@/types/login/index';
import validator from '@/validator/index';

import router from '@/router';

const registerFormRef = ref<FormInstance>();

const registerForm = reactive<IRegisterForm>({
  username: '',
  password: '',
  name: '',
  age: 0,
  phone: '',
  address: '',
});

const rules = reactive<FormRules>({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 5, message: '用户名的长度不能少于5位', trigger: 'change' },
  ],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  name: [{ validator: validator.checkName, trigger: 'change' }],
  age: [{ validator: validator.checkAge, trigger: 'change' }],
  phone: [{ validator: validator.checkPhone, trigger: 'change' }],
});

const handleRegister = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid) => {
    if (valid) {
      fetchRegister(registerForm).then(() => {
        ElMessage.success('注册成功');
        router.push('/login');
      });
    }
  });
};
</script>

<style lang="less" scoped>
.register-page {
  background-image: url('@/assets/images/register.jpeg');
  background-size: 100%;

  :deep(.el-form-item__label) {
    color: #fff !important;
  }
}
.login-btn {
  width: 100%;
}
</style>
