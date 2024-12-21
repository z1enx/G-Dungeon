import java.util.Scanner;

public class MageSkill {

    public void findPath(Graph graph, int startId) {
        Vertex startNode = graph.findVertex(startId);
        if (startNode == null) {
            return;
        }
        startNode.distance = 0;

        while (true) {
            Vertex closestNode = closestNode(graph);
            if (closestNode == null) break;

            closestNode.visited = true;

            Edge edge = closestNode.adjacencyList;
            while (edge != null) {
                Vertex neighbor = graph.findVertex(edge.destination);
                if (neighbor != null && !neighbor.visited) {
                    int newDistance = closestNode.distance + edge.weight;

                    if (newDistance < neighbor.distance) {
                        neighbor.distance = newDistance;
                        neighbor.prev = closestNode;
                    }
                }
                edge = edge.next;
            }
        }

        displayPaths(graph, startNode);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private Vertex closestNode(Graph graph) {
        Vertex closestNode = null;
        int minDistance = Integer.MAX_VALUE;

        Vertex currentNode = graph.head;
        while (currentNode != null) {
            if (!currentNode.visited && currentNode.distance < minDistance) {
                minDistance = currentNode.distance;
                closestNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return closestNode;
    }

    private void displayPaths(Graph graph, Vertex startNode) {
        Vertex[] vertices = toArray(graph); // Ubah linked list ke array untuk mempermudah pengurutan
        sortVerticesByDistance(vertices); // Urutkan berdasarkan jarak

        for (Vertex vertex : vertices) {
            if (vertex.distance == Integer.MAX_VALUE) {
                System.out.println(startNode.name + " => " + vertex.name + " Unreachable");
            } else {
                displayPath(startNode, vertex);
                System.out.println(" (Distance: " + vertex.distance + ")");
            }
        }
    }

    // Fungsi untuk mengubah linked list ke array
    private Vertex[] toArray(Graph graph) {
        int count = 0;
        Vertex current = graph.head;

        while (current != null) {
            count++;
            current = current.next;
        }

        Vertex[] vertices = new Vertex[count];
        current = graph.head;

        for (int i = 0; i < count; i++) {
            vertices[i] = current;
            current = current.next;
        }

        return vertices;
    }

    // Fungsi untuk mengurutkan array berdasarkan jarak
    private void sortVerticesByDistance(Vertex[] vertices) {
        int n = vertices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vertices[j].distance > vertices[j + 1].distance) {
                    Vertex temp = vertices[j];
                    vertices[j] = vertices[j + 1];
                    vertices[j + 1] = temp;
                }
            }
        }
    }

    private void displayPath(Vertex startNode, Vertex endNode) {
        if (endNode == null) {
            return;
        }
        if (endNode.prev != null) {
            displayPath(startNode, endNode.prev);
            System.out.print(" => ");
        }
        System.out.print(endNode.name);
    }
}
