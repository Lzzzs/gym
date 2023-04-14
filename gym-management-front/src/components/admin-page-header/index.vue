<template>
  <div
    class="admin-page-header flex justify-between items-center px-10 color-white"
  >
    <div>Logo</div>
    <div class="flex">
      <div>{{ user?.username }}</div>
      <div @click="handleLogout" class="ml-5 cursor-pointer">退出登录</div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { logout } from '@/utils/loginUtil';
import { getCurrentUser } from '@/utils/userUtil';

const user = getCurrentUser();
const router = useRouter();

const handleLogout = () => {
  logout();
  router.push('/login');
};
</script>

<style scoped>
.admin-page-header {
  height: 60px;
  min-width: 1024px;
  background: #2e2b2b;
}
</style>
