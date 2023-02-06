export function generateAuthorization(): string {
  const token = localStorage.getItem('token');
  return token ? `Bearer ${JSON.parse(token)}` : 'null';
}
