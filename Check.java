/*
* author:cx
* date:2016/12/20
* note:��鴫����Ϣ�Ƿ���ȷ
*/

public class Check 
{
	public static boolean checkName(String name)//���ܰ���Ӣ��
	{
		char[] nm = name.toCharArray();
		for(int i = 0; i<name.length();i++)
		{
			if(isEnglish(nm[i]))
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isEnglish(char ch)
	{
		if((ch>='A' && ch<='Z') ||(ch>='a'&&ch<='z')) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkID(String ID)//18λ��ֻ�����һλ��������ĸ��������X
	{
        char[] id = ID.toCharArray();
		
		if(ID.length() != 18)
		{
			return false;
		}
		
		for(int i = 0; i<ID.length()-1;i++)
		{
			if(isNumer(id[i]))
			{
				continue;
			}
			else
			{
				return false;
			}
		}
		
		if(id[17] == 'X' || isNumer(id[17]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isNumer(char ch)
	{
		if( ch > '0' || ch < '9')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkNation(String nation)//���һλ��������塯��
	{
		return nation.subSequence(nation.length()-1,nation.length() ).equals("��")
				&&nation.length()>1;
	}
	public static boolean checkAddress(String address)//������ M �� N�� ������ʽ
	{	
		return true;
				//address.subSequence(address.length()-1,address.length() ).equals("��")
				//&&address.length()>1;
	}
	public static boolean checkSex(String sex)//�л�Ů������Ϊ����
	{
		if(sex.length()==1 && (sex.equals("��") || sex.equals("Ů")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkMarrage(String marrage)//�����ǡ��ѻ顯���ߡ�δ�顱
	{
		if(marrage.equals("�ѻ�") || marrage.equals("δ��"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkAge(int age)//������0��100֮��
	{
		if(age<0 || age>120)
		{
			return false;
		}
		return true;
	}
}
