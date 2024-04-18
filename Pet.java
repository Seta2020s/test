import java.util.List;

import animals.Animal;
public class Pet extends Animal implements Training {
    private List<String> commands;

    public Pet(String name, String birthDate, List<String> commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    @Override
    public void printCommands() {
        System.out.println("Команды для " + getName() + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    @Override
    public void teachCommand(String command) {
        commands.add(command);
        System.out.println("Животное " + getName() + " обучено команде: " + command);
    }
}