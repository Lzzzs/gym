<!-- container -->
<template>
  <div
    class="card-container flex flex-wrap -ml-5 -mr-5 mt-15"
    v-if="cardInfos?.length > 0"
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

  <drawer
    title="详细信息"
    data="教练10人，其中高级教练3人，位于广州番禺区海印又一城6楼，拥有动感单车、运动康复、身材管理、游泳健身、孕产康复等等
"
    ref="drawerRef"
  />
</template>

<script setup lang="ts">
import Card from './card.vue';
import drawer from './drawer.vue';

const drawerRef = ref<InstanceType<typeof drawer> | null>(null);

const { btnText, cardInfos } = defineProps({
  btnText: String,
  cardInfos: Object,
});

const emit = defineEmits<{
  (event: 'btnClick', id: number): void;
}>();

const handleBtnClick = (id: number) => {
  emit('btnClick', id);
};
const handleImgClick = () => {
  if (drawerRef.value) drawerRef.value.isShowDrawer = true;
};
</script>

<style lang="less" scoped>
.card-container {
  min-width: 1024px;
}
</style>
