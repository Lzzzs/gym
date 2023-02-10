<template>
  <user-page-layout title="咨询服务">
    <div class="flexc mt-10">
      <el-form
        label-position="top"
        label-width="100px"
        style="min-width: 460px"
        :model="consultForm"
      >
        <el-form-item label="留言框">
          <el-input
            :rows="5"
            type="textarea"
            placeholder="请输入文字给教练留言"
            v-model="consultForm.leaveWord"
          />
        </el-form-item>
        <el-form-item>
          <el-button>提交</el-button>
        </el-form-item>
      </el-form>
    </div>
  </user-page-layout>
</template>

<script setup lang="ts">
const consultForm = reactive({
  leaveWord: '',
});
</script>

<style lang="less" scoped></style>
