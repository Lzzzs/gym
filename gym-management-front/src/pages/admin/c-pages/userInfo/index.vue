<template>
  <admin-page-layout title="用户信息管理">
    <div class="flex justify-end mb-5">
      <el-button @click="addUser">添加用户</el-button>
    </div>
    <el-table :data="tableData" style="width: 100%" size="large" border>
      <el-table-column fixed prop="username" label="用户名" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="phone" label="手机号码" />
      <el-table-column prop="address" label="地址" width="300" />
      <el-table-column prop="createdTime" label="账号创建时间" />
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button link type="primary" @click="handleUserUpdate(scope)"
            >修改</el-button
          >
          <el-button link type="primary" @click="handleUserDelete(scope)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <user-info-dialog
      :dialog-status="userInfoDialogStatus"
      @updateDialogStatus="updateDialogStatus"
      :userInfo="userInfo"
      @confirm="confirm"
    ></user-info-dialog>
  </admin-page-layout>
</template>

<script setup lang="ts">
import {
  getAllUser,
  updateUserById,
  deleteUserById,
  addUserByUserInfo,
} from '@/network/user';
import { IUser } from '@/types/user';
import userInfoDialog from './c-cpns/user-info-dialog.vue';

const tableData: IUser[] = reactive([]);
let userInfo: IUser | null = reactive({} as IUser);
const userInfoDialogStatus = ref(false);

getData();

const handleUserUpdate = (scope: { row: IUser }) => {
  if (userInfo === null) userInfo = reactive({} as IUser);
  Object.keys(scope.row).forEach((key) => {
    (userInfo as any)[key] = (scope.row as any)[key];
  });
  userInfoDialogStatus.value = true;
};
const handleUserDelete = (scope: any) => {
  ElMessageBox.confirm('确定删除吗？', 'Warning', {
    confirmButtonText: 'OK',
    cancelButtonText: 'Cancel',
    type: 'warning',
  }).then(() => {
    deleteUserById(scope.row.id).then(() => {
      ElMessage.success('删除成功');
      getData();
    });
  });
};
const addUser = () => {
  userInfoDialogStatus.value = true;
  userInfo = null;
};
const updateDialogStatus = (status: boolean) => {
  userInfoDialogStatus.value = status;
};
const confirm = (form: IUser, isUpdate: boolean) => {
  if (isUpdate) {
    updateUserById(form).then(() => {
      ElMessage.success('修改成功');
      userInfoDialogStatus.value = false;
      getData();
    });
  } else {
    // add
    console.log(form);
    addUserByUserInfo(form).then(() => {
      ElMessage.success('添加成功');
      userInfoDialogStatus.value = false;
      getData();
    });
  }
};

function getData() {
  tableData.length = 0;
  getAllUser().then((res) => {
    res.forEach((item) => {
      item.age == 0 ? (item.age = null) : (item.age = item.age);
      tableData.push(item);
    });
  });
}
</script>

<style scoped></style>
