<<<<<<< HEAD

public class Graph {
    Vertex head;
    ListMonster listMonster = new ListMonster();
    Fight fight = new Fight();

    public void addVertex(int id, String name) {
        Vertex newVertex = new Vertex(id, name);
        if (head == null) {
            head = newVertex;
        } else {
            Vertex temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVertex;
        }
    }

    public Vertex findVertex(int id) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Vertex findVertexByName(String name) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addEdge(int source, int destination, int weight) {
        Vertex sourceVertex = findVertex(source);
        Vertex destinationVertex = findVertex(destination);
        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addEdge(destination, weight);
            destinationVertex.addEdge(source, weight);
        }
    }

    public void displayAdjacentLocations(String currentLocation) {
        Vertex currentVertex = findVertexByName(currentLocation);
        if (currentVertex == null) {
            System.out.println("Lokasi tidak ditemukan.");
            return;
        }

        Edge edge = currentVertex.adjacencyList;
        while (edge != null) {
            Vertex neighbor = findVertex(edge.destination);
            if (neighbor != null) {
                System.out.println("- " + neighbor.name + " (Jarak: " + edge.weight + ")");
            }
            edge = edge.next;
        }
    }

    public int getDistanceBetween(String currentLocation, String destinationName) {
        Vertex currentVertex = findVertexByName(currentLocation);
        if (currentVertex == null) {
            return -1;
        }

        Edge edge = currentVertex.adjacencyList;
        while (edge != null) {
            Vertex neighbor = findVertex(edge.destination);
            if (neighbor != null && neighbor.name.equals(destinationName)) {
                return edge.weight;
            }
            edge = edge.next;
        }

        return -1;
    }

    // Method to display the current location
    public void displayCurrentLocation(String currentLocation) {
        System.out.println("\nLokasi Saat Ini: " + currentLocation);
    }

    public boolean isValidDestination(String currentLocation, String destination) {
        Vertex currentVertex = findVertexByName(currentLocation);
        if (currentVertex == null) {
            return false;
        }

        Edge edge = currentVertex.adjacencyList;
        while (edge != null) {
            Vertex neighbor = findVertex(edge.destination);
            if (neighbor != null && neighbor.name.equals(destination)) {
                return true;
            }
            edge = edge.next;
        }

        return false;
    }
}
=======
import java.util.Scanner;

public class Graph {
    Vertex head;
    
    public void addVertex(int id, String name) {
        Vertex newVertex = new Vertex(id, name);
        if (head == null) {
            head = newVertex;
        } else {
            Vertex temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVertex;
        }
    }
    
    public Vertex findVertex(int id) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public Vertex findVertexByName(String name) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public void addEdge(int source, int destination, int weight) {
        Vertex sourceVertex = findVertex(source);
        Vertex destinationVertex = findVertex(destination);
        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addEdge(destination, weight);
            destinationVertex.addEdge(source, weight);
        }
    }
    
    public void displayAdjacentLocations(String currentLocation) {
        Vertex currentVertex = findVertexByName(currentLocation);
        if (currentVertex == null) {
            System.out.println("Lokasi tidak ditemukan.");
            return;
        }
        
        Edge edge = currentVertex.adjacencyList;
        while (edge != null) {
            Vertex neighbor = findVertex(edge.destination);
            if (neighbor != null) {
                System.out.println("- " + neighbor.name + " (Jarak: " + edge.weight + ")");
            }
            edge = edge.next;
        }
    }
    
    public int getDistanceBetween(String currentLocation, String destinationName) {
        Vertex currentVertex = findVertexByName(currentLocation);
        if (currentVertex == null) {
            return -1;
        }
        
        Edge edge = currentVertex.adjacencyList;
        while (edge != null) {
            Vertex neighbor = findVertex(edge.destination);
            if (neighbor != null && neighbor.name.equals(destinationName)) {
                return edge.weight;
            }
            edge = edge.next;
        }
        
        return -1;
    }

    public void startGame(Graph graph) {
        Scanner scanner = new Scanner(System.in);
        String currentLocation = "Entry";
        String previousLocation = "None"; // Lokasi sebelumnya
        
        // Menggunakan LinkedList untuk menyimpan riwayat perjalanan dan jarak
        TravelLog travelLog = new TravelLog();
        
        travelLog.addLog(currentLocation, 0, previousLocation); // Menambahkan lokasi awal
        
        int totalDistance = 0;
        
        while (true) {
            System.out.println("\nLokasi Saat Ini -> " + currentLocation);
            
            // Menampilkan lokasi yang dapat dikunjungi
            System.out.println("Lokasi yang dapat dikunjungi:");
            graph.displayAdjacentLocations(currentLocation);
            
            // Input lokasi tujuan
            System.out.print("\nPilih lokasi yang ingin Anda kunjungi: ");
            String destinationName = scanner.nextLine();
            
            // Validasi lokasi
            int distance = graph.getDistanceBetween(currentLocation, destinationName);
            if (distance == -1) {
                System.out.println("Perpindahan tidak valid. Coba lagi.");
                continue;
            }
            
            // Update jarak
            totalDistance += distance;
            
            // Update lokasi saat ini dan sebelumnya
            previousLocation = currentLocation;
            currentLocation = destinationName;
            
            // Catat perjalanan
            travelLog.addLog(currentLocation, distance, previousLocation);
            // Menampilkan lokasi sebelumnya di setiap langkah
            System.out.print("History: ");
            travelLog.printPreviousLocation();
            System.out.println();

            
            // Cek apakah sudah mencapai Exit
            if (currentLocation.equals("Exit")) {
                System.out.println("\n=== SELAMAT! Anda berhasil mencapai Exit ===");
                
                // Cetak riwayat perjalanan
                System.out.println("\n--- Riwayat Perjalanan ---");
                travelLog.printLog();                              
                System.out.println("\nTotal Jarak Tempuh: " + totalDistance);
                break;
            }
        }
        
        scanner.close();
    }
}
>>>>>>> b145e92e2ec8fb2cb9ccce7e33a605a6ca711b5c
