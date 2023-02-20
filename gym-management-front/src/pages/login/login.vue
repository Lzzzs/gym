<template>
  <div class="h-screen">
    <div class="login-page flexc h-screen">
      <div
        class="login-form p-10 b border-black border-rd-4 max-w-xl border-base"
      >
        <el-form
          :model="loginForm"
          label-width="100px"
          label-position="left"
          :rules="rules"
          ref="loginFormRef"
          style="min-width: 300px"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="loginForm.username" />
          </el-form-item>
          <el-form-item label="密码" prop="password" class="mt-6">
            <el-input
              v-model="loginForm.password"
              type="password"
              show-password
            />
          </el-form-item>
          <el-button
            @click="handleLogin(loginFormRef)"
            type="primary"
            class="login-btn mt-3"
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
            <el-link :underline="false" href="/register">注册</el-link>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { FormRules, FormInstance, ElMessage } from 'element-plus';
import { fetchLogin } from '@/network/login/index';
import type { ILoginForm } from '@/types/login/index';
import { login } from '@/utils/loginUtil';

const loginFormRef = ref<FormInstance>();
const router = useRouter();

const loginForm = reactive<ILoginForm>({
  username: '',
  password: '',
  role: '',
});

const rules = reactive<FormRules>({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 5, message: '用户名的长度不能少于5位', trigger: 'change' },
  ],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  role: [
    {
      required: true,
      message: '请选择身份',
      trigger: 'change',
    },
  ],
});

const handleLogin = async (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  await formEl.validate((valid) => {
    if (valid) {
      loginForm.role ? successFetch() : ElMessage.warning('还未选择身份');
    }
  });
};
const successFetch = () => {
  fetchLogin(loginForm).then(({ token, refreshToken, user }) => {
    login(token, refreshToken, user);
    user.role == '1' ? router.push(`/admin`) : router.push('/');
  });
};
</script>

<style lang="less" scoped>
.login-btn {
  width: 100%;
}
</style>
