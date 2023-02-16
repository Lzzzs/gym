export function copy<T extends object, K extends T>(
  target: T,
  source: K
): void {
  const keys = Object.keys(target) as (keyof T)[];
  keys.forEach((key) => {
    if (key in source) {
      target[key] = source[key];
    }
  });
}

export function emptyObj(target: any) {
  Object.keys(target).forEach((key) => {
    target[key] = null;
  });
}
