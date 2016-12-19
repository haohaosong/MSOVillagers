/*
* author:haohaosong
* date:2016/12/5
* note:This is the class of villagers
*/
public class Villager {
	private String name;
	private  int age;
	private String ID;
	private String sex;
	private String post;
	private String address;
	private String nation;
	private String marrage;
	Villager(String name,int age,String ID,String sex,String post,String address,String nation,String marrage)
	{
		this.name = name;
		this.age = age;
		this.ID = ID;
		this.sex = sex;
		this.post = post;
		this.address = address;
		this.nation = nation;
		this.marrage = marrage;
	}
	public String getPost()
	{
		return post;
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
}
