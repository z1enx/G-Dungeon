public class Item {
    String namaItem;
    int value;
    Item next;

    public Item(String namaItem, int value) {
        this.namaItem = namaItem;
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Item head;

    public int findItem(String namaItem) {
    Item temp = head;

    while (temp != null) {
        if (temp.namaItem.equals(namaItem)) {
            return temp.value;  
        }
        temp = temp.next;
    }
    return 0;
}

    public void addItem(String nama, int value) {
        if (head == null) {
            head = new Item(nama, value);
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Item(nama, value);
        }
    }

    public void displayItem() {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }

        Item temp = head;
        int index = 1;
        System.out.println("List Item:");
        while (temp != null) {
            System.out.println(index + ". " + temp.namaItem + " (Damage: " + temp.value + ")");
            temp = temp.next;
            index++;
        }
    }

    public void delete(String namaItem) {
        if (head == null) {
            System.out.println("Empty List! Nothing to delete");
            return;
        }

        if (head.namaItem.equals(namaItem)) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && !temp.next.namaItem.equals(namaItem)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("The item with name \"" + namaItem + "\" not found!");
        } else {
            temp.next = temp.next.next;
        }
    }

}