export function isJSON(str: string): boolean {
  if (typeof str == 'string') {
    try {
      const obj = JSON.parse(str);

      if (typeof obj == 'object' && obj) {
        return true;
      } else {
        return false;
      }
    } catch (e) {
      console.log('error：' + str + '!!!' + e);

      return false;
    }
  }

  return false;
}
