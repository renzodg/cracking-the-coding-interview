package c3__stacks_and_queues.q5_sort_stack;

import java.util.Stack;

import util.AssortedMethods;

public class Question {
	
	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (!inStack.isEmpty()) {
			count++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (!left.isEmpty() || !right.isEmpty()) {
			if (left.isEmpty()) {
				inStack.push(right.pop());
			} else if (right.isEmpty()) {
				inStack.push(left.pop());
			} else if (left.peek().compareTo(right.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}

	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		/* Copy the elements back. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0, 1000);
			s.push(r);
		}

		System.out.println(s);
		sort(s);
		System.out.println(s);
	}
	
}