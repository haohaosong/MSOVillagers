/*
* author:haohaosong
* date:2016/12/5
* note:This is the class of villagers
*/
public class Villager {
	private String name;//����
	private  int age;//����
	private String sex;//�Ա�
	private String ID;//���֤��
	private String marrage;//����
	private String nation;//����
	private String address;//סַ
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
