<template>
  <user-page-layout title="咨询服务">
    <div class="flexc mt-10">
      <el-form
        label-position="top"
        label-width="100px"
        style="min-width: 460px"
        :model="consultForm"
        :rules="rules"
        ref="consultFormRef"
      >
        <el-form-item label="姓名" prop="name" :required="true">
          <el-input placeholder="请输入姓名" v-model="consultForm.name" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phone" :required="true">
          <el-input placeholder="请输入手机号码" v-model="consultForm.phone" />
        </el-form-item>
        <el-form-item label="留言框" prop="content" :required="true">
          <el-input
            :rows="5"
            type="textarea"
            placeholder="请输入文字给教练留言"
            v-model="consultForm.content"
          />
        </el-form-item>
        <el-form-item>
          <el-button @click="submit(consultFormRef)">提交</el-button>
        </el-form-item>
      </el-form>
    </div>
  </user-page-layout>
</template>

<script setup lang="ts">
import { ElMessage, FormInstance } from 'element-plus';
import { checkName, checkPhone, checkContent } from './validator';
import { addLeaveWord } from '@/network/user/index';
import { getCurrentUser } from '@/utils/userUtil';
import { emptyObj } from '@/utils/dataUtil';
import { ILeaveWord } from '@/types/user/index';

const consultFormRef = ref<FormInstance>();

const consultForm = reactive({
  name: '',
  phone: '',
  content: '',
});

const rules = reactive({
  name: [{ validator: checkName, trigger: 'blur' }],
  phone: [{ validator: checkPhone, trigger: 'blur' }],
  content: [{ validator: checkContent, trigger: 'blur' }],
});

const submit = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      const currentUser = getCurrentUser()!;
      const submitInfo: ILeaveWord = { ...consultForm, userId: currentUser.id };

      addLeaveWord(submitInfo).then(() => {
        emptyObj(consultForm);
        ElMessage.success('提交成功');
      });
    }
  });
};
</script>

<style lang="less" scoped></style>
