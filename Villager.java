/*
* author:haohaosong
* date:2016/12/5
* note:This is the class of villagers
*/
public class Villager {
	private String name;//姓名
	private  int age;//年龄
	private String sex;//性别
	private String ID;//身份证号
	private String marrage;//婚姻
	private String nation;//民族
	private String address;//住址
	Villager()
	{}
	Villager(String name,String age,String ID,String sex,String marrage,String nation,String address)
	{
		this.name = name;
		this.age = Integer.parseInt(age);
		this.ID = ID;
		this.sex = sex;
		this.address = address;
		this.nation = nation;
		this.marrage = marrage;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
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
	void print()
	{	
		System.out.println(name+"  "+age+"  "+sex+"  "+ID+"  "+
									marrage+"  "+nation+"  "+address);
	}
}
