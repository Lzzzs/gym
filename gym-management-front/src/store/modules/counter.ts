import { defineStore } from 'pinia';

export const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 0,
  }),
  actions: {
    incr() {
      this.count++;
    },
  },
});

// import { useCounterStore } from '@/store/modules/counter';
// const counter = useCounterStore();
// const handleIncrement = () => {
//   counter.incr();
// };
