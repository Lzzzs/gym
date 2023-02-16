<template>
  <el-drawer v-model="isShowDrawer" :title="title">
    <div class="drawer-detail">
      <span class="text">{{ data?.text }}</span>
      <div class="imgs" v-if="data?.imgs">
        <el-image
          :src="img"
          fit="cover"
          style="width: 100%"
          v-for="img in data.imgs"
        />
      </div>
    </div>
  </el-drawer>
</template>

<script setup lang="ts">
import { ICardInfoDetail } from '@/types/user/index';

const isShowDrawer = ref(false);

const { data, title } = defineProps<{
  data: ICardInfoDetail | null;
  title: string;
}>();

defineExpose({
  isShowDrawer,
});
</script>

<style scoped>
.drawer-detail {
  line-height: 2;
}
</style>
