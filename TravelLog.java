// Kelas untuk menyimpan riwayat perjalanan menggunakan LinkedList
class TravelLog {
    private Node head;
    
    public TravelLog() {
        head = null;
    }
    
    // Menambahkan log perjalanan ke LinkedList
    public void addLog(String location, int distance, String previousLocation) {
        Node newNode = new Node(location, distance, previousLocation);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    // Mencetak seluruh riwayat perjalanan
    public void printLog() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.location);
            if (temp.next != null) {
                System.out.print(" (Jarak: " + temp.distance + ")");
            }
            System.out.println();
            temp = temp.next;
        }
    }
    
    // Menampilkan lokasi sebelumnya
    public void printPreviousLocation() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.location + " | ");
            temp = temp.next;
        }
    }
}

// Kelas untuk menyimpan data lokasi, jarak, dan lokasi sebelumnya dalam LinkedList
class Node {
    String location;
    int distance;
    String previousLocation;
    Node next;
    
    public Node(String location, int distance, String previousLocation) {
        this.location = location;
        this.distance = distance;
        this.previousLocation = previousLocation;
        this.next = null;
    }
}
