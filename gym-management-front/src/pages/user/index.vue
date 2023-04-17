<template>
  <div class="user-page h-screen">
    <user-page-header></user-page-header>

    <RouterView />
  </div>
</template>

<script setup lang="ts">
import UserPageHeader from '@/components/user-page-header/index.vue';
</script>

<style lang="less" scoped>
.user-page {
  background-image: url('@/assets/images/bg.jpeg');
  background-size: 100%;

  :deep(.el-form-item__label) {
    color: #fff !important;
  }
}
</style>
