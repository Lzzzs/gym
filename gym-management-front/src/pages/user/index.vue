<template>
  <div class="user-page">
    <user-page-header></user-page-header>

    <RouterView />
  </div>
</template>

<script setup lang="ts">
import UserPageHeader from '@/components/user-page-header/index.vue';
</script>

<style lang="less" scoped></style>
