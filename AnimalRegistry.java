import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import animals.Animal;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void printAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.printCommands();
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void teachAnimalCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name) && animal instanceof Training) {
                ((Training) animal).teachCommand(command);
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено или не может быть обучено командам.");
    }

    public void printAnimalsByBirthDate() {
        Collections.sort(animals, Comparator.comparing(Animal::getBirthDate));
        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + ": " + animal.getBirthDate());
        }
    }
}