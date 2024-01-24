package neetcode150.stack;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    private Queue<PetNode> dogs, cats;
    private long count;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getType())) {
            dogs.add(new PetNode(pet, count++));
        } else {
            cats.add(new PetNode(pet, count++));
        }
    }

    public Pet pollAll() {
        if (!dogs.isEmpty() && !cats.isEmpty()) {

            if (dogs.peek().getCount() < cats.peek().getCount()) {
                return dogs.poll().getPet();
            } else {
                return cats.poll().getPet();
            }

        } else if (!dogs.isEmpty()) {
            return dogs.poll().getPet();
        } else {
            return cats.poll().getPet();
        }
    }

    public Dog pollDog() {
        return (Dog) dogs.poll().getPet();
    }

    public Cat pollCat() {
        return (Cat) cats.poll().getPet();
    }

    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }
}

class PetNode {
    private final Pet pet;
    private final long count;

    public PetNode(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return pet.getType();
    }
}

class Pet {
    private final String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {
    public Dog(String type) {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat(String type) {
        super("cat");
    }
}
