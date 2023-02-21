<template>
  <admin-page-layout title="场馆位置管理">
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
      <!-- <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button link type="primary" @click="handleDelete(scope)"
            >删除</el-button
          >
        </template>
      </el-table-column> -->
    </el-table>
  </admin-page-layout>
</template>

<script setup lang="ts">
const tableData = reactive([]);
</script>

<style scoped></style>
