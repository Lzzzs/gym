<template>
  <div
    class="user-page-header color-white flex items-center justify-between pl-32 pr-32"
  >
    <div>logo</div>
    <ul class="items flex">
      <li
        v-for="{ name, to } in headerItems"
        :key="name"
        class="cursor-pointer ml-6"
        @click="toPath(to)"
      >
        {{ name }}
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { headerItems } from './header-item';

const router = useRouter();

const toPath = (to: string) => {
  router.push(to);
};
</script>

<style lang="less" scoped>
.user-page-header {
  min-width: 1024px;
  background-color: #4338ca;
  height: 60px;
}
</style>
