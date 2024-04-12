import { registerPlugin } from '@capacitor/core';

import type { InstallPermissionPlugin } from './definitions';

const InstallPermission = registerPlugin<InstallPermissionPlugin>('InstallPermission', {
  web: () => import('./web').then(m => new m.InstallPermissionWeb()),
});

export * from './definitions';
export { InstallPermission };
