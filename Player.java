public class Player {
    int turn;
    String name;
    int attack;
    int defense;
    int health;
    String role;                                                                                                          
    Player next;
    String location;

    public Player(int turn, String name, int attack, int defense, int health, String role, String location) {
        this.turn = turn;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.role = role;
        this.location = location;
        this.next = null;
    }
}
