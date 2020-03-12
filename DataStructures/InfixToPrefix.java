import java.util.*;
class InfixToPrefix{
	public static String reverse(String infix, String str){
		for(int i=infix.length()-1;i>=0;i--){
			char ch = infix.charAt(i);
			if(ch == ')') ch = '(';
			else if(ch == '(') ch = ')';
			str += ch;
		}
		return str;
	}
	public static String toPrefix(String infix){
		return reverse(InfixToPostfix.toPostfix(reverse(infix,"")),"");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter Infix Expression : ");
		String infix = sc.nextLine();
		System.out.println("Prefix Expression is : "+ toPrefix(infix));
	}
}