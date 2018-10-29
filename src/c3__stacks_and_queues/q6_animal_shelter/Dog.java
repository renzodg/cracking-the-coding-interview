package c3__stacks_and_queues.q6_animal_shelter;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	public String name() {
		return "Dog: " + this.name;
	}

}