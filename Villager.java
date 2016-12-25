/*
* author:haohaosong
* date:2016/12/5
* note:村民类，包含村民对象的构造，以及获取对象元素的内容的接口
*/
public class Villager {
	private String name;//姓名
	private  int age;//年龄
	private String sex;//性别
	private String ID;//身份证号
	private String marrage;//婚姻
	private String nation;//民族
	private String address;//住址
	
	//构造函数
	Villager()
	{}
	
	//构造函数
	Villager(String name,String age,String ID,String sex,String marrage,String nation,String address)
	{
		this.name = name;
		if(age.equals("") == true)
			this.age = 0;
		else
			this.age = Integer.parseInt(age);//字符串转换为整形
		this.ID = ID;
		this.sex = sex;
		this.address = address;
		this.nation = nation;
		this.marrage = marrage;
	}
	
	//设置姓名的接口
	public void setName(String name)
	{
		this.name = name;
	}
	
	//获取属性元素的方法
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getage()
	{
		return Integer.toString( age);
	}
	public String getID()
	{
		return ID;
	}
	public String getAddress()
	{
		return address;
	}
	public String getNation()
	{
		return nation;
	}
	public String getMarrage()
	{
		return marrage;
	}
	public String getSex()
	{
		return sex;
	}
	
	//打印函数，供测试使用
	void print()
	{	
		System.out.println(name+"  "+age+"  "+sex+"  "+ID+"  "+
									marrage+"  "+nation+"  "+address);
	}
}
