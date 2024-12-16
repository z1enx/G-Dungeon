
public class DungeonGame {
    public static void main(String[] args) {
        Graph graph = new Graph();
        
        // Menambahkan vertex dengan nama
        graph.addVertex(0, "Entry");
        graph.addVertex(1, "Treasure");
        graph.addVertex(2, "Kroco");
        graph.addVertex(3, "Monster Zero");
        graph.addVertex(4, "Buff");
        graph.addVertex(5, "Kong");
        graph.addVertex(6, "Treasure");
        graph.addVertex(7, "Godzilla");
        graph.addVertex(8, "Exit");
        
        // Menambahkan edge sesuai dengan peta dungeon
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 6, 3);
        graph.addEdge(1, 7, 5);
        graph.addEdge(2, 5, 6);
        graph.addEdge(7, 8, 4);
        graph.addEdge(5, 8, 2);
        
        // Memulai permainan
        graph.startGame(graph);
    }
    
    
}
