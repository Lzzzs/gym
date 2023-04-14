<template>
  <div class="flex justify-center mt-20">
    <el-carousel :interval="5000" style="height: 650px; width: 800px">
      <el-carousel-item
        v-for="item in items"
        style="height: 650px; width: 800px; text-align: center"
        :key="item"
      >
        <img :src="item" style="object-fit: contain; height: 650px" />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script setup lang="ts">
const items = [
  'http://localhost:8888/static/imgs/gym/one-title.jpeg',
  'http://localhost:8888/static/imgs/gym/two-title.jpeg',
  'http://localhost:8888/static/imgs/gym/three-title.jpeg',
  'http://localhost:8888/static/imgs/gym/four-title.jpeg',
];
</script>

<style scoped></style>
