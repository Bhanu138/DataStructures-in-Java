import java.util.*;
class PostfixToPrefix{
	public static String postfixToPrefix(String postfix){
		return InfixToPrefix.toPrefix(PostToInfix.postfixToInfix(postfix));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter Postfix Expression : ");
		String postfix = sc.nextLine();
		System.out.println("Prefix Expression is : "+postfixToPrefix(postfix));
	}
}