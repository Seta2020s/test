package animals;
import java.util.List;

public class Cat extends Animal {
    private List<String> petCommands;

    public Cat(String name, String birthDate, List<String> commands) {
        super(name, birthDate);
        this.petCommands = commands;
    }

    @Override
    public void printCommands() {
        System.out.println("Команды для " + getName() + ":");
        for (String command : petCommands) {
            System.out.println(command);
        }
    }
}
