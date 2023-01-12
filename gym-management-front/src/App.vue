<template>
  {{ counter.count }} <button @click="handleIncrement">+</button>
</template>

<script setup lang="ts">
import { useCounterStore } from '@/store/modules/counter';
const counter = useCounterStore();
const handleIncrement = () => {
  counter.incr();
};
</script>

<style scoped lang="less"></style>
