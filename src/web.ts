import { WebPlugin } from '@capacitor/core';

import type { InstallPermissionPlugin } from './definitions';

export class InstallPermissionWeb extends WebPlugin implements InstallPermissionPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
