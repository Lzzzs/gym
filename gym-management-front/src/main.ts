import { createApp } from 'vue';
import App from './App.vue';
import { installStore } from '@/store';

import 'normalize.css';

function install() {
  const app = createApp(App);

  installStore(app);

  app.mount('#app');
}

install();
