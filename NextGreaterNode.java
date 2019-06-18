import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<>();
		A.add(2);
		A.add(1);
		A.add(5);
		int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < A.size(); ++i) {
            
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)){
                //System.out.println(i+"/"+A.get(stack.peek())+".."+stack.pop());    
                res[stack.pop()] = A.get(i);
            }
            stack.push(i);
        }
	}

}
