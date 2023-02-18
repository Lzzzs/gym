<template>
  <div class="admin-page flex h-full flex-col">
    <admin-page-header></admin-page-header>
    <div class="flex flex-1">
      <admin-page-sidebar></admin-page-sidebar>
      <div>
        <RouterView />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped></style>
