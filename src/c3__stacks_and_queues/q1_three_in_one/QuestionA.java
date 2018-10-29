package c3__stacks_and_queues.q1_three_in_one;

import java.util.Arrays;

public class QuestionA {

	/*
	 * Describe how you could use a single array to implement three stacks.
	 * 
	 * Approach 1: Fixed Division
	 */

	public static void main(String[] args) throws FullStackException {
		FixedMultiStack stacks = new FixedMultiStack(4);
		printStacks(stacks);
		stacks.push(0, 10);
		printStacks(stacks);
		stacks.push(1, 20);
		printStacks(stacks);
		stacks.push(2, 30);
		printStacks(stacks);

		stacks.push(1, 21);
		printStacks(stacks);
		stacks.push(0, 11);
		printStacks(stacks);
		stacks.push(0, 12);
		printStacks(stacks);

		System.out.println("popping");
		stacks.pop(0);
		printStacks(stacks);

		stacks.push(2, 31);
		printStacks(stacks);

		stacks.push(0, 13);
		printStacks(stacks);
		stacks.push(1, 22);
		printStacks(stacks);

		stacks.push(2, 31);
		printStacks(stacks);
		stacks.push(2, 32);
		printStacks(stacks);
	}

	private static void printStacks(FixedMultiStack stacks) {
		System.out.println(Arrays.toString(stacks.getValues()));
	}
}
