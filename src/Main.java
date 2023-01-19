import souvik.graphs.adjList.DepthFirstSearch;
import souvik.graphs.adjList.Graph;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 1);
        for (int i : dfs.traversal()) {
            System.out.print(i + " -> ");
        }
        System.out.print("Fin");
    }
}