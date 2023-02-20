<template>
  <admin-page-layout title="修改密码">
    <el-form
      ref="passwordFormRef"
      :model="passwordForm"
      label-width="120px"
      :rules="rules"
    >
      <el-form-item label="原密码" prop="oldPassword" :required="true">
        <el-input v-model="passwordForm.oldPassword" type="password" show-password />
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword" :required="true">
        <el-input v-model="passwordForm.newPassword" type="password" show-password />
      </el-form-item>
      <el-form-item label="确认新密码" prop="confirmPassword" :required="true">
        <el-input v-model="passwordForm.confirmPassword" type="password" show-password />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit(passwordFormRef)"
          >提交</el-button
        >
      </el-form-item>
    </el-form>
  </admin-page-layout>
</template>

<script setup lang="ts">
import validator from '@/validator/index';
import { FormInstance } from 'element-plus';
import { updatePasswordById } from '@/network/user/index';
import { getCurrentUser } from '@/utils/userUtil';
import { emptyObj } from '@/utils/dataUtil';

const passwordFormRef = ref();
const passwordForm = reactive({
  oldPassword: '',
  newPassword: '',
  confirmPassword: '',
});
const rules = reactive({
  oldPassword: [{ validator: validator.checkOldPassword, trigger: 'blur' }],
  newPassword: [{ validator: validator.checkNewPassword, trigger: 'blur' }],
  confirmPassword: [{ validator: validator.checkCfPassword, trigger: 'blur' }],
});

const submit = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid) => {
    if (valid) {
      const user = getCurrentUser();
      const submitForm = {
        oldPassword: passwordForm.oldPassword,
        newPassword: passwordForm.newPassword,
        id: user!.id,
      };
      updatePasswordById(submitForm).then((res) => {
        ElMessage.success('修改成功');
        emptyObj(passwordForm);
      });
    }
  });
};
</script>

<style scoped></style>
