import { createRouter, createWebHistory } from 'vue-router';
import { App } from 'vue';
import routes from './routes';

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export const installRouter = (app: App<Element>) => {
  app.use(router);
};

export default router;
