package datastructures;

class DNode {
	int data;
	DNode pre;
	DNode next;
}

class Doublyll {
	DNode head;
	DNode tail;

	void insert(int d) {
		DNode n = new DNode();
		if (head == null) {
			n.data = d;
			head = n;
			tail = n;
		} else {
			n.data = d;
			tail.next = n;
			n.pre = tail;
			tail = n;
		}
	}

	void disp() {
		DNode temp = head;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

		System.out.println(temp.data);
	}

	void reverseDisp() {
		DNode temp = tail;
		while (temp.pre != null) {
			System.out.println(temp.data);
			temp = temp.pre;
		}

		System.out.println(temp.data);
	}

	boolean isPal() {
		DNode s = head;
		DNode e = tail;

		while (s != null) {
			if (s.data != e.data) {
				return false;
			}
			s = s.next;
			e = e.pre;
		}

		return true;
	}

}


public class Doublylinkedlist {

	public static void main(String[] args) {
		Doublyll dl = new Doublyll();

		dl.insert(2);
		dl.insert(1);
		dl.insert(2);
		dl.insert(3);
		dl.insert(4);
		dl.insert(5);
		dl.disp();
		System.out.println();
		dl.reverseDisp();
		System.out.println();
		System.out.println("Is palindrome? "+dl.isPal());
	}

}
