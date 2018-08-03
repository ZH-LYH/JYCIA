/*
 *CIAEngine.java
 *CIA 引擎类 提供数据采集 优化 转发
 *DickLight
 *2018-7-29
 *
 */
package pw.janyo.jycia;
import pw.janyo.jycia.myInterface.*;
import java.util.*;
import pw.janyo.jycia.dataGetter.*;
import android.util.*;

/*
 *CIAEngine
 *引擎类 提供数据采集 优化 转发
 *
 */
public class CIAEngine 
{
	
	Map<String, DataGetter> m = new HashMap<String, DataGetter>();
	
	CIAEngine(){
		
	}
	
	
	/*
	 *addGetter()
	 *添加采集器
	 *
	 */
	public void addGetter(DataGetter getterMember)
	{
		m.put(getterMember.COMMAND_FLAG, getterMember);
	}
	
	/*
	 *initEngine()
	 *初始化引擎
	 *
	 */
	 public void initEngine()
	 {
		 for(String CF:m.keySet())
		 {
			 m.get(CF).init();
		 }
	 }
	 
	 public void startGetter()
	 {
		 final String gCF = null;
		 //gCF = waitCommand(); //从网络等待客户端指令 未实现
		 for(String CF:m.keySet())
		 {
			 if (gCF.equals(CF))
			 {
				 final DataGetter getter = m.get(gCF);
				 new Thread(new Runnable(){

					 @Override
					 public void run()
					 {
						 // TODO: Implement this method
						 getter.init();
						 getter.get(new GetterDoGetOptional(gCF));
					 }


				 }).start();
			 }
		 }
	}
		 
	 public void debugStartGetter(final String gCF)
	 {
		 // final String gCF = null;
		 //gCF = waitCommand(); //从网络等待客户端指令 未实现
		 for(String CF:m.keySet())
		 {
			 if (gCF.equals(CF))
			 {
				 final DataGetter getter = m.get(gCF);
				 new Runnable(){

					 @Override
					 public void run()
					 {
						 // TODO: Implement this method
						 getter.init();
						 getter.get(new GetterDoGetOptional(gCF));
					 }


				 };
			 }
		 }
		
	 }
	 
	 class GetterDoGetOptional implements IGetter
	{

		@Override
		public void OnGetterReturn(CIAData data)
		{
			// TODO: Implement this method
			//采集器采集到数据后回调
			Log.d("[CIA DEBUG_FLAG]", data.getData().toString());
		}
		
		 GetterDoGetOptional(String commandFlag)
		 {
			 
		 }
	 }
	 
}
