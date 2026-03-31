import java.util.Scanner;
public class Main {
	static class Node {
	    int value;
	    Node leftChild;
	    Node rightChild;

	    public Node(int value) {
	        this.value = value;
	        this.leftChild = null;
	        this.rightChild = null;
	    }
	}
	static class BinaryTree {
	    Node rootNode = null;
	    public void insertNode(int element) {

	        if (rootNode == null) {
	            rootNode = new Node(element);
	        } else {
	            Node head = rootNode;
	            Node currentNode;

	            while (true) {
	                currentNode = head;

	                if (head.value > element) {
	                    head = head.leftChild;

	                    if (head == null) {
	                        currentNode.leftChild = new Node(element);
	                        break;
	                    }
	                } else {

	                    head = head.rightChild;

	                    if (head == null) {
	                        currentNode.rightChild = new Node(element);
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    public void postOrder(Node node) {
	        if (node == null)
	            return;

	        postOrder(node.leftChild);
	        postOrder(node.rightChild);
	        System.out.println(node.value);
	    }
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		BinaryTree tree = new BinaryTree();
		while(in.hasNextInt()==true)
		{
			int input=in.nextInt();
			//System.out.println(input);
	        tree.insertNode(input);
		}
		tree.postOrder(tree.rootNode);

	}

}
