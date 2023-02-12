<template>
  <div class="user-page-header flex items-center justify-between pl-32 pr-32">
    <div>logo</div>
    <ul class="items flex">
      <li
        v-for="{ name, to } in headerItems"
        :key="name"
        class="cursor-pointer ml-6"
        @click="toPath(to)"
        :class="curPath === to ? 'active' : ''"
      >
        {{ name }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { headerItems } from './header-item';
import { UserPathType } from '@/router/routes';

const router = useRouter();
const route = useRoute();

// substring 是为了去掉前缀/
const curPath = ref<UserPathType>(route.path.substring(1) as UserPathType);

const toPath = (to: UserPathType) => {
  router.push(to);
  curPath.value = to;
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
      color: #000;
      font-weight: bold;
    }
  }
}
</style>
