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
        graph.addEdge("A", "E", 4);
        graph.addEdge("A", "F",3);

        graph.addEdge("B", "C",1);
        graph.addEdge("B", "D", 2);

        graph.addEdge("C", "E",8);
        graph.addEdge("C", "F",8);

        graph.addEdge("D", "B",2);

        System.out.println(graph);
        System.out.println();

        graph.dfs("A", System.out::print);
        System.out.println();
        graph.bfs("A", System.out::print);

    }


}
