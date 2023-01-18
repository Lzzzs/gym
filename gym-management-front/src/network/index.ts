import axios, { RawAxiosRequestConfig, AxiosResponse } from 'axios';

export const instance = axios.create({
  baseURL: 'http://localhost',
  timeout: 10000,
});

export default function <T>(config: RawAxiosRequestConfig): Promise<T> {
  return instance(config);
}
