<template>
  <div class="user-page-pagination flexc mt-20">
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      :current-page="currentPage"
      @current-change="pageChange"
      hide-on-single-page
    />
  </div>
</template>

<script setup lang="ts">
import { login } from '@/utils/loginUtil';

const { total } = defineProps({
  total: Number,
});

const pageSize = 4;
let currentPage = 1;

const pageChange = (page: number) => {
  console.log(page);
  currentPage = page;
};
</script>

<style scoped></style>
