package pw.janyo.jycia;
import android.app.*;
import android.content.*;

public class CIAApplication extends Application
{
	private static CIAApplication context;
	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		context = this;
	}
	
	public static Context getContext()
	{
		return context;
	}
	
}
