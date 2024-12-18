import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        ListMonster listM = new ListMonster();
        ListPlayer listPlayer = new ListPlayer(); // Tambahkan listPlayer untuk daftar pemain

        // Menambahkan vertex dengan nama
        graph.addVertex(0, "Entry");
        graph.addVertex(1, "Treasure");
        graph.addVertex(2, "Kroco");
        graph.addVertex(3, "Monster Zero");
        graph.addVertex(4, "Buff");
        graph.addVertex(5, "Kong");
        graph.addVertex(6, "Treasure");
        graph.addVertex(7, "Godzilla");
        graph.addVertex(8, "Exit");
        
        // Menambahkan edge sesuai dengan peta dungeon
        graph.addEdge(0, 5, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 6, 3);
        graph.addEdge(1, 7, 5);
        graph.addEdge(2, 5, 6);
        graph.addEdge(7, 8, 4);
        graph.addEdge(5, 8, 2);

        int choice = 1;

        while (true) {
            cls();
            banner();
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
                        playMenu(scanner, listPlayer);
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

    private static void playMenu(Scanner scanner, ListPlayer listPlayer) {
        cls();
        banner();
        System.out.println("\n--- Play Menu ---");
        System.out.println("Enter player details:");
    
        System.out.print("Name: ");
        String name = scanner.nextLine();
    
        String role;
        while (true) {
            System.out.print("Role (Mage/Fighter): ");
            role = scanner.nextLine();
            if (role.equalsIgnoreCase("Mage") || role.equalsIgnoreCase("Fighter")) {
                break;
            } else {
                System.out.println("Invalid role. Please choose 'Mage' or 'Fighter'.");
            }
        }
    
        int attack, defense, health;
        if (role.equalsIgnoreCase("Mage")) {
            attack = 120;
            defense = 50;
            health = 100;
        } else { // fighter
            attack = 100;
            defense = 80;
            health = 150;
        }
    
    
        int turn = 1;
        listPlayer.addPlayer(turn, name, attack, defense, health, role);
    
        System.out.println("\nPlayer added successfully!");
        listPlayer.displayPlayer();  
        cls();
        banner();
        // Mulai game
        System.out.println("\n--- Game Started! ---");
        banner();
        listPlayer.displayMap(); 
    
        System.out.println("\nPrepare for your adventure!");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        

        // disini ntr method masuk ke game
    }
    

    private static void banner() {
        System.out.println("   ____           ____  _   _ _   _  ____ _____ ___  _   _   ___ \r\n" + //
                "  / ___|         |  _ \\| | | | \\ | |/ ___| ____/ _ \\| \\ | | |_ _|\r\n" + //
                " | |  _   _____  | | | | | | |  \\| | |  _|  _|| | | |  \\| |  | | \r\n" + //
                " | |_| | |_____| | |_| | |_| | |\\  | |_| | |__| |_| | |\\  |  | | \r\n" + //
                "  \\____|         |____/ \\___/|_| \\_|\\____|_____\\___/|_| \\_| |___|\r\n" + //
                "                                                                 ");
    }

    private static void roleMenu(Scanner scanner) {
        cls();
        banner();
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
                    System.out.println("Displaying roles....");
                    System.out.println("1. Mage - Advantage: Can reveal map with special skill.");
                    System.out.println("2. Fighter - Advantage: High health and greater attack damage.");
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);
    }

    private static void aboutMenu(Scanner scanner) {
        cls();
        banner();
        System.out.println("\n---- About Menu ----");
        System.out.println("G-DUNGEON I is an action-packed dungeon exploration game. Survive and conquer the dungeon!");
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
