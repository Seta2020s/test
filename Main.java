import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Вывести список команд для животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewAnimal(registry, scanner);
                    break;
                case 2:
                    printAnimalCommands(registry, scanner);
                    break;
                case 3:
                    teachAnimalCommand(registry, scanner);
                    break;
                case 4:
                    printAnimalsByBirthDate(registry);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    private static void addNewAnimal(AnimalRegistry registry, Scanner scanner) {
        System.out.println("Добавление нового животного в реестр.");
        System.out.print("Введите имя нового животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения нового животного: ");
        String birthDate = scanner.nextLine();
        System.out.print("Введите список команд для нового животного (через запятую): ");
        String commandString = scanner.nextLine();
        List<String> commands = Arrays.asList(commandString.split(","));
        Pet newPet = new Pet(name, birthDate, commands);
        registry.addAnimal(newPet);
        System.out.println("Новое животное успешно добавлено в реестр.");
    }

    private static void printAnimalCommands(AnimalRegistry registry, Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Список команд для животного " + name + ":");
        registry.printAnimalCommands(name);
    }
    
    private static void teachAnimalCommand(AnimalRegistry registry, Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новую команду: ");
        String command = scanner.nextLine();
        registry.teachAnimalCommand(name, command);
    }

    private static void printAnimalsByBirthDate(AnimalRegistry registry) {
        registry.printAnimalsByBirthDate();
    }
}