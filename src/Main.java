import souvik.graph.Edge;
import souvik.graph.WeightedGraphAL;
import souvik.mst.PrimMST;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        var begin = System.currentTimeMillis();
//        System.out.print("> How many vertex will be inside graph : ");
//        Scanner scanner = new Scanner(System.in);
//        int V = scanner.nextInt();
        int V = 1_000_000;
//        GraphAL graph = new GraphAL(v);
        WeightedGraphAL graph = new WeightedGraphAL(V);
        Random random = new Random();
        for (int i = 0; i < V / 2; i++) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);
//            graph.addEdge(v, w);
            graph.addEdge(new Edge(v, w, random.nextDouble()));
        }
//        System.out.print("> What is the arbitrary source : ");
//        int s = scanner.nextInt();
//        scanner.close();
//        DepthFirstSearch dfs = new DepthFirstSearch(graph, s);
//        for (int i : dfs.traversal()) {
//            System.out.print(i + " -> ");
//        }
//        System.out.println("Fin");
//        KruskalMST t = new KruskalMST(graph);
        PrimMST t = new PrimMST(graph);
        for (Edge e : t.mst()) {
            int v = e.either();
            int w = e.other(v);
            System.out.println(v + " - " + w);
        }
        var end = System.currentTimeMillis();
        System.out.println("Time = " + (end - begin) + " ms");
    }
}