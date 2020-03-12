import java.util.*;
class BalancedExpression{
	public static boolean isMatchedBracket(Stack st, char ch){
		if((char)st.peek() == '(' && ch == ')')
			return true;
		if((char)st.peek() == '{' && ch == '}')
			return true;
		if((char)st.peek() == '[' && ch == ']')
			return true;
		return false;
	}
	public static boolean isBalancedExpression(String expression){
		Stack st = new Stack();
		for(int i=0;i<expression.length();i++){
			char ch = expression.charAt(i);
			if(ch=='(' || ch=='[' || ch=='{')
				st.push(ch);
			else if(ch=='}' || ch==']' || ch==')'){
				if(st.isEmpty() || !isMatchedBracket(st,ch))
					return false;
				else
					st.pop();
			}
		}
		if(st.isEmpty())
			return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter expression: ");
		String expression = sc.nextLine();
		if(isBalancedExpression(expression)){
			System.out.println("Balanced.");
		}else{
			System.out.println("Not Balanced.");
		}
	}
}