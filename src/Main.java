import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var begin = System.currentTimeMillis();
        int V = 1000;
        Random random = new Random();

        // Adjacency List DFS
//        GraphAL graph = new GraphAL(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(random.nextInt(V), random.nextInt(V));
//        }
//        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
//        System.out.print("Source -> ");
//        for (int v : dfs.traversal()) {
//            System.out.print(v + " -> ");
//        }
//        System.out.println("Finish");

        // Adjacency List BFS
//        GraphAL graph = new GraphAL(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(random.nextInt(V), random.nextInt(V));
//        }
//        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
//        System.out.print("Source -> ");
//        for (int v : bfs.traversal()) {
//            System.out.print(v + " -> ");
//        }
//        System.out.println("Finish");

        // Adjacency Matrix DFS
//        GraphAM graph = new GraphAM(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(random.nextInt(V), random.nextInt(V));
//        }
//        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
//        System.out.print("Source -> ");
//        for (int v : dfs.traversal()) {
//            System.out.print(v + " -> ");
//        }
//        System.out.println("Finish");

        // Adjacency Matrix BFS
//        GraphAM graph = new GraphAM(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(random.nextInt(V), random.nextInt(V));
//        }
//        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
//        System.out.print("Source -> ");
//        for (int v : bfs.traversal()) {
//            System.out.print(v + " -> ");
//        }
//        System.out.println("Finish");

        // Kruskal MST on Adjacency List Graph
//        WeightedGraphAL graph = new WeightedGraphAL(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        KruskalMST tree = new KruskalMST(graph);
//        for (Edge e : tree.mst()) {
//            int v = e.either();
//            int w = e.other(v);
//            System.out.println(v + " - " + w);
//        }
//        System.out.println("Weight of MST is " + tree.getWeight());

        // Prim MST on Adjacency List Graph
//        WeightedGraphAL graph = new WeightedGraphAL(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        PrimMST tree = new PrimMST(graph);
//        for (Edge e : tree.mst()) {
//            int v = e.either();
//            int w = e.other(v);
//            System.out.println(v + " - " + w);
//        }
//        System.out.println("Weight of MST is " + tree.getWeight());

        // Kruskal MST on Adjacency Matrix Graph
//        WeightedGraphAM graph = new WeightedGraphAM(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        KruskalMST tree = new KruskalMST(graph);
//        for (Edge e : tree.mst()) {
//            int v = e.either();
//            int w = e.other(v);
//            System.out.println(v + " - " + w);
//        }
//        System.out.println("Weight of MST is " + tree.getWeight());

        // Prim MST on Adjacency Matrix Graph
//        WeightedGraphAM graph = new WeightedGraphAM(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        PrimMST tree = new PrimMST(graph);
//        for (Edge e : tree.mst()) {
//            int v = e.either();
//            int w = e.other(v);
//            System.out.println(v + " - " + w);
//        }
//        System.out.println("Weight of MST is " + tree.getWeight());

        var end = System.currentTimeMillis();
        System.out.println("Time = " + (end - begin) + " ms");
    }
}