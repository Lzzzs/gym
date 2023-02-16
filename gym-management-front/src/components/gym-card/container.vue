<!-- container -->
<template>
  <div
    class="card-container flex flex-wrap -ml-5 -mr-5 mt-15"
    v-if="cardInfos.length > 0"
  >
    <Card
      v-for="item in cardInfos"
      :btnText="btnText"
      :cardInfo="item"
      @btnClick="handleBtnClick"
      @img-click="handleImgClick"
    ></Card>
  </div>

  <div v-else>
    <el-empty description="没有数据" :image-size="200" />
  </div>

  <drawer :title="drawerTitle" :data="drawerData" ref="drawerRef" />
</template>

<script setup lang="ts">
import Card from './card.vue';
import drawer from './drawer.vue';
import { ICardInfo, ICardInfoDetail } from '@/types/user/index';

const drawerRef = ref<InstanceType<typeof drawer> | null>(null);
const drawerTitle = ref('详细信息');
const drawerData = ref<ICardInfoDetail | null>(null);

const { btnText, cardInfos } = defineProps<{
  btnText: string;
  cardInfos: ICardInfo[];
}>();

const emit = defineEmits<{
  (event: 'btnClick', id: number): void;
}>();

const handleBtnClick = (id: number) => {
  emit('btnClick', id);
};
const handleImgClick = (id: number, detail: ICardInfoDetail) => {
  if (drawerRef.value) {
    drawerData.value = detail;
    drawerRef.value.isShowDrawer = true;
  }
};
</script>

<style lang="less" scoped>
.card-container {
  min-width: 1024px;
}
</style>
