import java.util.Scanner;

import java.util.Scanner;

public class DungeonGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
<<<<<<< HEAD
        ListPlayer listPlayer = new ListPlayer();
        Fight fight = new Fight();
        ListMonster listMonster = new ListMonster();

        // Menambahkan vertex dan edges seperti sebelumnya
=======
        ListMonster listM = new ListMonster();
        ListPlayer listPlayer = new ListPlayer(); // Tambahkan listPlayer untuk daftar pemain

        // Menambahkan vertex dengan nama
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
        graph.addVertex(0, "Entry");
        graph.addVertex(1, "Treasure1");
        graph.addVertex(2, "Kroco");
        graph.addVertex(3, "Monster Zero");
        graph.addVertex(4, "Buff");
        graph.addVertex(5, "Kong");
        graph.addVertex(6, "Treasure2");
        graph.addVertex(7, "Godzilla");
        graph.addVertex(8, "Exit");
<<<<<<< HEAD

        graph.addEdge(0, 6, 4);
=======
        
        // Menambahkan edge sesuai dengan peta dungeon
        graph.addEdge(0, 5, 4);
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 7, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 6, 3);
        graph.addEdge(3, 5, 9);
        graph.addEdge(7, 8, 4);
<<<<<<< HEAD
        graph.addEdge(5, 9, 2);
        graph.addEdge(5, 8, 10);
        graph.addEdge(2, 5, 6);

        // Menu utama
        int choice = 1;
=======
        graph.addEdge(5, 8, 2);

        int choice = 1;

>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
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
<<<<<<< HEAD
                case 1:
                    System.out.print("> Play");
                    break;
                case 2:
                    System.out.print("> Role");
                    break;
                case 3:
                    System.out.print("> About");
                    break;
                case 4:
                    System.out.print("> Exit");
                    break;
=======
                case 1: System.out.println("> Play"); break;
                case 2: System.out.println("> Role"); break;
                case 3: System.out.println("> About"); break;
                case 4: System.out.println("> Exit"); break;
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
            }

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("W") && choice > 1) {
                choice--;
            } else if (input.equals("S") && choice < 4) {
                choice++;
            } else if (input.equals("")) {
                switch (choice) {
                    case 1:
<<<<<<< HEAD
                        playMenu(scanner, listPlayer, graph);
=======
                        playMenu(scanner, listPlayer);
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
                        break;
                    case 2:
                        roleMenu(scanner);
                        break;
                    case 3:
                        aboutMenu(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the game. Goodbye!");
<<<<<<< HEAD
=======
                        scanner.close();
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
                        return;
                }
            } else {
                System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
            }
        }
<<<<<<< HEAD
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void banner() {
        System.out.println("   ____           ____  _   _ _   _  ____ _____ ___  _   _   ___ \r\n"
                + "  / ___|         |  _ \\| | | | \\ | |/ ___| ____/ _ \\| \\ | | |_ _|\r\n"
                + " | |  _   _____  | | | | | | |  \\| | |  _|  _|| | | |  \\| |  | | \r\n"
                + " | |_| | |_____| | |_| | |_| | |\\  | |_| | |__| |_| | |\\  |  | | \r\n"
                + "  \\____|         |____/ \\___/|_| \\_|\\____|_____\\___/|_| \\_| |___|\r\n"
                + "                                                                 ");
    }

    public static void roleMenu(Scanner scanner) {
=======
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
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
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

<<<<<<< HEAD
    public static void aboutMenu(Scanner scanner) {
=======
    private static void aboutMenu(Scanner scanner) {
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
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
<<<<<<< HEAD

    public static void playMenu(Scanner scanner, ListPlayer listPlayer, Graph graph) {
        cls();
        banner();
        System.out.println("\n--- Play Menu ---");
        System.out.println("Enter player details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int attack, defense, health;
        String role;
        while (true) {
            System.out.print("Role (Mage/Fighter): ");
            role = scanner.nextLine();
            if (role.equalsIgnoreCase("Mage") || role.equalsIgnoreCase("Fighter")) {
                if (role.equalsIgnoreCase("Mage")) {
                    attack = 120;
                    defense = 50;
                    health = 100;
                } else { // Fighter
                    attack = 100;
                    defense = 80;
                    health = 150;
                }
                break;
            } else {
                System.out.println("Invalid role. Please choose 'Mage' or 'Fighter'.");
            }
        }

        int turn = 1;
        listPlayer.addPlayer(turn, name, attack, defense, health, role, "Entry");

        System.out.println("\nPlayer added successfully!");
        listPlayer.displayPlayer();

        // Start the game
        System.err.println("Starting the game...");
        //Map Game
        listPlayer.displayMap();
        scanner.nextLine();
        cls();
        DungeonGame game = new DungeonGame();
        game.startGame(graph, listPlayer);
    }

    public void startGame(Graph graph, ListPlayer listPlayer) {
        Scanner scanner = new Scanner(System.in);
        String currentLocation = "Entry";
        String previousLocation = "None";
        TravelLog travelLog = new TravelLog();
        travelLog.addLog(currentLocation, 0, previousLocation);
        int totalDistance = 0;

        while (true) {
            cls();

            listPlayer.displayMap();

            graph.displayCurrentLocation(currentLocation);

            System.out.println("\nAvailable Locations:");
            graph.displayAdjacentLocations(currentLocation);

            System.out.print("\nChoose location to visit: ");
            String destinationName = scanner.nextLine();
            cls();

            if (destinationName.equals("Kong") || destinationName.equals("Monster Zero") || destinationName.equals("Godzilla")) {
                Monster monster = graph.listMonster.findMonster(destinationName);
                Player player = listPlayer.findPlayer(currentLocation);
                Fight fight = new Fight();
                fight.option(player, monster);
            }

            int distance = graph.getDistanceBetween(currentLocation, destinationName);
            if (distance == -1) {
                System.out.println("Invalid movement. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                continue;
            }

            totalDistance += distance;
            previousLocation = currentLocation;
            currentLocation = destinationName;

            // Update player location
            Player currentPlayer = listPlayer.head;
            if (currentPlayer != null) {
                currentPlayer.location = destinationName;
            }

            travelLog.addLog(currentLocation, distance, previousLocation);

            // Display Total Perjalanan
            System.out.println("\nMovement Summary:");
            System.out.println("From: " + previousLocation);
            System.out.println("To: " + currentLocation);
            System.out.println("Distance: " + distance);
            System.out.println("\nTravel History:");
            travelLog.printPreviousLocation();

            if (currentLocation.equals("Exit")) {
                cls();
                banner();
                System.out.println("\n=== CONGRATULATIONS! You've reached the Exit ===");

                //map position
                System.out.println("\nFinal Map Position:");
                listPlayer.displayMap();

                // Print travel history
                System.out.println("\n=== Travel History ===");
                travelLog.printLog();
                System.out.println("\nTotal Distance Traveled: " + totalDistance);

                System.out.println("\nPress Enter to return to main menu...");
                scanner.nextLine();
                break;
            }
        }
    }

=======
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
}
