<template>
  <div class="video-content-title">{{ title }}</div>
  <el-scrollbar>
    <div class="flex my-5">
      <div v-for="(item, index) in videos" :key="index">
        <video controls class="video">
          <source :src="item" type="video/mp4" />
        </video>
      </div>
    </div>
  </el-scrollbar>
</template>

<script setup lang="ts">
const { videos, title } = defineProps({
  videos: Array<string>,
  title: String,
});
</script>

<style scoped>
.video-content-title {
  font-size: 20px;
  font-weight: 600;
}
.video {
  object-fit: cover;
  width: 300px;
  height: 300px;
  margin-right: 40px;
}
</style>
