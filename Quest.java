import java.util.Scanner;

public class Quest {
    // Kelas Node untuk item dalam conveyor
    static class Node {
        String item;
        Node next;

        // Konstruktor Node
        Node(String item) {
            this.item = item;
            this.next = null;
        }
    }

    // Kelas Conveyor yang mengelola conveyor sebagai linked list
    class Conveyor {
        Node front;
        Node back;

        public Conveyor() {
            front = null;
            back = null;
        }

        // Menambahkan item ke conveyor
        public void add(String item) {
            Node newNode = new Node(item);
            if (back == null) {
                front = newNode;
                back = newNode;
            } else {
                back.next = newNode;
                back = newNode;
            }
        }

        // Mengambil item terdepan (front)
        public String poll() {
            if (front == null) return null;
            String item = front.item;
            front = front.next;
            if (front == null) back = null;  // Jika conveyor kosong, back harus null juga
            return item;
        }

        // Melihat item terdepan (front)
        public String peek() {
            return front == null ? null : front.item;
        }

        // Menampilkan conveyor
        public void display() {
            Node current = front;
            while (current != null) {
                System.out.print(current.item + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void playQuest(){
        Scanner scanner = new Scanner(System.in);

        // Daftar item untuk permainan
        String[] items = {"Potion", "Sword", "Shield", "Bow", "Ring"};

        // Membuat conveyor
        Conveyor conveyor = new Conveyor();

        // Mengisi conveyor dengan item secara berulang
        for (int i = 0; i < 5; i++) {
            conveyor.add(items[i]);
        }

        int score = 0;
        System.out.println("** Conveyor Puzzle **");
        System.out.println("Pick up the correct item !");


        for (int turn = 0; turn < 5; turn++) {

            System.out.println("\nInstructions: Take " + items[turn]);
            System.out.print("Conveyor: ");
            conveyor.display();

            System.out.print("Choose Item: ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase(items[turn]) && conveyor.peek().equals(choice)) {
                System.out.println("Right! Item taken.");
                conveyor.poll();
                score += 10;
            } else {
                System.out.println("Wrong or misordered items!");
                conveyor.poll();
            }

            conveyor.add(items[(turn + 1) % items.length]);
        }

        System.out.println("\nGame over. Your score: " + score);
    }
}
