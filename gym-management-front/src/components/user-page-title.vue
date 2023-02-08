<template>
  <h2 class="title">
    {{ title }}
  </h2>
</template>

<script setup lang="ts">
const { title } = defineProps({
  title: String,
});
</script>

<style scoped></style>
