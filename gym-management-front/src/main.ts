import { createApp } from 'vue';
import { installStore } from '@/store';
import { installRouter } from '@/router';

import 'normalize.css';
import App from './App.vue';

const app = createApp(App);

installStore(app);
installRouter(app);

app.mount('#app');
