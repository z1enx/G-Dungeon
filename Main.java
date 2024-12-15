import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListMonster list_monster = new ListMonster();
        //list_monster.displayMonster("Godzilla");
        //list_monster.displayMonster("Monster Zero");
        //list_monster.displayMonster("Kong");
        list_monster.displayListMonster();

        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        while (true) {
            cls();
            System.out.println("\n=== Monster Menu ===");
            System.out.println("1. Play");
            System.out.println("2. Role");
            System.out.println("3. About");
            System.out.println("4. Exit");
            System.out.println("Use 'W' for Up, 'S' for Down, and Enter to Select.");

            switch (choice) {
                case 1: System.out.println("> Play"); break;
                case 2: System.out.println("> Role"); break;
                case 3: System.out.println("> About"); break;
                case 4: System.out.println("> Exit"); break;
            }

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("W") && choice > 1) {
                choice--; 
            } else if (input.equals("S") && choice < 4) {
                choice++;
            } else if (input.equals("")) {
                switch (choice) {
                    case 1:
                        playMenu(scanner); 
                        break;
                    case 2:
                        roleMenu(scanner);
                        break;
                    case 3:
                        aboutMenu(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the game. Goodbye!");
                        scanner.close();
                        return;
                }
            } else {
                System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
            }
        }
    }
    private static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void playMenu(Scanner scanner) {
        System.out.println("\n--- Play Menu ---");
        System.out.println("1. Start Game");
        System.out.println("2. Back to Main Menu");
        
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Starting game...");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);
    }

    private static void roleMenu(Scanner scanner) {
        System.out.println("\n--- Role Menu ---");
        System.out.println("1. View Role");
        System.out.println("2. Back to Main Menu");
        
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Displaying roles...");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);
    }

    private static void aboutMenu(Scanner scanner) {
        System.out.println("\n--- About Menu ---");
        System.out.println("BLA BLA BLA");
        System.out.println("1. Back to Main Menu");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                return;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 1);
    }
}
