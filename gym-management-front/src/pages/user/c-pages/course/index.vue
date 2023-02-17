<template>
  <user-page-layout title="课程查询与预约">
    <Cards
      btn-text="预约此课程"
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
import { getCourseInfo } from '@/network/user/index';
import { ICourseInfoRecords } from '@/network/user/type';

const total = ref(0);
const page = ref(1);
const limit = ref(4);
let cardInfos = reactive<ICardInfo[]>([]);

const handleBtnClick = (id: number) => {
  console.log(id);
};
const handlePageChange = (page: number) => {
  console.log(page);
};

watchEffect(() => {
  getCourseInfo(page.value, limit.value).then((item) => {
    total.value = item.total;
    fillCardInfo(item.records);
  });
});

function fillCardInfo(records: ICourseInfoRecords[]) {
  if (cardInfos.length !== 0) cardInfos.length = 0;

  records.forEach((item) => {
    const tmp: ICardInfo = {
      id: item.id,
      imgUrl: item.img,
      detail: {
        text: item.detailText,
      },
    };

    cardInfos.push(tmp);
  });
}
</script>

<style lang="less" scoped></style>
