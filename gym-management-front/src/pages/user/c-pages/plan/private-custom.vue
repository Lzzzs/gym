<template>
  <user-page-layout title="私人订制">
    <el-image :src="img" class="mt-10"></el-image
  ></user-page-layout>

  <el-dialog
    v-model="dialogVisible"
    title="私人订制健身计划"
    width="30%"
    :close-on-click-modal="false"
    :close-on-press-escape="false"
    :show-close="false"
  >
    <el-form
      :model="customForm"
      label-width="100px"
      ref="customFormRef"
      :rules="rules"
      class="custom-form"
    >
      <el-form-item label="姓名" prop="name">
        <el-input v-model="customForm.name" />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model="customForm.phone" type="phone" />
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="customForm.age" type="number" />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="customForm.sex" placeholder="请选择性别">
          <el-option v-for="item in ['男', '女']" :label="item" :value="item" />
        </el-select>
      </el-form-item>
      <el-form-item label="身高" prop="height">
        <el-input v-model="customForm.height" type="number">
          <template #append>cm</template></el-input
        >
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input v-model="customForm.weight" type="number">
          <template #append>kg</template>
        </el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="handleConfirm(customFormRef)">
          确认
        </el-button>
        <el-button @click="handleCancel()"> 取消 </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import muscle from '@/assets/images/muscleBuilding.png';
import fat from '@/assets/images/fatReduction.png';
import { FormRules, FormInstance } from 'element-plus';

const dialogVisible = ref(true);
const customFormRef = ref();
const img = ref();

const rules = reactive<FormRules>({
  name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
  phone: [{ required: true, message: '请输入手机号码', trigger: 'blur' }],
  age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
  sex: [
    {
      required: true,
      message: '请选择性别',
      trigger: 'change',
    },
  ],
  height: [{ required: true, message: '请输入身高', trigger: 'blur' }],
  weight: [{ required: true, message: '请输入体重', trigger: 'blur' }],
});

const customForm = reactive({
  name: '',
  phone: '',
  age: '',
  sex: '',
  height: 0,
  weight: 0,
});

const handleConfirm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid) => {
    if (valid) {
      const res = BMI(customForm.height / 100, customForm.weight);
      if (res >= 20) {
        img.value = fat;
      } else {
        img.value = muscle;
      }
      dialogVisible.value = false;
    }
  });
};

const handleCancel = () => {
  dialogVisible.value = false;
};

function BMI(height: number, weight: number): number {
  return ((weight / height / height).toFixed(2) as any) * 1;
}
</script>

<style lang="less" scoped>
.custom-form {
  :deep(.el-form-item__label) {
    color: #000 !important;
  }
}
</style>
