public class Vertex {
    int id;
    String name;
    Edge adjacencyList;
    Vertex next;
    
    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        this.adjacencyList = null;
        this.next = null;
    }
    
    public void addEdge(int destination, int weight) {
        Edge newEdge = new Edge(destination, weight);
        if (adjacencyList == null) {
            adjacencyList = newEdge;
        } else {
            Edge temp = adjacencyList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newEdge;
        }
    }
}