package pw.janyo.jycia.Receiver;
import android.content.*;
import android.util.Log;

import pw.janyo.jycia.MainActivity;
import pw.janyo.jycia.Service.*;

public class BootUpReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context p1, Intent p2)
	{
		// TODO: Implement this method
		Intent intent = new Intent(p1,CockroachService.class);
		p1.startService(intent);
	}

}
