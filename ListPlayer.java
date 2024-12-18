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
}
