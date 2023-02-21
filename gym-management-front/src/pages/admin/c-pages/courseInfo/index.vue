<template>
  <admin-page-layout title="课程管理">
    <el-table :data="tableData" style="width: 100%" size="large" border>
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="name" label="课程名" />
      <el-table-column prop="detailText" label="课程详情" />
      <el-table-column label="课程图">
        <template #default="scope">
          <div class="flex items-center">
            <el-image :src="scope.row.img" fit="cover" />
          </div>
        </template>
      </el-table-column>
      <el-table-column
        prop="subscribeTime"
        label="预约时间"
        :formatter="formatterTime"
      />
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button link type="primary" @click="handleDelete(scope)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </admin-page-layout>
</template>

<script setup lang="ts">
import { ICourseInfoRecords } from '@/network/user/type';
import {
  getAllCourseSubscribe,
  deleteCourseSubscribe,
} from '@/network/user/index';
import dayjs from 'dayjs';

type TTable = ICourseInfoRecords & { username: string; subscribeTime: string };
const tableData: TTable[] = reactive([]);

getData();

const formatterTime = (row: any, column: any, cellValue: string) => {
  const times = cellValue.split(',');

  return (
    dayjs((times[0] as any) * 1).format('YY-MM-DD HH:mm:ss') +
    ' ~ ' +
    dayjs((times[1] as any) * 1).format('YY-MM-DD HH:mm:ss')
  );
};
const handleDelete = (scope: any) => {
  ElMessageBox.confirm('确定删除吗？', 'Warning', {
    confirmButtonText: 'OK',
    cancelButtonText: 'Cancel',
    type: 'warning',
  }).then(() => {
    deleteCourseSubscribe(scope.row.id).then(() => {
      ElMessage.success('删除成功');
      getData();
    });
  });
};

function getData() {
  tableData.length = 0;
  getAllCourseSubscribe().then((res) => {
    res.forEach((item) => {
      tableData.push({
        name: item.course.name,
        username: item.user.username,
        detailText: item.course.detailText,
        img: item.course.img,
        subscribeTime: item.subscribeTime,
        id: item.id,
      });
    });
  });
}
</script>

<style scoped></style>
