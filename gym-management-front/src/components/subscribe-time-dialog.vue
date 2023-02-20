<template>
  <div>
    <el-dialog
      v-model="dialogVisible"
      :title="props.title"
      width="40%"
      :before-close="beforeClose"
    >
      <el-form :model="subscribeTimeForm">
        <el-form-item label="预约时间" prop="subscribeTimeForm.time">
          <el-date-picker
            v-model="subscribeTimeForm.time as any"
            format="YYYY/MM/DD hh:mm:ss"
            value-format="x"
            placeholder="请选择预约时间"
            type="datetimerange"
            range-separator="to"
            start-placeholder="开始时间"
            end-placeholder="结束时间"
            :disabled-date="disabledDate"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleSubscribe"> 确认 </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
const props = defineProps<{
  disabled: boolean;
  title: string;
}>();
const emit = defineEmits<{
  (event: 'updateDisabled', dialogVisible: boolean): void;
  (event: 'confirmSubscribe', subscribeTimeForm: { time: string[] }): void;
}>();

const dialogVisible = ref(false);
let subscribeTimeForm = reactive({
  time: [],
});

// 设置用户不能选择之前的时间
const disabledDate = (time: Date) => {
  return time.getTime() < Date.now();
};
const handleSubscribe = () => {
  emit('confirmSubscribe', subscribeTimeForm);
  dialogVisible.value = false;
};
const beforeClose = (done: () => void) => {
  subscribeTimeForm.time.length = 0;
  done();
};

watch(dialogVisible, (newValue) => {
  emit('updateDisabled', newValue);
});
watch(
  () => props.disabled,
  (newValue) => {
    dialogVisible.value = newValue;
  }
);
</script>

<style scoped></style>
