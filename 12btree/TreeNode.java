public class TreeNode<T>{
    private T data;
    private TreeNode<T> left,right;

    public TreeNode(T value){
	data=value;
    }

    public void setData(T value){
	data=value;
    }

    public T getData(){
	return data;
    }

    public void setLeft(TreeNode<T> LEFT){
	left=LEFT;
    }

    public TreeNode<T> getLeft(){
	return left;
    }

    public void setRight(TreeNode<T> RIGHT){
	right=RIGHT;
    }

    public TreeNode<T> getRight(){
	return right;
    }

    public String toString(){
	return ""+data;
    }

    public static void main(String[]args){
	TreeNode<Integer> a = new TreeNode<Integer>(1);
	a.setRight(new TreeNode<Integer>(2));
	a.getRight().setRight(new TreeNode<Integer>(3));
	System.out.println(a.getRight().getRight());

    }
}
