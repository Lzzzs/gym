<template>
  <el-drawer v-model="isShowDrawer" :title="title">
    <span>{{ data }}</span>
  </el-drawer>
</template>

<script setup lang="ts">
const isShowDrawer = ref(false);

const { data, title } = defineProps({
  data: String,
  title: String,
});

defineExpose({
  isShowDrawer,
});
</script>

<style scoped></style>
