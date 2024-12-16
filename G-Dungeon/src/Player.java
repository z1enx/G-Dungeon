
public class Player {

    int turn;
    String name;
    double attack;
    double defense;
    double health;
    double mana;
    String role;                                                                                                          
    Player next;

    public Player(int turn,String name, double attack, double defense, double health, double mana, String role) {
        this.turn = turn;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.mana = mana;
        this.role = role;
        this.next = null;
    }
}
