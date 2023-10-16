
public class Date 
{
	private int m;
	private int d;
	private int y;
	
	public Date()
{
	m = 1;
	d = 1;
	y = 1970;
}
	public Date(int m, int d, int y)
{
	this.m = m;
	this.d = d;
	this.y = y;
}
	public Date(Date date) //copy constructor
{
	m = date.m;
	d = date.d;
	y = date.y;
}
	public int getMonth()
{
	return m;
}
	public int getDay()
	{
		return d;
	}
	public int getYear()
	{
		return y;
	}
	public void setDate(int m, int d, int y)
	{ 
		this.m = m;
		this.d = d;
		this.y = y;
	}
}
