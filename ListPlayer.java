public class ListPlayer {
    Player head;
    Player tail;

    public ListPlayer() {
        head = null;
        tail = null;
    }

    public void addPlayer(int turn, String name, int attack, int defense, int health, String role) {
        Player newPlayer = new Player(turn, name, attack, defense, health, role);
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
            System.out.println("Turn: " + current.turn + ", Name: " + current.name + ", Role: " + current.role + 
                               ", Attack: " + current.attack + ", Defense: " + current.defense + ", Health: " + current.health);
            current = current.next;
        }
    }

    public void displayMap(){
        System.out.println(
            "                                (2)\n" +
            "                 (6)            / |\n" +
            "                   \\          /    |\n" +
            "                    \\        /     |\n" +
            "                     \\______(0)    |\n" +
            "                      \\            |\n" +
            "                       \\           |\n" +
            "                        (3)-------(5)--------(9)\n" +
            "                        /|          \\\n" +
            "                       / |           \\\n" +
            "                      /  |            \\\n" +
            "                     /   |             \\\n" +
            "                   (4)   |              \\\n" +
            "                    \\    |               \\\n" +
            "                     \\   |                \\\n" +
            "                      \\  |                 \\\n" +
            "                       \\ |                  \\\n" +
            "                        \\|                   \\\n" +
            "                        (1)------------------(8)\n" +
            "                          \\\n" +
            "                           \\\n" +
            "                            \\\n" +
            "                             \\\n" +
            "                              (7)"
        );
    }
}
