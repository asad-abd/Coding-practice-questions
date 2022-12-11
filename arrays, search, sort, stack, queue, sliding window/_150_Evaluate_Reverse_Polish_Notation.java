class Solution {
    // simple stack question
    //soln 2: 
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                
                switch(token){
                    case "/":
                        stack.push(a / b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                }
            }
            else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
    
    // soln 1: just a different way to implement using try-catch: slow runtime maybe due to the same reason
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            try{
                int num = Integer.parseInt(token);
                stack.push(num);
            }
            catch(Exception e){
                int a, b;
                b = stack.pop();
                a = stack.pop();
                switch(token){
                    case "/":
                        stack.push(a / b);
                        break;
                        
                    case "*":
                        stack.push(a * b);
                        break;
                        
                    case "+":
                        stack.push(a + b);
                        break;
                        
                    case "-":
                        stack.push(a - b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}