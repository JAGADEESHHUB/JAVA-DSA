package datastructures;

import java.util.Scanner;

class DynamicArray<T> {
	private static final int initialsize = 16;
	private T arr[];
	private int size = 0;
	private int capacity;

	DynamicArray() {// inbuilt constructor
		arr =(T[]) new Object[initialsize];
		size = 0;
		capacity = initialsize;
	}

	private void expand() {
		capacity *= 2;
		arr = java.util.Arrays.copyOf(arr, capacity);

	}

	void insert(T val) {
		if (size == capacity) {
			arr[size] = val;
		} else {
			expand();
			arr[size] = val;
		}
		size++;
	}

	void disp() {
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}

	void spinsert(int pos, T val) {
		if (size == capacity) {
			for (int i = size; i >= pos; i--) {
				arr[i + 1] = arr[i];
			}
		} else {
			expand();
			for (int i = size; i >= pos; i--) {
				arr[i + 1] = arr[i];
			}
		}
		arr[pos] = val;
		size++;
	}

	void del(int posd) {
		for (int i = posd; i <= size; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
	}

	void search(T ind) {
		for (int i = 0; i < capacity; i++) {
			if (arr[i] == ind) {
				System.out.println("index is " + i);
			}
		}
	}
}

public class Arrayimplementation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DynamicArray<Integer> list = new DynamicArray<Integer>();

		while (true) {
			System.out.println("..............................................\n");
			System.out.println("1. press 1 Insert \n");
			System.out.println("2. press 2 Display the list\n");
			System.out.println("3. press 3 Insert at specific position\n");
			System.out.println("4. press 4 delete from a specific position\n");
			System.out.println("5. press 5 to search\n");
			System.out.println("6. press 6 exit\n");
			System.out.println("..............................................\n");

			System.out.println("enter");
			int choise = sc.nextInt();
			switch (choise) {

			case 1:
				System.out.println("enter element to insert");
				int inval = sc.nextInt();
				list.insert(inval);
				break;

			case 2:
				System.out.println("dispalyed elements");
				list.disp();
				break;

			case 3:
				System.out.println("enter position to insert");
				int pos = sc.nextInt();
				System.out.println("enter value");
				int val = sc.nextInt();
				list.spinsert(pos, val);
				break;

			case 4:
				System.out.println("enter position to delete");
				int posd = sc.nextInt();
				list.del(posd);
				break;

			case 5:
				System.out.println("enter the element");
				int ind = sc.nextInt();
				list.search(ind);
				break;
			case 6:
				System.exit(0);// exit syntax
				break;

			default:
				System.out.println("invalid");
			}
		}
	}
}

// <> GENERIC TYPE WE USING (T)AND HERE WE USING THE GENERIC TYPE AS INTIGER.
