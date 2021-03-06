package pw.janyo.jycia.dataGetter;
import pw.janyo.jycia.myInterface.*;
import pw.janyo.jycia.*;
import android.os.*;

public class DemoBatteryValGetter extends DataGetter
{
	BatteryManager bm;
	String COMMAND_FLAG = "GET_BAT_NOW";
	@Override
	public void init()
	{
		// TODO: Implement this method
		bm = (BatteryManager)CIAApplication.getContext().getSystemService(CIAApplication.BATTERY_SERVICE);
	}
	
	
	//重写get方法
	public void get(IGetter getterCallBack)
	{
		CIAData d = new CIAData();
		d.setCommandFlag(this.COMMAND_FLAG);
		d.setData(Integer.toString( bm.getIntProperty(bm.BATTERY_PROPERTY_CAPACITY)));
		//Callback
		getterCallBack.OnGetterReturn(d);
	}
	
}
