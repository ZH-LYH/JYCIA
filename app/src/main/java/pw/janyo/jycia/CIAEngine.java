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

/*
 *CIAEngine
 *引擎类 提供数据采集 优化 转发
 *
 */
public class CIAEngine
{
	List getterArray = new ArrayList();
	CIAEngine(){
		
	}
	
	
	/*
	 *addGetter()
	 *添加采集器
	 *
	 */
	public void addGetter(IDataGetter getterMember)
	{
		getterArray.add(getterMember);
	}
	
	/*
	 *initEngine()
	 *初始化引擎
	 *
	 */
	 public void initEngine()
	 {
		 
	 }
	 
}
