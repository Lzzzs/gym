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
        <el-form-item label="姓名" prop="name">
          <el-input placeholder="请输入姓名" v-model="consultForm.name" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
          <el-input placeholder="请输入手机号码" v-model="consultForm.phone" />
        </el-form-item>
        <el-form-item label="留言框" prop="leaveWord">
          <el-input
            :rows="5"
            type="textarea"
            placeholder="请输入文字给教练留言"
            v-model="consultForm.leaveWord"
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
import { checkName, checkPhone, checkLeaveWord } from './validator';
import { FormInstance } from 'element-plus';

const consultFormRef = ref<FormInstance>();

const consultForm = reactive({
  name: '',
  phone: '',
  leaveWord: '',
});

const rules = reactive({
  name: [{ validator: checkName, trigger: 'change' }],
  phone: [{ validator: checkPhone, trigger: 'change' }],
  leaveWord: [{ validator: checkLeaveWord, trigger: 'change' }],
});

const submit = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      console.log('提交留言');
    }
  });
};
</script>

<style lang="less" scoped></style>
