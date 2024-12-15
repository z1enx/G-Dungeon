class Monster {
    String name;
    String model;
    int atk;
    int def;
    int HP;
    int index;
    Monster next;

    Monster(String name, String model, int atk, int def, int HP) {
        this.name = name;
        this.model = model;
        this.atk = atk;
        this.def = def;
        this.index = 0;
        this.next = null;
    }
}