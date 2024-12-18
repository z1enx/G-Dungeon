public class Player {
    int turn;
    String name;
    int attack;
    int defense;
    int health;
    String role;                                                                                                          
    Player next;

    public Player(int turn, String name, int attack, int defense, int health, String role) {
        this.turn = turn;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.role = role;
        this.next = null;
    }
}
