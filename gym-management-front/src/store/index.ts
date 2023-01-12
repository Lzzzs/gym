import { createPinia } from 'pinia';
import type { App } from 'vue';

const store = createPinia();

const installStore = (app: App<Element>) => {
  app.use(store);
};

export { store, installStore };
