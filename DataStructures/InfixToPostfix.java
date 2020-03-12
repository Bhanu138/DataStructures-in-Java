import java.util.*;
class InfixToPostfix{
	public static boolean isOperator(char ch){
		return ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^' || ch=='%';
	}
	public static int precedence(char ch){
		if(ch == '(')
			return 1;
		if(ch == '+' || ch == '-')
			return 2;
		if(ch == '*' || ch == '/' || ch == '%')
			return 3;
		if(ch == '^')
			return 4;
		else
			return 5;
	}
	public static String toPostfix(String infix){
		String postfix = "";
		Stack st = new Stack();
		for (int i=0;i<infix.length();i++) {
			char ch = infix.charAt(i);
			if(ch == '('){
				st.push(ch);
			}else if(ch == ')'){
				while ((char)st.peek()!='(') {
					postfix += st.peek();
					st.pop();
				}
				st.pop();
			}else if(isOperator(ch)){
				while (!st.isEmpty() && precedence(ch)<=precedence((char)st.peek())) {
					postfix += st.peek();
					st.pop();
				}
				st.push(ch);
			}else{
				if(ch != ' ')
					postfix += ch;
			}
		}
		while (!st.isEmpty()) {
			postfix += st.peek();
			st.pop();
		}
		return postfix;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter infix expression: ");
		String infix = sc.nextLine();
		System.out.println("Postfix expression: "+toPostfix(infix));
	}
}