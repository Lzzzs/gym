<template>
  <user-page-layout title="健身房预约">
    <Cards
      btn-text="预约此健身房"
      :card-infos="cardInfos"
      @btn-click="handleBtnClick"
    ></Cards>

    <user-page-pagination
      :total="total"
      @page-change="handlePageChange"
    ></user-page-pagination>
  </user-page-layout>
</template>

<script setup lang="ts">
import Cards from '@/components/gym-card/container.vue';
import { ICardInfo } from '@/types/user/index';
import { getGymnasiumInfo } from '@/network/user/index';
import { IGymnasiumInfoRecords } from '@/network/user/type';

const total = ref(0);
const page = ref(1);
const limit = ref(4);
let cardInfos = reactive<ICardInfo[]>([]);

const handleBtnClick = (id: number) => {
  console.log(id);
};
const handlePageChange = (p: number) => {
  page.value = p;
};

watchEffect(() => {
  getGymnasiumInfo(page.value, limit.value).then((item) => {
    total.value = item.total;
    fillCardInfo(item.records);
  });
});

function fillCardInfo(records: IGymnasiumInfoRecords[]) {
  if (cardInfos.length !== 0) cardInfos.length = 0;

  records.forEach((item) => {
    const tmp: ICardInfo = {
      id: item.id,
      imgUrl: item.img,
      detailList: [
        { name: '场馆名称', value: item.name },
        { name: '场馆人数', value: item.totalnum + '' },
        { name: '剩余位置', value: item.totalnum - item.curnum + '' },
      ],
      detail: {
        text: item.detailText,
        imgs: item.detailImg.split(','),
      },
    };

    cardInfos.push(tmp);
  });
}
</script>

<style lang="less" scoped></style>
