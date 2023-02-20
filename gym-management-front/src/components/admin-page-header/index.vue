<template>
  <div
    class="admin-page-header flex justify-between items-center px-10 color-white"
  >
    <div>Logo</div>
    <div>{{ user?.username }}</div>
  </div>
</template>

<script setup lang="ts">
import { getCurrentUser } from '@/utils/userUtil';

const user = getCurrentUser();
</script>

<style scoped>
.admin-page-header {
  height: 60px;
  min-width: 1024px;
  background: #2e2b2b;
}
</style>
