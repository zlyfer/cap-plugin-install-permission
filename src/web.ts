import { WebPlugin } from '@capacitor/core';

import type { InstallPermissionPlugin } from './definitions';

export class InstallPermissionWeb
  extends WebPlugin
  implements InstallPermissionPlugin
{
  async checkPermission(): Promise<{ granted: boolean }> {
    throw this.unimplemented('Not implemented on web.');
  }
  requestPermission(): Promise<{ action: String }> {
    throw this.unimplemented('Not implemented on web.');
  }
}
