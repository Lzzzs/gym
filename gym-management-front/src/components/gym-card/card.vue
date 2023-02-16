<template>
  <div class="card box-border pl-5 pr-5">
    <div class="inner b b-bluegray rounded p-3">
      <el-image
        :src="cardInfo!.imgUrl"
        class="card-img"
        fit="cover"
        @click="viewDetail(cardInfo.id, cardInfo.detail)"
        style="width: 100%"
      />

      <ul class="card-detail mt-5 mb-5" v-if="cardInfo?.detailList">
        <li v-for="list in cardInfo!.detailList">
          {{ list.name }}: {{ list.value }}
        </li>
      </ul>

      <div class="card-btn mt-5">
        <el-button style="width: 100%" @click="btnClick(cardInfo.id)">{{
          btnText
        }}</el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ICardInfoDetail, ICardInfo } from '@/types/user';

const { btnText, cardInfo } = defineProps<{
  btnText: string;
  cardInfo: ICardInfo;
}>();

const emit = defineEmits<{
  (event: 'btnClick', id: number): void;
  (event: 'imgClick', id: number, detail: ICardInfoDetail): void;
}>();

const btnClick = (id: number) => {
  emit('btnClick', id);
};
const viewDetail = (id: number, detail: ICardInfoDetail) => {
  emit('imgClick', id, detail);
};
</script>

<style lang="less" scoped>
.card {
  width: 25%;

  .inner {
    box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.12);
    .card-img {
      height: 200px;
      cursor: pointer;
    }

    .card-detail {
      line-height: 1.75;
    }
  }
}
</style>
