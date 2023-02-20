<template>
  <admin-page-layout title="课程管理">
    <el-table :data="tableData" style="width: 100%" size="large" border>
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="name" label="课程名" />
      <el-table-column prop="detailText" label="课程详情" />
      <el-table-column prop="img" label="课程图" />
      <el-table-column prop="subscribeTime" label="预约时间" />
      <el-table-column fixed="right" label="操作" width="120">
        <!-- <template #default="scope">
          <el-button link type="primary" @click="handleUserUpdate(scope)"
            >修改</el-button
          >
          <el-button link type="primary" @click="handleUserDelete(scope)"
            >删除</el-button
          >
        </template> -->
      </el-table-column>
    </el-table>
  </admin-page-layout>
</template>

<script setup lang="ts">
import { ICourseInfoRecords } from '@/network/user/type';
import { getAllCourseSubscribe } from '@/network/user/index';

type TTable = ICourseInfoRecords & { username: string; subscribeTime: string };
const tableData: TTable[] = reactive([]);

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
</script>

<style scoped></style>
