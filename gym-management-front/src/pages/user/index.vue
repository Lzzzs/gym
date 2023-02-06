<template>
  <div class="user-page">
    <user-page-header></user-page-header>

    <RouterView />
  </div>
</template>

<script setup lang="ts">
import UserPageHeader from '@/components/user-page-header/index.vue';
import { test } from '@/network/login/index';
const router = useRouter();

test().then((res) => {
  console.log(res);
});

// router.push('/login');
</script>

<style lang="less" scoped></style>
