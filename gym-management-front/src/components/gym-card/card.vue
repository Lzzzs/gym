<template>
  <div class="card box-border pl-5 pr-5">
    <div class="inner b b-bluegray rounded p-3">
      <el-image
        :src="cardInfo!.imgUrl"
        class="card-img"
        fit="cover"
        @click="viewDetail"
      />

      <ul
        class="card-detail mt-5 mb-5"
        v-if="cardInfo!.detailList.length !== 0"
      >
        <li v-for="list in cardInfo!.detailList">
          {{ list.name }}: {{ list.value }}
        </li>
      </ul>

      <div class="card-btn mt-5">
        <el-button style="width: 100%" @click="btnClick(cardInfo!.id)">{{
          btnText
        }}</el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const { btnText, cardInfo } = defineProps({
  btnText: String,
  cardInfo: Object,
});

const emit = defineEmits<{
  (event: 'btnClick', id: number): void;
  (event: 'imgClick'): void;
}>();

const btnClick = (id: number) => {
  emit('btnClick', id);
};
const viewDetail = () => {
  emit('imgClick');
};
</script>

<style lang="less" scoped>
.card {
  width: 25%;

  .inner {
    box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.12);
    .card-img {
      height: 200px;
    }

    .card-detail {
      line-height: 1.75;
    }
  }
}
</style>
