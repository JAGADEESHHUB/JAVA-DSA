package datastructures;

import java.util.*;

class Tnode {
	int data;
	Tnode left;
	Tnode right;
}

class BST {
	Tnode root;

	void insert(int d) {
		Tnode n = new Tnode();
		n.data = d;
		
		if(root==null) {
			root=n;
			return;            
		}

		Queue<Tnode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Tnode current = q.poll();
			if (current.data > n.data) {
				if (current.left == null) {
					current.left = n;
					break;// or return
				} else {
					q.add(current.left);
				}
			} 
			if (current.data < n.data) {
				if (current.right == null) {
					current.right = n;
					break;// or return
				} else {
					q.add(current.right);
				}
			}
		}
    }
	
	
	void disp() {
		
	}
	
	
	
	
	
}

public class BstTree {
	public static void main(String[] args) {
		BST t=new BST();
		t.insert(1);
		t.insert(2);
		t.insert(3);
	}
}
