package pw.janyo.jycia.dataGetter;
import pw.janyo.jycia.myInterface.*;
import pw.janyo.jycia.*;
import android.os.*;

public class DemoBatteryValGetter extends DataGetter
{
	BatteryManager bm;
	String COMMAND_FLAG = "GET_BAT_NOW";
	@Override
	public void init(String cf)
	{
		// TODO: Implement this method
		super.init(cf);
		bm = (BatteryManager)CIAApplication.getContext().getSystemService(CIAApplication.BATTERY_SERVICE);
	}
	
	
	//重写get方法
	public void get(IGetter getterCallBack)
	{
		CIAData d = new CIAData();
		d.setCommandFlag(this.COMMAND_FLAG);
		d.setData(bm.BATTERY_PROPERTY_CURRENT_NOW);
		//Callback
		getterCallBack.OnGetterReturn(d);
	}
	
}
