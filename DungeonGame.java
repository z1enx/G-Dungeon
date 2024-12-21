import java.util.Scanner;


public class DungeonGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        ListMonster listMonster = new ListMonster();
        ListPlayer listPlayer = new ListPlayer();
        DungeonGame dungeonGame = new DungeonGame();
        

        // Menambahkan vertex dan edges seperti sebelumnya
        graph.addVertex(0, "Entry");
        graph.addVertex(1, "Ruins Hill");
        graph.addVertex(2, "Labyrinth Tower");
        graph.addVertex(3, "Dora Mountain");
        graph.addVertex(4, "Forest");
        graph.addVertex(5, "Hollow Earth");
        graph.addVertex(6, "The Eternal Relic");
        graph.addVertex(7, "Monster Island");
        graph.addVertex(8, "Safety Room");
        graph.addVertex(9, "Village");

        graph.addEdge(0, 6, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 4, 2);
        graph.addEdge(1, 7, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 8, 9);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 6, 3);
        graph.addEdge(3, 5, 9);
        graph.addEdge(5, 9, 2);
        graph.addEdge(5, 8, 10);
        graph.addEdge(2, 5, 6);

        dungeonGame.mainMenu(listPlayer, graph, listMonster, scanner);
    }

    public void mainMenu(ListPlayer listPlayer, Graph graph, ListMonster listMonster, Scanner scanner) {
        int choice = 1;
        while (true) {
            cls();
            banner();
            System.out.println("\n=== Dungeon Menu ===");
            System.out.println("1. Play");
            System.out.println("2. Role");
            System.out.println("3. About");
            System.out.println("4. Exit");
            System.out.println("Use 'W' for Up, 'S' for Down, and Enter to Select.");

            switch (choice) {
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
            }

            String input = scanner.nextLine().toUpperCase();

            if (input.equalsIgnoreCase("W") && choice > 1) {
                choice--;
            } else if (input.equalsIgnoreCase("S") && choice < 4) {
                choice++;
            } else if (input.equals("")) {
                switch (choice) {
                    case 1:
                        playMenu(scanner, listPlayer, graph, listMonster);
                        break;
                    case 2:
                        roleMenu(scanner);
                        break;
                    case 3:
                        aboutMenu(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the game. Goodbye!");
                        return;
                }
            } else {
                System.out.println("Invalid input. Please use 'W' for up, 'S' for down, or press Enter to select.");
            }
        }
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

    public static void aboutMenu(Scanner scanner) {
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

    public static void playMenu(Scanner scanner, ListPlayer listPlayer, Graph graph, ListMonster listMonster) {
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
                    attack = 100;
                    defense = 75;
                    health = 1500;
                } else { // Fighter
                    attack = 200;
                    defense = 200;
                    health = 3000;
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
        
        System.out.println();
        System.err.println("Starting the game...");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        
        DungeonGame game = new DungeonGame();
        game.startGame(graph, listPlayer, listMonster, listPlayer.head);
    }

    public void startGame(Graph graph, ListPlayer listPlayer, ListMonster listMonster, Player player) {
        Scanner scanner = new Scanner(System.in);
        String currentLocation = "Entry";
        String previousLocation = "None";
        TravelLog travelLog = new TravelLog();
        LinkedList list = new LinkedList();
        travelLog.addLog(currentLocation, 0, previousLocation);
        int totalDistance = 0;
        int winPuzzle1 = 0, winBoxStack = 0, QuestCount = 0, dialogCount = 0;

        while (true) {
            cls();
            listPlayer.displayMap();

            graph.displayCurrentLocation(currentLocation);

            System.out.println();
            System.out.println("Travel History:");
            travelLog.printPreviousLocation();

            System.out.println();
            System.out.println("\nAvailable Locations:");
            graph.displayAdjacentLocations(currentLocation);

            // System.out.println("If you are mage, you can type 'View Map' to view the shortest path");
            if(player.role.equalsIgnoreCase("Mage")){
                System.out.println("- Map Vision, Type (100)");
            }
            System.out.print("\nChoose location to visit: ");
            int destinationName = scanner.nextInt();
            cls();

            if(destinationName == 100){
                MageSkill specialSkill = new MageSkill();
                specialSkill.findPath(graph, graph.returnID(currentLocation));
                graph.resetGraph();
            }
            int distance = graph.getDistanceBetween(currentLocation, graph.findById(destinationName));
            if (distance == -1) {
                System.out.println("Invalid movement. Please try again.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                continue;
            }
            
            totalDistance += distance;
            previousLocation = currentLocation;
            currentLocation = graph.findById(destinationName);

            // Update player location
            Player currentPlayer = listPlayer.head;
            if (currentPlayer != null) {
                currentPlayer.location = graph.findById(destinationName);
            }

            Vertex currentVertex = graph.findVertexByName(currentLocation);

            if(currentLocation.equalsIgnoreCase("Hollow Earth") || currentLocation.equalsIgnoreCase("Dora Mountain") || currentLocation.equalsIgnoreCase("Monster Island")) {
                boolean reset = false;
                String monster = "No Monster";
                if(currentLocation.equalsIgnoreCase("Hollow Earth")) monster = "Kong";
                if(currentLocation.equalsIgnoreCase("Dora Mountain")) monster = "Monster Zero";
                if(currentLocation.equalsIgnoreCase("Monster Island")) monster = "Godzilla";
                reset = listMonster.battle(player, monster, graph, currentVertex.id, list);
                if(reset) {
                    listPlayer.deletePlayer(player.name);
                    ListMonster newListMonster = new ListMonster();
                    mainMenu(listPlayer, graph, newListMonster, scanner);
                }
            }

            if(currentLocation.equalsIgnoreCase("Labyrinth Tower")) {
                if (winPuzzle1 == 0 ){
                    Puzzle puzzle = new Puzzle();
                    puzzle.play();
                    list.addItem("Fire Ball", 1000);
                    square("FIREBALL GIVE 1000 DAMAGE");
                    winPuzzle1 +=1;
                }
                
            }
            
            if(currentLocation.equalsIgnoreCase("The Eternal Relic")) {
                if(winBoxStack == 0) {
                    puzzle2 boxStack = new puzzle2();
                    boxStack.playGame();
                    player.HP += 1000;
                    square("HP INCREASE 1000");
                }
            }

            if(currentLocation.equalsIgnoreCase("Village")) {
                if(QuestCount == 0) {
                    Quest quest = new Quest();
                    quest.playQuest();
                    list.addItem("Used Broom", 999999);
                    square("USED BROOM MYSTERIOUS ITEM");
                    QuestCount += 1;
                }
            }

            if(currentLocation.equalsIgnoreCase("Forest")) {
                if(dialogCount == 0){
                    DialogForest dialogoue = new DialogForest();
                    dialogoue.startDialogue(list);
                    dialogCount += 1;
                }
            }

            travelLog.addLog(currentLocation, distance, previousLocation);

            if(currentLocation.equalsIgnoreCase("Safety Room")){
                player.HP += 100;
            }
        }
    }
    public void square(String text) {
        int length1 = (31 - text.length())/2;
        int length2;
        if(text.length() % 2 == 1) length2 = length1;
        else length2 = length1 + 1;
        System.out.println("##" + "=".repeat(31) +  "##");
        System.out.println("||" +" ".repeat(length1) + text + " ".repeat(length2) + "||" );
        System.out.println("##" + "=".repeat(31) +  "##");
        Scanner pemindai = new Scanner(System.in);
        System.out.println("Press Enter to continue...");
        pemindai.nextLine();
    }
}