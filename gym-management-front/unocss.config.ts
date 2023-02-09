import { defineConfig, presetUno, presetMini } from 'unocss';

export default defineConfig({
  presets: [presetUno(), presetMini()],
  shortcuts: [
    {
      flexc: 'flex justify-center items-center',
      b: 'border border-solid ',
    },
    // [
    //   /^border-(.*)$/,
    //   ([, c]) =>
    //     `bg-${c}-400 text-${c}-100 border border-solid border-color-black`,
    // ],
  ],
});
