package pw.janyo.jycia.Service;
import android.app.*;
import android.content.*;
import android.os.*;

public class CockroachService extends Service
{

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		// TODO: Implement this method
		flags = START_STICKY;
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent p1)
	{
		// TODO: Implement this method
		return null;
	}

}
