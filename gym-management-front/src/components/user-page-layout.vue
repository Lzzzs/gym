<template>
  <div class="pl-32 pr-32">
    <user-page-title :title="title"></user-page-title>
    <slot></slot>
  </div>
</template>

<script setup lang="ts">
const { title } = defineProps({
  title: String,
});
</script>

<style scoped></style>
