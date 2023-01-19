import souvik.graph.DepthFirstSearch;
import souvik.graph.GraphAL;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("> How many vertex will be inside graph : ");
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        GraphAL graph = new GraphAL(v);
        Random random = new Random();
        for (int i = 0; i < v/2; i++) {
            graph.addEdge(random.nextInt(v), random.nextInt(v));
        }
        System.out.print("> What is the arbitrary source : ");
        int s = scanner.nextInt();
        scanner.close();
        DepthFirstSearch dfs = new DepthFirstSearch(graph, s);
        for (int i : dfs.traversal()) {
            System.out.print(i + " -> ");
        }
        System.out.print("Fin");
    }
}