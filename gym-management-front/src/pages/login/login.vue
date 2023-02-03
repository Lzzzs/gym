<template>
  <div class="h-screen">
    <div class="login-page flexc h-screen">
      <div
        class="login-form p-10 b border-black border-rd-4 max-w-xl border-base"
      >
        <el-form :model="loginForm" label-width="100px" label-position="left">
          <el-form-item label="用户名">
            <el-input v-model="loginForm.username" />
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="loginForm.password" />
          </el-form-item>
          <el-button @click="handleLogin" type="primary" class="login-btn"
            >登录</el-button
          >
          <el-radio-group
            v-model="loginForm.role"
            class="flex justify-between mt"
            style="width: 100%"
          >
            <el-radio label="2">用户</el-radio>
            <el-radio label="1">管理员</el-radio>
          </el-radio-group>
          <div class="flex justify-between mt">
            <el-link :underline="false">忘记密码</el-link>
            <el-link :underline="false">注册</el-link>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';
interface ILoginForm {
  username: string;
  password: string;
  // 1 管理员 2 用户
  role: 1 | 2;
}

const loginForm = reactive<ILoginForm>({
  username: '',
  password: '',
  role: 2,
});

const handleLogin = () => {
  console.log('login', loginForm);
};
</script>

<style lang="less" scoped>
.login-btn {
  width: 100%;
}
</style>
