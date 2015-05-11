import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
      BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if(curr==null){
	    curr=t;
	    return t;
	}else{
	    if(curr.getData().compareTo(t.getData())>0){
		curr.setLeft(add(curr.getLeft(),t));
	    }else{
		curr.setRight(add(curr.getRight(),t));
	    }
	}
	return curr;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	if (curr == null) {
	    return curr;
	} else if (isLeaf(curr) && curr.getData().compareTo(c) == 0) {
	    return null;
	} else if (curr.getData().compareTo(c) > 0) {
	    curr.setLeft(remove(curr.getLeft(), c));
	} else if (curr.getData().compareTo(c) < 0) {
	    curr.setRight(remove(curr.getRight(), c));
	} else {
	    curr.setData(findReplacement(curr.getRight()).getData());
	    curr.setRight(remove(curr.getRight(), curr.getData()));
	}
	return curr;
    }

    private BSTreeNode<T> findReplacement(BSTreeNode<T> s){
	if(s==null){
	    return null;
	}
	if(s.getLeft()==null){
	    return s;
	}
	return findReplacement(s.getLeft());
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    /**
     * stolen from: Dennis Yatunin
     * (no not really stolen from, donated by)
     */

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 
		       Math.pow(2, height - targetLevel + 1) - 
		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	for (int level = 1; level < height; level++){
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }

   
    public static void main( String[] args ) {
	BSTree<Integer>t = new BSTree<Integer>();
	t.add(11);
	t.add(5);
	t.add(2);
	t.remove(13);
	t.remove(9);
	System.out.println("\n\n\n" + t.toString());
	t.inOrder();
	t.add(7);
	t.add(13);
	t.add(50);
	t.add(9);
	t.add(70);
	t.add(19);
	System.out.println(t.toString());
	t.inOrder();
	t.remove(13);
	t.remove(9);
	System.out.println("\n\n\n" + t.toString());
	t.inOrder();
    }

}
