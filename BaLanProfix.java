import java.util.Stack;

public class BaLanProfix {
    public static String ans = "";
    public static Stack<String> stack_ = new Stack<>();
    public static String convert (String inp){
        int length = inp.length();
        for ( int i = 0; i < length; i++ ){
            if (inp.charAt(i) == '('){
                stack_.push(String.valueOf(inp.charAt(i)));
            }
            if(inp.charAt(i) != '+' && inp.charAt(i) != '-' && inp.charAt(i) != '*' && inp.charAt(i) != '/' && inp.charAt(i) != '(' && inp.charAt(i) != ')' ){
                ans += inp.charAt(i);
            }
            if(inp.charAt(i) == '+' || inp.charAt(i) == '-'){
                while(!stack_.isEmpty() && (stack_.peek().equals("/") || stack_.peek().equals("*") || stack_.peek().equals("/") || stack_.peek().equals("*"))){
                    ans += " " + stack_.pop();
                }
                ans += " ";
                stack_.push(String.valueOf(inp.charAt(i)));
            }
            if(inp.charAt(i) == '*' || inp.charAt(i) == '/'){
                ans += " ";
                stack_.push(String.valueOf(inp.charAt(i)));
            }
            if (inp.charAt(i) == ')'){
                while(!stack_.isEmpty() && !stack_.peek().equals("(")) {
                    ans += " " + stack_.pop();
                }
                if(!stack_.isEmpty()){
                    stack_.pop();
                }
            }
        }
        while(!stack_.isEmpty()) {
            ans += " " + stack_.pop();}
        return  ans;
    }
}

void main(String[] args) {
    String input = "(20-(4+2)/3)-8*(5+1)";
    System.out.println(BaLanProfix.convert(input));
}