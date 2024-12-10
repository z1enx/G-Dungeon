public class Edge {
    Vertex from;
    Vertex to;
    int weight;
    Edge next;

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.next = null;
    }
}
