<template>
  <div class="reply-item b border-gray mb-5 rounded p-3" v-if="isShowReplyItem">
    <div>内容：{{ itemData.content }}</div>
    <div>回复内容：{{ itemData.replyContent }}</div>
    <div>回复时间：{{ itemData.replyTime }}</div>
  </div>
</template>

<script setup lang="ts">
import { IReplyItem } from '@/network/user/type';
const { itemData } = defineProps<{
  itemData: IReplyItem;
}>();

const isShowReplyItem = computed(() => {
  return itemData.replyContent && itemData.replyTime;
});
</script>

<style scoped>
.reply-item {
  line-height: 1.5;
}
</style>
