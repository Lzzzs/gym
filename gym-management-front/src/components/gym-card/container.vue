<!-- container -->
<template>
  <div
    class="card-container flex flex-wrap -ml-5 -mr-5 mt-20"
    v-if="cardInfos?.length > 0"
  >
    <Card
      v-for="item in cardInfos"
      :btnText="btnText"
      :cardInfo="item"
      @btnClick="handleBtnClick"
    ></Card>
  </div>

  <div v-else>
    <el-empty description="没有数据" :image-size="200" />
  </div>
</template>

<script setup lang="ts">
import Card from './card.vue';

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
</script>

<style lang="less" scoped>
.card-container {
  min-width: 1024px;
}
</style>
