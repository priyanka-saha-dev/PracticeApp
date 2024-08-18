import java.util.*;

public class DjkstraAlgo {
    private final int vertices;
    private final List<List<Node>> adjList;

    // Constructor
    public DjkstraAlgo(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            List<Node> item = new ArrayList<>();
            adjList.add(item);
        }
    }

    // Add edge
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight));  // If the graph is undirected
    }

    // Dijkstra's algorithm
    public void dijkstra(int src) {
        // Priority Queue to store (distance, vertex) pairs
        PriorityQueue<Node> pq = new PriorityQueue<>(vertices, new Node());

        // Distances array to store the shortest distance from src to each vertex
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            // Extract the node with the minimum distance
            int u = pq.poll().node;

            // Visit each adjacent node
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;

                // Check if a shorter path is found
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        // Print shortest distances from src
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    // Node class to represent a node in the graph
    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {}

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }

    // Main method
    public static void main(String[] args) {
        int vertices = 6;
        DjkstraAlgo graph = new DjkstraAlgo(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        graph.dijkstra(0);
    }
}
