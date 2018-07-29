package pw.janyo.jycia.Service;
import android.app.*;
import android.content.*;
import android.os.*;
import android.util.Log;

public class CockroachService extends Service
{

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO: Implement this method
		super.onStartCommand(intent, flags, startId);
		return START_STICKY;
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
