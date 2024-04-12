export interface InstallPermissionPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
