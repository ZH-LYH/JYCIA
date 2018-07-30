package pw.janyo.jycia.dataGetter;

public class CIAData
{
	private String COMMAND_FLAG;
	private String DATA_TIME;
	private Object DATA;
	
	public void setCommandFlag(String cf)
	{
		this.COMMAND_FLAG = cf;
	}
	
	public String getCommandFlag()
	{
		return this.COMMAND_FLAG;
	}
	
	public void setTime(String t)
	{
		this.DATA_TIME = t;
	}
	
	public String getTime()
	{
		return this.DATA_TIME;
	}
	
	public void setData(Object d)
	{
		this.DATA = d;
	}
	
	public Object getData()
	{
		return this.DATA;
	}
}
