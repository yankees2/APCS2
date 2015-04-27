import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) {
	if(root==null){
	    root=new TreeNode<E>(d);
	}else{
	    TreeNode<E> branch = new TreeNode<E>(d);
	    add(root,branch);
	}
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    private void add( TreeNode<E> curr, TreeNode<E> bn ) {
	if(curr.getLeft()==null && curr.getRight()!=null){
	    curr.setLeft(bn);
	}else if(curr.getLeft()!=null && curr.getRight()==null){
	    curr.setRight(bn);
	}else if(curr.getLeft()==null && curr.getRight()==null){
	    Random rand = new Random();
	    int branch = rand.nextInt(2);
	    if(branch==0){
		curr.setLeft(bn);
	    }else{
		curr.setRight(bn);
	    }
	}else{
	    Random rand = new Random();
	    int branch = rand.nextInt(2);
	    if(branch==0){
		add(curr.getLeft(),bn);
	    }else{
		add(curr.getRight(),bn);
	    }
	}
	
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	System.out.println(curr.getData());
	if(curr.getLeft()!=null || curr.getRight()!=null){
	    if(curr.getLeft()!=null){
		preOrder(curr.getLeft());
	    }
	    if(curr.getRight()!=null){
		preOrder(curr.getRight());
	    }
	}
	
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	if(curr.getLeft()!=null){
	    inOrder(curr.getLeft());
	}
	System.out.println(curr.getData());
	if(curr.getRight()!=null){
	    inOrder(curr.getRight());
	}
	    
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal    
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if(curr.getLeft()!=null || curr.getRight()!=null){
	    if(curr.getLeft()!=null){
		postOrder(curr.getLeft());
	    }
	    if(curr.getRight()!=null){
		postOrder(curr.getRight());
	    }
	}
	System.out.println(curr.getData());
    }
    
    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root,1 );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr,int count ) {
	if(curr.getLeft()==null && curr.getRight()==null){
	    return count;
	}else if(curr.getLeft()!=null && curr.getRight()==null){
	    return getHeight(curr.getLeft(),count+1);
	}else if(curr.getLeft()==null && curr.getRight()!=null){
	    return getHeight(curr.getRight(),count+1);
	}else{
	    if(getHeight(curr.getLeft(),count+1)>=getHeight(curr.getRight(),count+1)){
		return getHeight(curr.getLeft(),count+1);
	    }else{
		return getHeight(curr.getRight(),count+1);
	    }
	}
    }
  
    /*======== private String getLevel() ==========
      Inputs:   TreeNode<E> curr
      int level 
      Returns: A string containing all the elements on the
      given level with respect to the curr treenode
      ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level) {
	if(level==0){
	    return ""+curr.getData();
	}
	String out = "";
	int x = 0;
	TreeNode<E> left = curr;
        TreeNode<E> right = curr;
	while(x<level){
	    if(left.getLeft()!=null){
		left = left.getLeft();
		out+=getLevel(left,level-1);
	    }
	    if(right.getRight()!=null){
		right = right.getRight();
		out+=getLevel(right,level-1);
	    }
	    x++;

	}
	return out;
    }

    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
      0
      1      2
      3  4   5
      ====================*/
    public String toString() {
	String out = "";
	int x = 0;
	while(x<getHeight()){
	    out+=getLevel(getRoot(),x)+" \n";
	    x++;
	}
	return out;
    }

    public TreeNode<E> getRoot(){
	return root;
    }
	

    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	t.add(1);
	t.add(2);
	t.add(3);
	t.add(4);
	t.add(5);
	t.add(6);
	t.add(7);
	System.out.println(t.toString()+"\n\n\n\n"+t.getHeight());
	//t.preOrder(t.getRoot());
	//t.preOrder(t.getRoot());
	//t.postOrder(t.getRoot());

	// for ( int i=0; i < 8; i++ ) 
	// 	t.add( i );
	// System.out.println( "Pre-order: ");
	// t.traverse( PRE_ORDER );
	// System.out.println( "In-order: ");
	// t.traverse( IN_ORDER );
	// System.out.println( "Post-order: ");
	// t.traverse( POST_ORDER );
	// System.out.println( "Height: " + t.getHeight() );

	// System.out.println( t );
    }
}

