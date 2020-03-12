import java.util.*;
class PostToInfix{
	public static String postfixToInfix(String postfix){
		Stack st = new Stack();
		int len = postfix.length();
		for(int i= 0;i< len ;i++){
			char ch = postfix.charAt(i);
			if(InfixToPostfix.isOperator(ch)){
				String op1 = String.valueOf(st.peek());
				st.pop();
				String op2 = String.valueOf(st.peek());
				st.pop();
				String temp ="(" +op2+ ch +op1+")";
				st.push(temp);
			}else st.push(ch);
		}return (String)st.peek();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter Postfix Expression : ");
		String postfix = sc.nextLine();
		System.out.println("Infix Expression is : "+postfixToInfix(postfix));
	}
}