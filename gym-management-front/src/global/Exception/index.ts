import { ElMessage } from 'element-plus';
import { App, ComponentPublicInstance } from 'vue';

const errorHandler = function (
  err: unknown,
  instance: ComponentPublicInstance | null,
  info: string
) {
  console.log(
    '-----------------------进入了全局异常捕获中-----------------------'
  );
  console.log(err, instance, info);
  ElMessage.error('系统异常');
};

export default function (app: App) {
  app.config.errorHandler = errorHandler;
}
