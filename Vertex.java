public class Vertex {
    String name;
    Edge firstEdge;
    Vertex next;
    int distance;
    Vertex previous;
    boolean visited;
    boolean isTeleport;

    public Vertex(String name) {
        this.name = name;
        this.firstEdge = null;
        this.next = null;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
        this.visited = false;
        this.isTeleport = false;
    }

    public void addEdge(Vertex neighbor, int weight) {
        Edge newEdge = new Edge(this, neighbor, weight);
        newEdge.next = firstEdge;
        firstEdge = newEdge;
    }
}
