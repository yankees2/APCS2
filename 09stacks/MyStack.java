public class MyStack<T>{
    private MyLinkedList<T> stack;

    public MyStack(){
	stack=new MyLinkedList<T>();
    }

    public void push(T element){
	stack.add(0,element);
    }

    public T pop(){
	if(stack.size()==0){
	    return null;
	}
	return stack.remove(0);
    }

    public T peek(){
	if(stack.size()==0){
	    return null;
	}
	return stack.get(0);
    }

    public String toString(){
	return stack.toString();
    }

    public static void main(String[]meow){
	MyStack<Integer> test = new MyStack<Integer>();
	//System.out.println(test.stack==0);
	//System.out.println(test.pop());
	System.out.println(test.peek());
	test.push(6);
	test.push(7);
	test.push(97);
	test.push(76);
	test.push(4);
	test.push(567);
	test.push(89);
	test.push(1);
	System.out.println(test);
	System.out.println(test.pop());
	System.out.println(test);
	// System.out.println(test.peek());
	// System.out.println(test);
	//System.out.println(test.size()==0);
    }
}
