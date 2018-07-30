package pw.janyo.jycia;
import android.app.*;
import android.content.*;

public class CIAApplication extends Application
{
	private Context c;

	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		c = getApplicationContext();
	}
	
	public static Context getContext()
	{
		return this.c;
	}
	
}
