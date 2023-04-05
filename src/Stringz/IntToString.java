package src.Stringz;

public class IntToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=-312;
		int rem=0, res=0,s2=s;
		if(s<0)
			s=-s;
		StringBuilder sb=new StringBuilder();
		while(s!=0)
		{
			rem=s%10;
			s=s/10;
			sb.append(rem);
		}
		
		System.out.println(s2<=0? '-'+sb.reverse().toString():sb.reverse().toString());
	}

}
