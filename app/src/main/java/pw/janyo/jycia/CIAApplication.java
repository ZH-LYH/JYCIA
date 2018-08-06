package pw.janyo.jycia;
import android.app.*;
import android.content.*;

public class CIAApplication extends Application
{
	private static CIAApplication ciaApplication;
	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		super.onCreate();
		ciaApplication = this;
	}
	
	public static Context getContext()
	{
		return ciaApplication;
	}
	
}
