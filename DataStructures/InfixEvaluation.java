import java.util.*;
class InfixEvaluation{
	public static double applyOp(Stack opearator,Stack operand){
		char op = (char)opearator.pop();
		double a = Double.parseDouble((String)operand.pop());
		double b = Double.parseDouble((String)operand.pop());
		if(op == '+')
			return b+a;
		if(op == '-')
			return b-a;
		if(op == '*')
			return b*a;
		if(op == '/')
			return b/a;
		if(op == '%')
			return b%a;
		if(op == '^')
			return Math.pow(b,a);
		return 0;		
	}
	public static double infixEvaluation(String infix){
		Stack opearator = new Stack();
		Stack operand = new Stack();
		int len = infix.length();
		for (int i=0;i<len;i++) {
			char ch = infix.charAt(i);
			if(ch == '('){
				opearator.push(ch);
			}else if(InfixToPostfix.isOperator(ch)){
				while (!opearator.isEmpty() && InfixToPostfix.precedence(ch) <= InfixToPostfix.precedence((char)opearator.peek())) {
					operand.push(String.valueOf(applyOp(opearator,operand)));
				}
				opearator.push(ch);
			}else if(ch == ')'){
				while ((char)opearator.peek()!='(') {
					operand.push(String.valueOf(applyOp(opearator,operand)));
				}
				opearator.pop();
			}else{
				if(ch != ' '){
					String num = "";
					while (i < len && !InfixToPostfix.isOperator(ch) && ch != ')') {
						num += ch;
						i++;
						if(i < len)
							ch = infix.charAt(i);	
					}	
					i--;
					operand.push(num.trim());
				}
			}
		}
		//opearator.print();
		//operand.print();
		//return Double.parseDouble((String)operand.peek());
		while (!opearator.isEmpty()) {
			operand.push(String.valueOf(applyOp(opearator,operand)));
		}
		//operand.print();
		return Double.parseDouble((String)operand.peek());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter infix expression: ");
		String infix = sc.nextLine();
		System.out.println("Answer: "+infixEvaluation(infix));
	}
}