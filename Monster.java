class Monster {
    String name;
    String model;
    int atk;
    int def;
    int HP;
    int turn;
    boolean live;
    Monster next;

    Monster(String name, String model, int atk, int def, int HP) {
        this.name = name;
        this.model = model;
        this.atk = atk;
        this.def = def;
        this.HP = HP;
        this.turn = 0;
        this.next = null;
        this.live = true;
    }
}