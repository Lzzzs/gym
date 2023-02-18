<template>
  <div class="mx-10 mt-10">
    <h2>{{ title }}</h2>
    <slot></slot>
  </div>
</template>

<script setup lang="ts">
const { title } = defineProps({
  title: String,
});
</script>

<style scoped></style>
