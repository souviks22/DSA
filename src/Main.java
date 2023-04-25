public class Main {
    public static void main(String[] args) {
        var begin = System.currentTimeMillis();

        // Suffix Operations
//        MyString myString = new MyString("souviksarkarsouvik20isark");
//        System.out.println(Suffix.longestRepeatedSubstring(myString));

        // Ternary Search Trie
//        TernarySearchTrie<Integer> tst = new TernarySearchTrie<>();
//        tst.put("souvik", 7);
//        System.out.println(tst.get("souvik"));
//        tst.delete("souvik");
//        System.out.println(tst.get("souvik"));

        // Trie
//        Trie<Integer> trie = new Trie<>();
//        trie.put("souvik", 7);
//        trie.put("sarkar", 10);
//        System.out.println(trie.get("souvik"));
//        for (String s : trie.keys()) System.out.println(s);
//        System.out.println(trie.longestKeyIn("souviksarkar"));
//        trie.delete("souvik");
//        System.out.println(trie.get("souvik"));

        // String Sort
//        MyString[] myStrings = {
//                new MyString("facebook"),
//                new MyString("adobe"),
//                new MyString("tcs"),
//                new MyString("google")
//        };
//        LSD.sort(myStrings);
//        MSD.sort(myStrings);
//        QuickMSD.sort(myStrings);
//        System.out.println(Arrays.toString(myStrings));


        // Key Indexed Counting
//        char[] arr = {'c','d','a','e','f','b'};
//        KeyIndexedCount.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        char[] sorted = KeyIndexedCount.sort("souvik");
//        System.out.println(Arrays.toString(sorted));

        // MyString
//        MyString myString = new MyString("Souvik Sarkar");
//        System.out.println(myString);
//        MyString sub = myString.substring(0, 6);
//        System.out.println(sub);
//        MyString con = sub.concat("007");
//        System.out.println(con);
//        MyString up = myString.uppercase();
//        System.out.println(up);
//        if (myString.compareTo(sub) > 0) System.out.println("MyString is bigger");
//        else System.out.println("Sub is bigger");

        // N Queens
//        NQueen nQueen = new NQueen(20);
//        nQueen.printBoard();

        // Matrix Chain Multiplication
//        int[] arr = new int[27];
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(1, 10);
//        }
//        System.out.println(Arrays.toString(arr));
//        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(arr);
//        System.out.println("Minimum number of element multiplications is " + matrixChainMultiplication.getMinMultiplications());
//        System.out.println("Required order of matrix multiplication is " + matrixChainMultiplication.getMultiplicationOrder());

//         Topological Sort
//        Digraph digraph = new Digraph(10);
//        for (int i = 1; i < 10; i++) {
//            digraph.addEdge(i - 1, i);
//        }
//        Topology topology = new Topology(digraph);
//        for (int i : topology.order()) {
//            System.out.println(i);
//        }

        // Weighted Job Scheduling
//        double[] p = {50, 20, 100, 200};
//        int[] s = {1, 3, 6, 2};
//        int[] e = {2, 5, 19, 100};
//
//        JobScheduling jobScheduling = new JobScheduling(p, s, e);
//        System.out.println("Maximum Profit is Rs." + jobScheduling.maxProfit() + "/-");

        // Graph
//        int V = 1000;
//        Random random = new Random();

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

        // Maximum Spanning Tree on Adjacency List Graph
//        WeightedGraphAL graph = new WeightedGraphAL(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        MaximumSpanningTree tree = new MaximumSpanningTree(graph);
//        for (Edge e : tree.mst()) {
//            int v = e.either();
//            int w = e.other(v);
//            System.out.println(v + " - " + w);
//        }
//        System.out.println("Weight of MST is " + tree.getWeight());

        // Maximum Spanning Tree on Adjacency Matrix Graph
//        WeightedGraphAM graph = new WeightedGraphAM(V);
//        for (int i = 0; i < V * 10; i++) {
//            graph.addEdge(new Edge(random.nextInt(V), random.nextInt(V), random.nextDouble()));
//        }
//        MaximumSpanningTree tree = new MaximumSpanningTree(graph);
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