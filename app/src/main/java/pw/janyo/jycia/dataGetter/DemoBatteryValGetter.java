package pw.janyo.jycia.dataGetter;
import pw.janyo.jycia.myInterface.*;
import pw.janyo.jycia.*;
import android.os.*;

public class DemoBatteryValGetter extends DataGetter
{
	BatteryManager bm;
	

	//重写init方法
	public void init()
	{
		bm = (BatteryManager)CIAApplication.getContext().getSystemService(CIAApplication.getContext().BATTERY_SERVICE);
		
	}
	
	//重写get方法
	public void get(IGetter getterCallBack)
	{
		CIAData d = new CIAData();
		d.setCommandFlag("GET_BAT_NOW");
		d.setData(bm.BATTERY_PROPERTY_CURRENT_NOW);
		//Callback
		getterCallBack.OnGetterReturn(d);
	}
	
}
