package pw.janyo.jycia.dataGetter;
import pw.janyo.jycia.myInterface.*;
import android.telephony.*;
import pw.janyo.jycia.*;

public class DemoIMEIGetter extends DataGetter
{
	TelephonyManager tm;
    public String COMMAND_FLAG = "GET_DEV_ID";
	@Override
	public void init()
	{
		// TODO: Implement this method
		tm = (TelephonyManager)CIAApplication.getContext().getSystemService(CIAApplication.getContext().TELEPHONY_SERVICE);
	}

	@Override
	public void get(IGetter getterCallBack)
	{
		// TODO: Implement this method
		super.get(getterCallBack);
		CIAData d = new CIAData();
		d.setCommandFlag(this.COMMAND_FLAG);
		d.setData(tm.getDeviceId());
		getterCallBack.OnGetterReturn(d);
	}
	
	
	
}
