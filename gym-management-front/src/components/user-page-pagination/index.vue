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
import { emitChangeFn } from 'element-plus';

const { total } = defineProps({
  total: Number,
});

const pageSize = 4;
let currentPage = ref(1);

const emits = defineEmits<{
  (event: 'page-change', curPage: number): void;
}>();

const pageChange = (page: number) => {
  currentPage.value = page;
  emits('page-change', page);
};
</script>

<style scoped></style>
