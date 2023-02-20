<template>
  <el-dialog
    v-model="dialogVisible"
    :title="dialogTitle"
    width="30%"
    :before-close="handleBeforeClose"
  >
    <el-form
      :model="personalForm"
      label-width="100px"
      label-position="top"
      style="min-width: 460px"
      ref="personalFormRef"
      :rules="personalRules"
    >
      <el-form-item label="用户名" prop="username" :required="true">
        <el-input v-model="personalForm.username" :disabled="isUpdate" />
      </el-form-item>
      <el-form-item label="姓名" prop="name" :required="true" v-if="isUpdate">
        <el-input v-model="personalForm.name" />
      </el-form-item>
      <el-form-item
        label="密码"
        prop="password"
        :required="true"
        v-if="!isUpdate"
      >
        <el-input
          v-model="personalForm.password"
          type="password"
          show-password
        />
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
      <el-form-item label="账号创建时间" prop="createdTime" v-if="isUpdate">
        <el-input v-model="personalForm.createdTime" disabled />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="handleCancel">取消</el-button>
        <el-button type="primary" @click="handleConfirm(personalFormRef)">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { IUser } from '@/types/user';
import validator from '@/validator/index';
import { FormInstance } from 'element-plus';

const dialogVisible = ref(false);
const dialogTitle = ref('');
const personalFormRef = ref<FormInstance>();
const isUpdate = ref(false);

const props = defineProps<{
  dialogStatus: boolean;
  userInfo: IUser | null;
}>();
const emit = defineEmits<{
  (event: 'updateDialogStatus', status: boolean): void;
  (event: 'confirm', personalForm: any, isUpdate: boolean): void;
}>();

const personalForm = reactive({
  id: '',
  username: '',
  name: '',
  age: null,
  phone: null,
  address: '',
  createdTime: '',
  password: '',
  role: 2,
});

const handleBeforeClose = (done: () => void) => {
  clearForm();
  done();
};
const handleConfirm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid) => {
    if (valid) {
      emit('confirm', personalForm, isUpdate.value);
    }
  });
};
const handleCancel = () => {
  clearForm();
  dialogVisible.value = false;
};

function clearForm() {
  Object.keys(personalForm).forEach((key) => {
    (personalForm as any)[key] = '';
  });
}

const personalRules = reactive({
  username: [{ validator: validator.checkUserName, trigger: 'change' }],
  name: [{ validator: validator.checkName, trigger: 'change' }],
  age: [{ validator: validator.checkAge, trigger: 'change' }],
  phone: [{ validator: validator.checkPhone, trigger: 'change' }],
});

watch(dialogVisible, (val) => {
  emit('updateDialogStatus', val);
});
watch(
  () => props.dialogStatus,
  (val) => {
    dialogVisible.value = val;
  }
);
watch(
  () => props.userInfo,
  (val) => {
    if (val) {
      // update
      Object.keys(personalForm).forEach((key) => {
        (personalForm as any)[key] = (val as any)[key];
      });
      dialogTitle.value = '修改用户信息';
      isUpdate.value = true;
    } else {
      // add
      clearForm();
      dialogTitle.value = '添加用户';
      isUpdate.value = false;
    }
  },
  {
    deep: true,
  }
);
</script>

<style scoped></style>
