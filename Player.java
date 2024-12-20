<<<<<<< HEAD
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
=======
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
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
