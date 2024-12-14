public class ListMonster {
    Monster head;

    ListMonster() {
        this.head = null;
    }

    void addMonster(String nama, String model, int atk, int def , int HP) {
        if(head == null) {
            head = new Monster(nama, model, atk, def, HP);
        }else {
            Monster temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Monster(nama, model, atk, def, HP);
        }
    }

    void displayMonster(String nama) {
        Monster temp = head;
        while(temp != null) {
            if(temp.name.equals(nama)) break;
            else temp = temp.next;
        }
        System.out.println(temp.model);
    }

    void displayListMonster() {
        Monster temp = head;
        while(temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    void deleteMonster(String nama) {
        if(head.name.equals(nama)) {
            head = head.next;
        }else {
            Monster temp = head;
            Monster tempPrev = head;
            while(temp != null) {
                if(temp.name.equals(nama)) break;
                else {
                    tempPrev = temp;
                    temp = temp.next;
                }
            }
            if(temp == null) {
                System.out.println("Monster tidak ditemukan");
            }else {
                tempPrev.next = temp.next;
            }
        }
    }

}
