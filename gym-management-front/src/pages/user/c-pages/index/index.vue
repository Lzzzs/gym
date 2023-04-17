<template>
  <div class="flex justify-between items-center flex-col index">
    <el-carousel :interval="5000" style="flex: 1; width: 100%">
      <el-carousel-item style="height: 100%; width: 100%">
        <img
          src="@/assets/images/to-gym.jpg"
          style="height: 100%; width: 100%"
          @click="to(0)"
          class="cursor-pointer"
        />
      </el-carousel-item>
      <el-carousel-item style="height: 100%; width: 100%">
        <img
          src="@/assets/images/to-course.jpg"
          class="cursor-pointer"
          style="height: 100%; width: 100%"
          @click="to(1)"
        />
      </el-carousel-item>
      <el-carousel-item style="height: 100%; width: 100%">
        <img
          src="@/assets/images/to-actionLibrary.jpg"
          style="height: 100%; width: 100%"
          @click="to(2)"
          class="cursor-pointer"
        />
      </el-carousel-item>
    </el-carousel>

    <footer class="footer w-full">
      <div class="border-coolGray b"></div>

      <div class="flex justify-between items-center py-5 px-30 bg-neutral-500">
        <div class="flex">
          <div class="logo">
            <img src="@/assets/images/logo.jpg" style="height: 100px" />
          </div>
          <div class="contact-us ml-7">
            <div class="text-xl font-bold text-center">联系我们</div>
            <div class="border-coolGray b"></div>
            <div class="text-lg">电话：13178856381</div>
            <div class="text-lg">地址：广东省广州市番禺区</div>
            <div class="text-lg">邮箱：1532612719@qq.com</div>
          </div>
        </div>
        <div class="wechat">
          <div class="text-xl font-bold">微信公众号</div>
          <div class="border-coolGray b mb-1"></div>
          <img src="@/assets/images/wechat.jpg" style="height: 100px" />
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup lang="ts">
const toMap = {
  0: '/subscribe',
  1: '/course',
  2: '/actionLibrary',
};
const router = useRouter();
const to = (type: keyof typeof toMap) => {
  router.push(toMap[type]);
};
</script>

<style>
.index {
  height: calc(100vh - 60px);
}
.el-carousel__container {
  height: 100% !important;
}
</style>
