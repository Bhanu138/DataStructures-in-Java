import java.util.*;
class PrefixToInfix{
	public static String prefixToInfix(String prefix){
		Stack st = new Stack();
		int len = prefix.length();
		for(int i=len-1;i >= 0;i--){
			char ch = prefix.charAt(i);
			if(InfixToPostfix.isOperator(ch)){
				String op1 = String.valueOf(st.peek());
				st.pop();
				String op2 = String.valueOf(st.peek());
				st.pop();
				String temp ="(" +op2+ ch +op1+")";
				st.push(temp);
			}else st.push(ch);
		}
		return InfixToPrefix.reverse((String)st.peek(),"");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter Prefix Expression : ");
		String prefix = sc.nextLine();
		System.out.println("Infix Expression is : "+prefixToInfix(prefix));
	}
}