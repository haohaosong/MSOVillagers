/*
* author:haohaosong
* date:2016/12/5
* note:�����࣬�����������Ĺ��죬�Լ���ȡ����Ԫ�ص����ݵĽӿ�
*/
public class Villager {
	private String name;//����
	private  int age;//����
	private String sex;//�Ա�
	private String ID;//���֤��
	private String marrage;//����
	private String nation;//����
	private String address;//סַ
	
	//���캯��
	Villager()
	{}
	
	//���캯��
	Villager(String name,String age,String ID,String sex,String marrage,String nation,String address)
	{
		this.name = name;
		if(age.equals("") == true)
			this.age = 0;
		else
			this.age = Integer.parseInt(age);//�ַ���ת��Ϊ����
		this.ID = ID;
		this.sex = sex;
		this.address = address;
		this.nation = nation;
		this.marrage = marrage;
	}
	
	//���������Ľӿ�
	public void setName(String name)
	{
		this.name = name;
	}
	
	//��ȡ����Ԫ�صķ���
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
	
	//��ӡ������������ʹ��
	void print()
	{	
		System.out.println(name+"  "+age+"  "+sex+"  "+ID+"  "+
									marrage+"  "+nation+"  "+address);
	}
}
