import { defineConfig } from 'vite';
import { resolve } from 'path';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/

function resolveAlias(target: string): string {
  return resolve(__dirname, target);
}

export default defineConfig({
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
  plugins: [vue()],
});
