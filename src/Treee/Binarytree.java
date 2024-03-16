package Treee;

import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}

class tree {
	Node root;

	void insert(int data) {
		Node n = new Node(data);

		if (root == null) {
			root = n;
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.data > n.data) {
				if (curr.left == null) {
					curr.left = n;
					return;
				} else {
					q.add(curr.left);
				}

			} 
			
			
			if (curr.data < n.data) {
				if (curr.right == null) {
					curr.right = n;
					return;
				} else {
					q.add(curr.right);
				}

			}

		}

	}

	// inorder
	void disp() {

		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.data + " ");

			current = current.right;
		}

		System.out.println();
	}

	// level order
	void disp_levelorder_bfs() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.data + " ");

			if (current.left != null) {
				queue.add(current.left);
			}

			if (current.right != null) {
				queue.add(current.right);
			}
		}

		System.out.println();
	}

	void disp_levelorder_dfs() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.data + " ");

			current = current.right;
		}

		System.out.println();
	}

//	void insertByArray(int[] ar) {
//		if (ar == null) {
//			System.out.println("Array is empty");
//			return;
//		}
//
//		Arrays.sort(ar);
//
//		root = sortedArrBst(ar, 0, ar.length - 1);
//	}
//
//	Node sortedArrBst(int[] ar, int start, int end) {
//		if (start > end) {// fun terminate
//			return null;
//		}
//
//		int mid = (start + end) / 2;// con blk
//		Node newNode = new Node(ar[mid]);
//
//		newNode.left = sortedArrBst(ar, start, mid - 1);
//		newNode.right = sortedArrBst(ar, mid + 1, end);
//
//		return newNode;
//	}

	void inorder() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;
		ArrayList<Integer> ll = new ArrayList();

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			ll.add(current.data);

			current = current.right;
		}

	}

	void insertByArray(ArrayList<Integer> ll) {
		int[] ar = new int[ll.size()];

		for (int i = 0; i < ar.length; i++) {
			ar[i] = ll.get(i);
		}

		Arrays.sort(ar);

		root = sortedArrBst(ar, 0, ar.length - 1);
	}

	Node sortedArrBst(int[] ar, int start, int end) {
		if (start > end) {// fun terminate
			return null;
		}

		int mid = (start + end) / 2;// con blk
		Node newNode = new Node(ar[mid]);

		newNode.left = sortedArrBst(ar, start, mid - 1);
		newNode.right = sortedArrBst(ar, mid + 1, end);

		return newNode;
	}

	int size() {
		int count = 0;
		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			count++;
			current = current.right;
		}
		return count;
	}

	boolean checkele(int d) {
		Node node = root;
		if (node == null)
			return false;

		checkele(node.left.data);
		if (node.data == d) {
			return true;
		}
		checkele(node.right.data);
		return false;
	}

	boolean contains(int d) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			if (current.data == d) {
				return true;
			}
			current = current.right;
		}
		return false;
	}

	int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }
}

public class Binarytree {
	public static void main(String... args) {
		tree t = new tree();
		Scanner s=new Scanner(System.in);
		System.out.println("enter the size of elements");
		int si=s.nextInt();
		System.out.println("enter the elements");
		
		for(int i=1; i<= si; i++) {
			t.insert(s.nextInt());
		}
		 boolean isBalanced = t.isBalanced(t.root);

	        if (isBalanced) {
	            System.out.println("The tree is balanced.");
	        } else {
	            System.out.println("The tree is imbalanced.");
	        }
		
	}
}
  