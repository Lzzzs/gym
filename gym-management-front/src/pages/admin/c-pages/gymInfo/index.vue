<template>
  <admin-page-layout title="场馆位置管理">
    <el-table :data="tableData" style="width: 100%" size="large" border>
      <el-table-column prop="name" label="健身房名字" />
      <el-table-column prop="place" label="地点" />
      <el-table-column prop="curnum" label="当前人数" />
      <el-table-column prop="totalnum" label="总人数" />
    </el-table>
  </admin-page-layout>
</template>

<script setup lang="ts">
import { getGymnasiumInfo } from '@/network/user/index';

const tableData: {
  name: string;
  place: string;
  curnum: number;
  totalnum: number;
}[] = reactive([]);

getGymnasiumInfo().then((res) => {
  res.records.forEach((item) => {
    tableData.push({
      name: item.name,
      place: item.place,
      curnum: item.curnum,
      totalnum: item.totalnum,
    });
  });
});
</script>

<style scoped></style>
