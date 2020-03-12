class PostfixEvaluation{
	public static int applyOperation(int num1,int num2,char op){
		if(op == '+')
			return num2+num1;
		if(op == '-')
			return num2-num1;
		if(op == '*')
			return num2*num1;
		if(op == '/')
			return num2/num1;
		return -1;
	}
	public static boolean isOperator(char ch){
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
	public static int evaluatePostfix(String postfix){
		Stack stack = new Stack();

		for (int i=0;i<postfix.length();i++) {
			char ch = postfix.charAt(i);
			if(isOperator(ch)){
				int num1 = (int)stack.pop();
				int num2 = (int)stack.pop();
				stack.push(applyOperation(num1,num2,ch));
			}else{
				stack.push(Integer.parseInt(String.valueOf(ch)));
			}
		}
		return (int)stack.pop();
	}
	public static void main(String[] args) {
		System.out.println("Answer: "+evaluatePostfix(args[0]));
	}
}