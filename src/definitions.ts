export interface InstallPermissionPlugin {
  checkPermission(): Promise<{ granted: boolean }>;
  requestPermission(): Promise<{ action: String }>;
}
