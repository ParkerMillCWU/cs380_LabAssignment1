import java.util.Stack;

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
		   //set up stack to store unsearched branches
		   Stack<Node> s = new Stack();
		   //temp to store current node
		   Node temp;

		   //if root is null there is no tree
		   if(root == null)
			   return;
		   //push root to stack to start
		   s.push(root);

		   //iterate while there are nodes in the stack
		   while(!s.isEmpty())
		   {
			   //get current node from top of stack
			   temp = s.pop();
			   //print value
			   System.out.print(temp.value + " ");
			   //check for right subtree
			   if(temp.right != null)
				   s.push(temp.right);
			   //check for left subtree
			   if(temp.left != null)
				   s.push(temp.left);
		   }
		   
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
			if(root == null)
				return;

			if(root.left !=null)
				inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			if(root.right != null)
				inOrderTraversal(root.right);
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
         	if(root == null)
				 return;

		    if(root.left != null)
				postOrderTraversal(root.left);
			if(root.right != null)
				postOrderTraversal(root.right);
			System.out.print(root.value + " ");
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){
		   //loop until you either find the key or key is not in tree
		   while(true)
			{
				//root is null then either the tree doesn't exist or you have reached the end of a branch and the key is not in the tree
				if(root == null)
					return false;
				//if key is less than root, set root to the left subtree
				if(key < root.value)
				{
					root = root.left;
					continue;
				}
				//if key is greater than root, set root to right subtree
				if(key > root.value)
				{
					root = root.right;
					continue;
				}
				//if key equals root, return true
				if(key == root.value)
					return true;
			}
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
		 //loop
         while(root !=null)
		 {
			 //if there is a left subtree go there
			 if(root.left !=null)
			 {
				 root = root.left;
				 continue;
			 }
			 //if there isn't this is the minimun value
			 else
				 return root.value;
		 }
		 //if root is null, tree doesn't exist, return flag value
		 return Integer.MIN_VALUE;
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
         //implement in here
		   return 0;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");

		  System.out.println(t1.getMin(t1.root));
	      System.out.println();
	           
	      
	   }  
	}
