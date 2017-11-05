import java.util.Stack;

// http://scriptasylum.com/tutorials/infix_postfix/algorithms/infix-postfix/index.htm
public class InfixToPostFix {

	public static String infixToPostFix(String in) {
		Stack<Character> stack = new Stack<Character>();
		String post = "";
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			if (isOperator(c)) {
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
						post += stack.pop();
					}
					stack.push(c);
				}
			} else {
				post += c;
			}
		}
		
		while(!stack.isEmpty()) {
			post += stack.pop();
		}
		return post;
	}

	public static int precedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else
			return 0;
	}

	public static boolean isOperator(char element) {
		if (element == '*' || element == '-' || element == '/'
				|| element == '+')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(infixToPostFix("a+b*c-d"));
	}

}
