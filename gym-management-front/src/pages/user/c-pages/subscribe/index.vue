<template>
  <div class="ml-32 mr-32">
    <user-page-title title="健身房预约"></user-page-title>

    <Cards
      btn-text="预约此场馆"
      :card-infos="cardInfos"
      @btn-click="handleBtnClick"
    ></Cards>

    <user-page-pagination
      :total="5"
      @page-change="handlePageChange"
    ></user-page-pagination>
  </div>
</template>

<script setup lang="ts">
import Cards from '@/components/gym-card/container.vue';
import { ICardInfo } from '@/types/user/index';

const handleBtnClick = (id: number) => {
  console.log(id);
};
const handlePageChange = (page: number) => {
  console.log(page);
};

const cardInfos: ICardInfo[] = [
  {
    id: 1,
    imgUrl:
      'https://images.unsplash.com/photo-1675750318176-98573021fc30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1771&q=80',
    detailList: [
      {
        name: '场点',
        value: '21312312',
      },
      {
        name: '场馆人数',
        value: '200',
      },
      {
        name: '剩余位置',
        value: '180',
      },
    ],
  },
  {
    id: 2,
    imgUrl:
      'https://images.unsplash.com/photo-1675750318176-98573021fc30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1771&q=80',
    detailList: [
      {
        name: '场点',
        value: '22',
      },
      {
        name: '场馆人数',
        value: '600',
      },
      {
        name: '剩余位置',
        value: '180',
      },
    ],
  },
  {
    id: 3,
    imgUrl:
      'https://images.unsplash.com/photo-1675750318176-98573021fc30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1771&q=80',
    detailList: [
      {
        name: '场点',
        value: '22',
      },
      {
        name: '场馆人数',
        value: '600',
      },
      {
        name: '剩余位置',
        value: '180',
      },
    ],
  },
  {
    id: 4,
    imgUrl:
      'https://images.unsplash.com/photo-1675750318176-98573021fc30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1771&q=80',
    detailList: [
      {
        name: '场点',
        value: '22',
      },
      {
        name: '场馆人数',
        value: '600',
      },
      {
        name: '剩余位置',
        value: '180',
      },
    ],
  },
];
</script>

<style lang="less" scoped></style>
