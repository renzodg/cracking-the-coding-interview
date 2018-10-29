package c3__stacks_and_queues.q6_animal_shelter;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {
	
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogs.add((Dog) a);
		} else if (a instanceof Cat) {
			cats.add((Cat) a);
		}
	}

	public Animal dequeueAny() {
		if (dogs.isEmpty()) {
			return dequeueCats();
		} else if (cats.isEmpty()) {
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	public Animal peek() {
		if (dogs.isEmpty()) {
			return cats.peek();
		} else if (cats.isEmpty()) {
			return dogs.peek();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}

	public int size() {
		return dogs.size() + cats.size();
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Dog peekDogs() {
		return dogs.peek();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}

	public Cat peekCats() {
		return cats.peek();
	}
}