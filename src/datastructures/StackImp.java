package datastructures;
//we can use stack for (palindrome, reverse,)
class StackIM {
	private int size;
	int ar[];

	StackIM(int size) {
		this.size = size;
		ar = new int[size];
	}

	int ref = -1;

	void push(int num) {
		ref++;
		if (ref ==ar.length) {
			ref--;
			System.out.println("Stack is full");
			return;
		}
		ar[ref] = num;
		

	}

	int pop() {
		if (ref == -1) {
			System.out.println("stack underflow");
			return 0;
		}
		int tmp = ar[ref];
		ar[ref] = 0;
		ref--;
		return tmp;
	}

	boolean isEmpty() {
		if (ref == -1) {
			return true;
		} else {
			return false;
		}
	}

	void disp() {
		for (int x : ar) {
			System.out.print(x);
		}
		System.out.println();
	}
	

}

public class StackImp {
	
	static boolean pal(String input) {
		char ch[]=input.toCharArray();
		int size =ch.length;
		StackIM nn = new StackIM(size);
		
		for(int i=0; i<ch.length; i++) {
			nn.push(ch[i]);
		}
		
		for(int i=0; i<ch.length; i++) {
			if(nn.pop()!=ch[i]) {
				return false;
			}
		}
		return true;
		
	}

	public static void main(String[] args) {

		StackIM nn = new StackIM(3);
		nn.push(1);
		nn.push(2);
		nn.push(3);
		nn.push(1);
		nn.push(9);
		nn.push(1);
		nn.push(2);
		nn.push(3);
		nn.push(1);
		nn.push(9);
		nn.disp();
		// nn.disp();
		System.out.println(nn.isEmpty());

		nn.pop();
		nn.pop();
		nn.pop();
		nn.pop();
		nn.pop();
		nn.pop();
		nn.pop();
		nn.pop();
		nn.disp();
		System.out.println(nn.isEmpty());
		
System.out.println("..................................Problem using stack palindrome check...........................................");
		
		String name="h";
		System.out.println(pal(name));
		
		
		
		
		

	}

}
