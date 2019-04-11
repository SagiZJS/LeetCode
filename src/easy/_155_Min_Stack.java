package easy;

public class _155_Min_Stack {
	StackNode tail=null;
	    
	    public _155_Min_Stack() {
			// TODO Auto-generated constructor stub
	        
	    }
	    
	    public void push(int x) {
	    	StackNode temp =new StackNode(x);
	    	temp.pre=tail;
	    	if(tail==null) {
	    		temp.min=x;
	    	}else if(tail.min>x) {
	    		temp.min=x;
	    	}else{
	    		temp.min=tail.min;
	    	}
	        tail=temp;
	    
	    }
	    
	    public void pop() {
	        tail = tail.pre;
	    }
	    
	    public int top() {
	        return tail.val;
	    }
	    
	    public int getMin() {
	        return tail.min;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class StackNode{
    int val;
    int min=Integer.MAX_VALUE;
    StackNode pre=null;
    public StackNode(int val){
        this.val=val;
    }
}