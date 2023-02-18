<template>
  <el-menu
    active-text-color="#ffd04b"
    background-color="#4b5563"
    :default-active="defaultActive"
    text-color="#fff"
    @select="handleSidebarSelect"
  >
    <el-menu-item :index="adminPath.userInfo" class="px-10!">
      <el-icon><User /></el-icon>
      <span>用户信息管理</span>
    </el-menu-item>
    <el-menu-item :index="adminPath.coachInfo" class="px-10!">
      <el-icon><UserFilled /></el-icon>
      <span>教练信息管理</span>
    </el-menu-item>
    <el-menu-item :index="adminPath.gymInfo" class="px-10!">
      <el-icon><Place /></el-icon>
      <span>场馆位置管理</span>
    </el-menu-item>
    <el-menu-item :index="adminPath.courseInfo" class="px-10!">
      <el-icon><Suitcase /></el-icon>
      <span>课程管理</span>
    </el-menu-item>
    <el-menu-item :index="adminPath.passwordInfo" class="px-10!">
      <el-icon><Lock /></el-icon>
      <span>修改密码</span>
    </el-menu-item>
  </el-menu>
</template>

<script setup lang="ts">
import {
  User,
  UserFilled,
  Place,
  Suitcase,
  Lock,
} from '@element-plus/icons-vue';
import { adminPath } from '@/router/routes';

const router = useRouter();
const route = useRoute();

console.log(route);

const handleSidebarSelect = (key: string) => {
  router.push(`/admin/${key}`);
};

const defaultActive = computed(() => {
  return adminPath[route.path.split('/')[2] as keyof typeof adminPath];
});
</script>
<style scoped></style>
