package lesson_7;

import java.util.function.Consumer;

public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new GraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.addEdge("A", "F");

        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        graph.addEdge("C", "E");
        graph.addEdge("C", "F");

        graph.addEdge("D", "B");

        System.out.println(graph);
        System.out.println();

        graph.dfs("A", System.out::print);
        System.out.println();
        graph.bfs("A", System.out::print);

    }


}
