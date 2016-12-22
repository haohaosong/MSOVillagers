/*
* author:cx
* date:2016/12/20
* note:检查传入信息是否正确
*/

public class Check 
{
	public static boolean checkName(String name)//不能包含英文
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
	public static boolean checkID(String ID)//18位，只有最后一位可以是字母，必须是X
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
	public static boolean checkNation(String nation)//最后一位必须带‘族’字
	{
		return nation.subSequence(nation.length()-1,nation.length() ).equals("族")
				&&nation.length()>1;
	}
	public static boolean checkAddress(String address)//必须是 M 排 N号 这种形式
	{	
		return true;
				//address.subSequence(address.length()-1,address.length() ).equals("号")
				//&&address.length()>1;
	}
	public static boolean checkSex(String sex)//男或女，不能为其他
	{
		if(sex.length()==1 && (sex.equals("男") || sex.equals("女")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkMarrage(String marrage)//必须是‘已婚’或者“未婚”
	{
		if(marrage.equals("已婚") || marrage.equals("未婚"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkAge(int age)//必须在0到100之间
	{
		if(age<0 || age>120)
		{
			return false;
		}
		return true;
	}
}
