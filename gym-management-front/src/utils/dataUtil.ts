export function copy<T>(target: T, source: T): void {
  if (typeof target === 'object') {
    Object.keys(target).forEach((key) => {
      if (key in source) {
        target[key] = source[key];
      }
    });
  }
}
