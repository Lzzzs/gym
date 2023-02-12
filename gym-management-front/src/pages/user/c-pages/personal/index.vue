<template>
  <user-page-layout title="个人信息">
    <div class="flexc">
      <el-form
        :model="personalForm"
        label-width="100px"
        label-position="top"
        style="min-width: 460px"
        :rules="personalRules"
        ref="personalFormRef"
        v-show="isShowPersonalInfo"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="personalForm.name" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="personalForm.age" type="number" />
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="personalForm.phone" type="phone" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="personalForm.address" />
        </el-form-item>
        <el-form-item class="mt-5">
          <el-button @click="savePersonal(personalFormRef)">保存</el-button>
          <el-button @click="isShowPersonalInfo = false">修改密码</el-button>
        </el-form-item>
      </el-form>

      <el-form
        :model="passwordForm"
        label-width="100px"
        label-position="top"
        style="min-width: 460px"
        :rules="passwordRules"
        ref="passwordFormRef"
        v-show="!isShowPersonalInfo"
      >
        <el-form-item label="原密码" prop="oldPassword">
          <el-input v-model="passwordForm.oldPassword" type="password" />
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword">
          <el-input v-model="passwordForm.newPassword" type="password" />
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input v-model="passwordForm.confirmPassword" type="password" />
        </el-form-item>
        <el-form-item class="mt-5">
          <el-button @click="savePasswords(passwordFormRef)">保存</el-button>
          <el-button @click="isShowPersonalInfo = true">修改个人信息</el-button>
        </el-form-item>
      </el-form>
    </div>
  </user-page-layout>
</template>

<script setup lang="ts">
import { FormInstance } from 'element-plus';
import {
  checkName,
  checkPhone,
  checkAge,
  checkOldPassword,
  checkNewPassword,
  checkCfPassword,
} from './validator';

const isShowPersonalInfo = ref(true);

const personalFormRef = ref<FormInstance>();
const passwordFormRef = ref<FormInstance>();

const personalForm = reactive({
  name: '',
  age: null,
  phone: null,
  address: '',
});
const passwordForm = reactive({
  oldPassword: '',
  newPassword: '',
  confirmPassword: '',
});

const personalRules = reactive({
  name: [{ validator: checkName, trigger: 'change' }],
  age: [{ validator: checkAge, trigger: 'change' }],
  phone: [{ validator: checkPhone, trigger: 'change' }],
});
const passwordRules = reactive({
  oldPassword: [{ validator: checkOldPassword, trigger: 'blur' }],
  newPassword: [{ validator: checkNewPassword, trigger: 'blur' }],
  confirmPassword: [{ validator: checkCfPassword, trigger: 'blur' }],
});

const savePersonal = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      console.log('savePersonal', personalForm);
    }
  });
};
const savePasswords = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      console.log('savePasswords', passwordForm);
    }
  });
};
</script>

<style lang="less" scoped></style>
