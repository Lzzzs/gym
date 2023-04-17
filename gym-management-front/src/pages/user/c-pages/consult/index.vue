<template>
  <user-page-layout title="咨询服务">
    <div class="flexc mt-10 relative">
      <el-form
        label-position="top"
        label-width="100px"
        style="min-width: 460px"
        :model="consultForm"
        :rules="rules"
        ref="consultFormRef"
      >
        <el-form-item label="姓名" prop="name" :required="true">
          <el-input placeholder="请输入姓名" v-model="consultForm.name" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phone" :required="true">
          <el-input placeholder="请输入手机号码" v-model="consultForm.phone" />
        </el-form-item>
        <el-form-item label="留言框" prop="content" :required="true">
          <el-input
            :rows="5"
            type="textarea"
            placeholder="请输入文字给教练留言"
            v-model="consultForm.content"
          />
        </el-form-item>
        <el-form-item>
          <el-button @click="submit(consultFormRef)">提交</el-button>
        </el-form-item>
      </el-form>

      <div class="absolute right-0 top-0">
        <el-button @click="viewReplyInfo">查看回信</el-button>
        <div class="red-dot relative" v-show="!isRead"></div>
      </div>

      <el-drawer v-model="isShowDrawer" title="所有回信">
        <reply-item v-for="item in replyList" :itemData="item"></reply-item>
      </el-drawer>
    </div>
  </user-page-layout>
</template>

<script setup lang="ts">
import { ElMessage, FormInstance } from 'element-plus';
import { checkName, checkPhone, checkContent } from './validator';
import {
  addLeaveWord,
  getReplyInfoByUserId,
  changeReadStatus,
} from '@/network/user/index';
import { IReplyItem } from '@/network/user/type';
import { getCurrentUser } from '@/utils/userUtil';
import { emptyObj } from '@/utils/dataUtil';
import { ILeaveWord } from '@/types/user/index';
import replyItem from './c-cpns/reply-item.vue';
import useUser from '@/hooks/useUser';

const consultFormRef = ref<FormInstance>();
const isShowDrawer = ref(false);
const isRead = ref(true);
const replyList: IReplyItem[] = reactive([]);
const consultForm = reactive({
  name: '',
  phone: '',
  content: '',
});

const rules = reactive({
  name: [{ validator: checkName, trigger: 'blur' }],
  phone: [{ validator: checkPhone, trigger: 'blur' }],
  content: [{ validator: checkContent, trigger: 'blur' }],
});

const currentUser = getCurrentUser()!;
getReplyInfoByUserId(currentUser.id).then(({ list }) => {
  list.map((item) => {
    if (item.isRead === false) isRead.value = false;
    replyList.push(item);
  });
});

const submit = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;

  await formEl.validate((valid) => {
    if (valid) {
      const currentUser = getCurrentUser()!;
      const submitInfo: ILeaveWord = { ...consultForm, userId: currentUser.id };

      addLeaveWord(submitInfo).then(() => {
        emptyObj(consultForm);
        ElMessage.success('提交成功');
      });
    }
  });
};

const viewReplyInfo = () => {
  isShowDrawer.value = true;

  const user = useUser();
  if (!user) return;
  for (let i = 0; i < replyList.length; i++) {
    if (!replyList[i].isRead) {
      changeReadStatus(user.id);
      break;
    }
  }

  if (!isRead.value) isRead.value = true;
};
</script>

<style lang="less" scoped>
.red-dot {
  width: 5px;
  height: 5px;
  border-radius: 50%;
  background-color: red;
  top: -25px;
  right: -75px;
}
</style>
