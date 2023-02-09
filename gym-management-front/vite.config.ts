import { defineConfig } from 'vite';
import { resolve } from 'path';
import vue from '@vitejs/plugin-vue';
import Unocss from 'unocss/vite';
import AutoImport from 'unplugin-auto-import/vite';
import Components from 'unplugin-vue-components/vite';
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers';

// config address -> https://vitejs.dev/config/

function resolveAlias(target: string): string {
  return resolve(__dirname, target);
}

export default defineConfig({
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8888',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    },
  },
  resolve: {
    alias: {
      '@': resolveAlias('./src'),
      components: resolveAlias('./src/components'),
      network: resolveAlias('./src/network'),
      store: resolveAlias('./src/store'),
      pages: resolveAlias('./src/pages'),
      hooks: resolveAlias('./src/hooks'),
    },
  },
  plugins: [
    vue(),
    Unocss(),
    AutoImport({
      imports: ['vue', '@vueuse/core', 'vue-router'],
      resolvers: [ElementPlusResolver()],
      vueTemplate: true,
      dts: true,
    }),
    Components({
      resolvers: [ElementPlusResolver()],
      dts: true,
    }),
  ],
});
