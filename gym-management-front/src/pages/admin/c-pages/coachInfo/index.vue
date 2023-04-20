<template>
  <admin-page-layout title="教练信息管理（回复留言）">
    <el-table :data="tableData" style="width: 100%" size="large" border>
      <el-table-column prop="name" label="姓名" width="120" />
      <el-table-column prop="phone" label="手机号码" width="120" />
      <el-table-column prop="content" label="内容" />
      <el-table-column fixed="right" label="操作" width="100">
        <template #default="scope">
          <el-button link type="primary" @click="replyUser(scope)"
            >回复</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </admin-page-layout>

  <el-dialog
    v-model="dialogVisible"
    title="回复"
    width="30%"
    :before-close="beforeClose"
  >
    <el-input v-model="replyContent" type="textarea" />

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="handleCancel">取消</el-button>
        <el-button type="primary" @click="handleConfirm"> 确认 </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { getAllLeaveWord, replyLeaveWord } from '@/network/user/index';
import { ILeaveWordItem } from '@/network/user/type';

const tableData: ILeaveWordItem[] = reactive([]);
const dialogVisible = ref(false);
const replyContent = ref('');
const currentId = ref();

getData();

const replyUser = (scope: any) => {
  dialogVisible.value = true;
  currentId.value = scope.row.id;
};
const beforeClose = (done: () => void) => {
  replyContent.value = '';
  done();
};
const handleCancel = () => {
  dialogVisible.value = false;
  replyContent.value = '';
};
const handleConfirm = () => {
  console.log(currentId.value, replyContent.value);
  replyLeaveWord({
    id: currentId.value,
    replyContent: replyContent.value,
  }).then(() => {
    ElMessage.success('回复成功');
    getData();
  });

  dialogVisible.value = false;
};

function getData() {
  tableData.length = 0;
  getAllLeaveWord().then(({ list }) => {
    list.forEach((item) => {
      tableData.push(item);
    });
  });
}
</script>

<style scoped></style>
