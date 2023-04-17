<template>
  <div class="pl-32 pr-32 actionLibrary">
    <user-page-title title="动作库"></user-page-title>
    <video-content :videos="bei" title="背"></video-content>
    <video-content :videos="fu" title="腹"></video-content>
    <video-content :videos="gongertouji" title="肱二头肌"></video-content>
    <video-content :videos="gongsantouji" title="肱三头肌"></video-content>
    <video-content :videos="tui" title="腿"></video-content>
    <video-content :videos="xiong" title="胸"></video-content>
  </div>
</template>

<script setup lang="ts">
import VideoContent from './c-cpns/video-content.vue';
import { bei, fu, gongertouji, gongsantouji, tui, xiong } from './video';
</script>

<style lang="less" scoped>
.actionLibrary {
  background-image: url('@/assets/images/bg.jpeg');
  background-size: 100%;
}
</style>
