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

  <subscribe-time-dialog
    :disabled="disabled"
    @updateDisabled="updateDisabled"
    @confirmSubscribe="confirmSubscribe"
    :title="dialogTitle"
  ></subscribe-time-dialog>
</template>

<script setup lang="ts">
import Cards from '@/components/gym-card/container.vue';
import { ICardInfo } from '@/types/user/index';
import { getGymnasiumInfo, saveGymnasiumSubscribe } from '@/network/user/index';
import {
  IGymnasiumInfoRecords,
  IGymnasiumSubscribeInfo,
} from '@/network/user/type';
import { getCurrentUser } from '@/utils/userUtil';
import { ElMessage } from 'element-plus';

const total = ref(0);
const page = ref(1);
const limit = ref(4);
const disabled = ref(false);
const dialogTitle = ref('');
const currentCardId = ref(0);
let cardInfos = reactive<ICardInfo[]>([]);

const handleBtnClick = (id: number) => {
  currentCardId.value = id;
  disabled.value = true;
  dialogTitle.value =
    '预约健身房-' +
    cardInfos.find((item) => item.id === id)?.detailList![0].value;
};
const handlePageChange = (p: number) => {
  page.value = p;
};
const updateDisabled = (dialogStatus: boolean) => {
  disabled.value = dialogStatus;
};
const confirmSubscribe = (subscribeTimeForm: { time: string[] }) => {
  const currentUser = getCurrentUser()!;
  const submitForm: IGymnasiumSubscribeInfo = {
    subscribeTime: subscribeTimeForm.time[1],
    userId: currentUser.id,
    gymnasiumId: currentCardId.value,
  };
  saveGymnasiumSubscribe(submitForm).then(() => {
    subscribeTimeForm.time.length = 0;
    ElMessage.success('预定成功');
    getData();
  });
};

watchEffect(() => {
  getData();
});

function getData() {
  getGymnasiumInfo(page.value, limit.value).then((item) => {
    total.value = item.total;
    fillCardInfo(item.records);
  });
}
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
