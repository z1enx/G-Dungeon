public class ListPlayer {

    Player head;
    Player tail;

    public ListPlayer() {
        head = null;
        tail = null;
    }

    public void addPlayer(int turn, String name, double attack, double defense, double health, double mana, String role) {
        Player newPlayer = new Player(turn, name, attack, defense, health, mana, role);
        if (head == null) {
            head = newPlayer;
            tail = newPlayer;
        } else {
            tail.next = newPlayer;
            tail = newPlayer;
        }
    }
}
