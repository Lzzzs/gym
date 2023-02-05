import { createApp } from 'vue';
import { installStore } from '@/store';
import { installRouter } from '@/router';

import 'normalize.css';
import 'nprogress/nprogress.css';
import 'uno.css';
import '@/assets/css/global.less';
import 'element-plus/dist/index.css';

import App from './App.vue';

const app = createApp(App);

installStore(app);
installRouter(app);

app.mount('#app');
