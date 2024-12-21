public class Player {
    int turn;
    String name;
    int atk;
    int def;
    int HP;
    String role;                                                                                                          
    Player next;
    String location;

    public Player(int turn, String name, int atk, int def, int HP, String role, String location) {
        this.turn = turn;
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.HP = HP;
        this.role = role;
        this.location = location;
        this.next = null;
    }
}