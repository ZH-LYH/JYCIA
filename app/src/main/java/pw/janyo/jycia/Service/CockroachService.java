package pw.janyo.jycia.Service;
import android.app.*;
import android.content.*;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.util.Log;

import com.baidu.trace.Trace;
import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.model.OnCustomAttributeListener;
import com.baidu.trace.model.OnTraceListener;
import com.baidu.trace.api.track.OnTrackListener;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.api.analysis.OnAnalysisListener;
import com.baidu.trace.api.bos.OnBosListener;
import com.baidu.trace.model.PushMessage;

public class CockroachService extends Service
{

	// 轨迹服务ID
	long serviceId = 156094;
	//String entityName = "Samsung Galaxy S7 edge"+"imei:"+"357090072110976";
	String entityName = "CieyGet";
	// 定位周期(单位:秒)
	int gatherInterval = 300;
	// 打包回传周期(单位:秒)
	int packInterval = 600;
	boolean isNeedObjectStorage = false;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO: Implement this method
		getDozeWhiteList();
		BDTrace();
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
	}

	private void BDTrace() {
		Log.d("Activity","Trace start");
		Trace mTrace = new Trace(serviceId, entityName,isNeedObjectStorage);
		LBSTraceClient mTraceClient = new LBSTraceClient(getApplicationContext());
		// 设置定位和打包周期
		mTraceClient.setInterval(gatherInterval, packInterval);
		OnTraceListener onTraceListener = new OnTraceListener() {
			@Override
			public void onBindServiceCallback(int i, String s) {

			}

			@Override
			public void onStartTraceCallback(int i, String s) {
				Log.d("trace log","trace start");

			}

			@Override
			public void onStopTraceCallback(int i, String s) {

			}

			@Override
			public void onStartGatherCallback(int i, String s) {

			}

			@Override
			public void onStopGatherCallback(int i, String s) {

			}

			@Override
			public void onPushCallback(byte b, PushMessage pushMessage) {

			}

			@Override
			public void onInitBOSCallback(int i, String s) {

			}
		};
		mTraceClient.startTrace(mTrace,onTraceListener);
		mTraceClient.startGather(onTraceListener);
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
