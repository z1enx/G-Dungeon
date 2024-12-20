
public class ListPlayer {

    Player head;
    Player tail;

    public void addPlayer(int turn, String name, int attack, int defense, int health, String role, String location) {
        Player newPlayer = new Player(turn, name, attack, defense, health, role, location);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
        } else {
            tail.next = newPlayer;
            tail = newPlayer;
        }
    }

    public void displayPlayer() {
        System.out.println("\n----- Player -----");
        Player current = head;
        while (current != null) {
            System.out.println("Turn: " + current.turn);
            System.out.println("Name: " + current.name);
            System.out.println("Attack: " + current.attack);
            System.out.println("Defense: " + current.defense);
            System.out.println("Health: " + current.health);
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

        // Initialize location markers
        String loc0 = "(0)", loc1 = "(1)", loc2 = "(2)", loc3 = "(3)",
                loc4 = "(4)", loc5 = "(5)", loc6 = "(6)", loc7 = "(7)",
                loc8 = "(8)", loc9 = "(9)";

        // Update player location
        Player current = head;
        if (current != null) {
            switch (current.location) {
                case "Entry":
                    loc0 = "(#)";
                    break;
                case "Treasure1":
                    loc1 = "(#)";
                    break;
                case "Kroco":
                    loc2 = "(#)";
                    break;
                case "Monster Zero":
                    loc3 = "(#)";
                    break;
                case "Buff":
                    loc4 = "(#)";
                    break;
                case "Kong":
                    loc5 = "(#)";
                    break;
                case "Treasure2":
                    loc6 = "(#)";
                    break;
                case "Godzilla":
                    loc7 = "(#)";
                    break;
                case "Exit":
                    loc8 = "(#)";
                    break;
            }
        }

        System.out.println("\nMap:");
        System.out.printf(mapTemplate,
                loc2, loc6, loc0, loc3, loc5, loc9,
                loc4, loc1, loc8, loc7);
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
