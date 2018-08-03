package pw.janyo.jycia.Service;
import android.app.*;
import android.content.*;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.util.Log;

public class CockroachService extends Service
{
	// 轨迹服务ID
	long serviceId = 156094;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO: Implement this method
		getDozeWhiteList();
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}


	public void getDozeWhiteList()
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			String packageName = this.getPackageName();
			PowerManager powerManager = (PowerManager)getSystemService(POWER_SERVICE);
			boolean isIgnoring = powerManager.isIgnoringBatteryOptimizations(packageName);
			if (!isIgnoring) {
				Intent intent = new Intent(
						Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
				intent.setData(Uri.parse("package:" + packageName));
				try {
					startActivity(intent);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public void onDestroy()
	{
		Log.d("CockroachService","Restart Service");
		Intent intent = new Intent(this,CockroachService.class);
		startService(intent);
		super.onDestroy();
	}
}
