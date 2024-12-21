public class ListPlayer {

    Player head;
    Player tail;

    public void addPlayer(int turn, String name, int atk, int defense, int health, String role, String location) {
        Player newPlayer = new Player(turn, name, atk, defense, health, role, location);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
        } else {
            tail.next = newPlayer;
            tail = newPlayer;
        }
    }

    public void deletePlayer(String name) {
        if(head == null) {
            return;
        }else {
            Player current = head;
            while (current != null) {
                if(current.name.equals(name)) break;
                current = current.next;
            }
            if(current == head) head = null;
        }
    }

    public void displayPlayer() {
        System.out.println("\n----- Player -----");
        Player current = head;
        while (current != null) {
            System.out.println("Turn: " + current.turn);
            System.out.println("Name: " + current.name);
            System.out.println("Attack: " + current.atk);
            System.out.println("Defense: " + current.def);
            System.out.println("Health: " + current.HP);
            System.out.println("Role: " + current.role);
            System.out.println("Location: " + current.location);
            current = current.next;
        }
    }

    public void displayMap() {
    String mapTemplate
            = "                                 %s\n"
            + "                 %s            /  |\n"
            + "                   \\           /   |\n"
            + "                    \\         /    |\n"
            + "                     \\______%s    |\n"
            + "                      \\            |\n"
            + "                       \\           |\n"
            + "                        %s-------%s--------%s\n"
            + "                        /|          \\\n"
            + "                       / |           \\\n"
            + "                      /  |            \\\n"
            + "                     /   |             \\\n"
            + "                   %s   |              \\\n"
            + "                    \\    |               \\\n"
            + "                     \\   |                \\\n"
            + "                      \\  |                 \\\n"
            + "                       \\ |                  \\\n"
            + "                        \\|                   \\\n"
            + "                        %s------------------%s\n"
            + "                          \\\n"
            + "                           \\\n"
            + "                            \\\n"
            + "                             \\\n"
            + "                              %s";

    String loc0 = "(0)", loc1 = "(1)", loc2 = "(2)", loc3 = "(3)",
            loc4 = "(4)", loc5 = "(5)", loc6 = "(6)", loc7 = "(7)",
            loc8 = "(8)", loc9 = "(9)";

    Player current = head;
    if (current != null) {
        switch (current.location) {
            case "Entry":
                loc0 = "(#)";
                break;
            case "Ruins Hill":
                loc1 = "(#)";
                break;
            case "Labyrinth Tower":
                loc2 = "(#)";
                break;
            case "Dora Mountain":
                loc3 = "(#)";
                break;
            case "Forest":
                loc4 = "(#)";
                break;
            case "Hollow Earth":
                loc5 = "(#)";
                break;
            case "The Eternal Relic":
                loc6 = "(#)";
                break;
            case "Monster Island":
                loc7 = "(#)";
                break;
            case "Safety Room":
                loc8 = "(#)";
                break;
            case "Village":
                loc9 = "(#)";
                break;
        }
    }

    int consoleWidth = 80; 
    int mapWidth = 63;     
    int padding = (consoleWidth - mapWidth) / 2;

    String pad = " ".repeat(padding);

    System.out.println(pad + "##" + "=".repeat(mapWidth) + "##");
    System.out.println(pad + "||" 
        + " ".repeat((mapWidth - current.location.length()) / 2)
        + current.location 
        + " ".repeat((mapWidth - current.location.length()) / 2) 
        + "||");
    System.out.println(pad + "##" + "=".repeat(mapWidth) + "##");
    String[] mapLines = String.format(mapTemplate,
            loc2, loc6, loc0, loc3, loc5, loc9,
            loc4, loc1, loc8, loc7).split("\n");
    for (String line : mapLines) {
        System.out.println(pad + line);
    }
    System.out.println("\n");
}


    public void updateLocation(String name) {
        Player current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                current.location = name;
                break;
            }
            current = current.next;
        }
    }

    public Player findPlayer(String name) {
        Player current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}