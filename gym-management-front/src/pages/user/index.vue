<template>
  <div class="user-page">
    <user-page-header></user-page-header>

    <RouterView />
  </div>
</template>

<script setup lang="ts">
import UserPageHeader from '@/components/user-page-header/index.vue';
const router = useRouter();

router.push('/subscribe');
</script>

<style lang="less" scoped></style>
