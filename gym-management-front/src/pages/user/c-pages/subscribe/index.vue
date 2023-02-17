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

  <el-dialog v-model="dialogVisible" title="预约健身房" width="40%">
    <el-form :model="subscribeTimeForm">
      <el-form-item label="预约时间" prop="subscribeTimeForm.time">
        <el-date-picker
          v-model="subscribeTimeForm.time as any"
          format="YYYY/MM/DD hh:mm:ss"
          value-format="x"
          placeholder="请选择预约时间"
          type="datetimerange"
          range-separator="to"
          start-placeholder="开始时间"
          end-placeholder="结束时间"
          :disabled-date="disabledDate"
        />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleSubscribe"> Confirm </el-button>
      </span>
    </template>
  </el-dialog>
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
const dialogVisible = ref(false);
const currentCardId = ref(0);
let cardInfos = reactive<ICardInfo[]>([]);
let subscribeTimeForm = reactive({
  time: [],
});

const handleBtnClick = (id: number) => {
  currentCardId.value = id;
  dialogVisible.value = true;
};
const handlePageChange = (p: number) => {
  page.value = p;
};
const handleSubscribe = () => {
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
  dialogVisible.value = false;
};
// 设置用户不能选择之前的时间
const disabledDate = (time: Date) => {
  return time.getTime() < Date.now();
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
