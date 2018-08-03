package pw.janyo.jycia;
import pw.janyo.jycia.dataGetter.*;

public class DevTestDebug
{
	public void test()
	{
		CIAEngine engine = new CIAEngine();
		
		//添加采集器
		DemoBatteryValGetter batGetter = new DemoBatteryValGetter();
		DemoIMEIGetter imeiGetter = new DemoIMEIGetter();
		
		engine.addGetter(batGetter);
		engine.addGetter(imeiGetter);
		engine.initEngine();
		//engine.startGetter(); 等候网络中客户端的指令来自动选取需要工作的采集器 未实现
		//Debug 用，手动给指令来选取采集器
		engine.debugStartGetter("GET_BAT_NOW");
	}
}
