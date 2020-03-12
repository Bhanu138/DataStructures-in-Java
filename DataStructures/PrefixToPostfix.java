import java.util.*;
class PrefixToPostfix{
	public static String prefixToPostfix(String postfix){
		return InfixToPostfix.toPostfix(PrefixToInfix.prefixToInfix(postfix));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter Prefix Expression : ");
		String postfix = sc.nextLine();
		System.out.println("Postfix Expression is : "+prefixToPostfix(postfix));
	}
}