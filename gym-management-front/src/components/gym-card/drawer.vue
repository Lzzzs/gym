<template>
  <el-drawer v-model="isShowDrawer" :title="title">
    <div class="drawer-detail">{{ data }}</div>
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

<style scoped>
.drawer-detail {
  line-height: 2;
}
</style>
