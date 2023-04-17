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
        <el-form-item label="姓名" prop="name" :required="true">
          <el-input
            v-model="personalForm.name"
            :disabled="disabledPersonalInfo"
          />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input
            v-model="personalForm.age"
            type="number"
            :disabled="disabledPersonalInfo"
          />
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input
            v-model="personalForm.phone"
            type="phone"
            :disabled="disabledPersonalInfo"
          />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input
            v-model="personalForm.address"
            :disabled="disabledPersonalInfo"
          />
        </el-form-item>
        <el-form-item class="mt-5">
          <el-button @click="savePersonal(personalFormRef)">保存</el-button>
          <el-button @click="disabledPersonalInfo = !disabledPersonalInfo"
            >修改信息</el-button
          >
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
        <el-form-item label="原密码" prop="oldPassword" :required="true">
          <el-input
            v-model="passwordForm.oldPassword"
            type="password"
            show-password
          />
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword" :required="true">
          <el-input
            v-model="passwordForm.newPassword"
            type="password"
            show-password
          />
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword" :required="true">
          <el-input
            v-model="passwordForm.confirmPassword"
            type="password"
            show-password
          />
        </el-form-item>
        <el-form-item class="mt-5">
          <el-button @click="savePasswords(passwordFormRef)">保存</el-button>
          <el-button
            @click="
              isShowPersonalInfo = true;
              disabledPersonalInfo = true;
            "
            >修改个人信息</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </user-page-layout>
</template>

<script setup lang="ts">
import { ElMessage, FormInstance } from 'element-plus';
import validator from './validator';
import { copy, emptyObj } from '@/utils/dataUtil';
import useUser from '@/hooks/useUser';
import { updateUserById, updatePasswordById } from '@/network/user/index';
import { IPersonalForm } from './type';
import { IUpdatePassword } from '@/types/user/index';

const isShowPersonalInfo = ref(true);
const disabledPersonalInfo = ref(true);

const personalFormRef = ref<FormInstance>();
const passwordFormRef = ref<FormInstance>();

const personalForm = reactive<IPersonalForm>({
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
  name: [{ validator: validator.checkName, trigger: 'change' }],
  age: [{ validator: validator.checkAge, trigger: 'change' }],
  phone: [{ validator: validator.checkPhone, trigger: 'change' }],
});
const passwordRules = reactive({
  oldPassword: [{ validator: validator.checkOldPassword, trigger: 'blur' }],
  newPassword: [{ validator: validator.checkNewPassword, trigger: 'blur' }],
  confirmPassword: [{ validator: validator.checkCfPassword, trigger: 'blur' }],
});

onMounted(() => {
  getCurrentUser();
});
const getCurrentUser = () => {
  const currentUser = useUser();
  if (!currentUser) return;
  copy(personalForm, currentUser);
};

const savePersonal = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      const currentUser = useUser();
      if (!currentUser) return;
      copy(currentUser, personalForm as any);
      updateUserById(currentUser).then(() => {
        // 更新
        localStorage.setItem('user', JSON.stringify(currentUser));
        ElMessage.success('保存成功');
      });
    }
  });
};
const savePasswords = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      const currentUser = useUser();
      if (!currentUser) return;
      const passwordInfo: IUpdatePassword = {
        id: currentUser.id,
        oldPassword: passwordForm.oldPassword,
        newPassword: passwordForm.newPassword,
      };

      updatePasswordById(passwordInfo).then(() => {
        ElMessage.success('修改成功');
        emptyObj(passwordForm);
      });
    }
  });
};
</script>

<style lang="less" scoped></style>
