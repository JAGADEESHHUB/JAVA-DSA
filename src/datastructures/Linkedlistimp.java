package datastructures;

import java.util.*;

class Node {
	int data;
	Node nextref;// reference

}

class Linkedlist {
	Node head;
	Node tail;

	void insert(int d) {
		Node n = new Node();

		if (head == null) {
			n.data = d;
			head = n;
			tail = n;
		} else {
			n.data = d;
			tail.nextref = n;
			tail = n;
		}
	}

	void disp() {
		Node temp = head;
		while (temp.nextref != null) {
			System.out.println(temp.data);
			temp = temp.nextref;
		}
		System.out.println(temp.data);// manually printing last data
	}

	int size() {
		Node temp = head;
		int i = 0;
		while (temp.nextref != null) {
			i++;
			temp = temp.nextref;
		}
		return i + 1;
	}

	int get(int pos) {
		Node temp = head;
		for (int i = 1; i < pos; i++) {// rendavadhu value venum na loop oru vati run aganum...
			temp = temp.nextref;
		}
		return temp.data;
	}

	void delete(int pos) {
		Node temp = head;
		if (pos == 1) {
			// head=head.nextref;
			head = temp.nextref; // head ku next iruka element ha head ha poturuvan...
		}
		for (int i = 1; i < pos - 1; i++) {// ona delete panna porom na adhuku manadi node venum so pos-1
			temp = temp.nextref;
		}

		temp.nextref = temp.nextref.nextref;// pos 2 kudutha for loop hey pogadhu just 1st and 3rd element ha vachu
											// velaiya mudichudhum
	}

	void deleteLast() {// last value va delete pannanum na adhuku munadi iruka valu ref ha null akanum
						// so that the ref connection disconnect agum..
		Node temp = head;
		for (int i = 1; i < size() - 1; i++) {
			temp = temp.nextref;
		}
		temp.nextref = null;
	}

	void reverse() {
		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {
			next = current.nextref; // Save the next node
			current.nextref = prev; // link ha reverse panrom
			prev = current; // prev ha current node ku move panrom
			current = next; // next node ku move panrom
		}
		head = prev; // last node become new head
	}

}

public class Linkedlistimp {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();

		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);
		ll.insert(6);
		ll.disp();
		System.out.println();

		ll.reverse();

		ll.disp();

	}

}
