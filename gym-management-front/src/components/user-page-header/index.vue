<template>
  <div class="user-page-header flex items-center justify-between pl-32 pr-32">
    <div>logo</div>
    <ul class="items flex">
      <li
        v-for="{ name, to, list } in headerItems"
        :key="name"
        class="cursor-pointer ml-6"
        @click="toPath(to, list)"
        :class="isActive(to)"
      >
        <span v-if="!list">{{ name }}</span>
        <el-dropdown v-else>
          <span style="font-size: 16px">
            {{ name }}
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item
                v-for="{ name, to } in list"
                @click="dropdownItemClick(to)"
                >{{ name }}</el-dropdown-item
              >
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { logout } from '@/utils/loginUtil';
import { headerItems } from './header-item';
import { UserPathType } from '@/router/routes';

const router = useRouter();
const route = useRoute();

// substring 是为了去掉前缀/
const curPath = ref<UserPathType>(route.path.substring(1) as UserPathType);

const isActive = computed(() => {
  return (to: UserPathType | null) => {
    const baseClass = 'flex items-center';
    return curPath.value === to ? `active ${baseClass}` : `${baseClass}`;
  };
});

const toPath = (to: UserPathType | null, list: any) => {
  if (list) return;
  if (to === null) {
    logout();
    router.push('login');
    return;
  }

  router.push(to);
  curPath.value = to;
};
const dropdownItemClick = (to: UserPathType | null) => {
  if (to === null) return;
  router.push(to);
  curPath.value = 'muscleBuilding';
};
</script>

<style lang="less" scoped>
.user-page-header {
  min-width: 1024px;
  background-color: #a3a2a3;
  height: 60px;

  .items {
    li {
      color: #525252;
    }
    .active {
      span {
        color: #000;
        font-weight: bold;
      }
    }
  }
}
</style>
