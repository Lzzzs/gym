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
import { getCourseInfo, saveCourseSubscribe } from '@/network/user/index';
import { ICourseInfoRecords, ICourseSubscribeInfo } from '@/network/user/type';
import { getCurrentUser } from '@/utils/userUtil';

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
  // dialogTitle.value =
  //   '预约课程-' +
  //   cardInfos.find((item) => item.id === id)?.detailList![0].value;
  dialogTitle.value = '预约课程';
};
const handlePageChange = (page: number) => {
  console.log(page);
};
const updateDisabled = (dialogStatus: boolean) => {
  disabled.value = dialogStatus;
};
const confirmSubscribe = (subscribeTimeForm: { time: string[] }) => {
  const currentUser = getCurrentUser()!;
  const submitForm: ICourseSubscribeInfo = {
    subscribeTime: subscribeTimeForm.time[0] + ',' + subscribeTimeForm.time[1],
    userId: currentUser.id,
    courseId: currentCardId.value,
  };
  saveCourseSubscribe(submitForm).then(() => {
    subscribeTimeForm.time.length = 0;
    ElMessage.success('预定成功');
  });
};

watchEffect(() => {
  getData();
});

function getData() {
  getCourseInfo(page.value, limit.value).then((item) => {
    total.value = item.total;
    fillCardInfo(item.records);
  });
}
function fillCardInfo(records: ICourseInfoRecords[]) {
  if (cardInfos.length !== 0) cardInfos.length = 0;

  records.forEach((item) => {
    const tmp: ICardInfo = {
      id: item.id,
      imgUrl: item.img,
      detail: {
        imgs: [item.detailText],
        text: ""
      },
    };

    cardInfos.push(tmp);
  });
}
</script>

<style lang="less" scoped></style>
