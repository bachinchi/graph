package business;

import business.text.GraphLoader;
import business.text.TextFileFormatException;
import data.interfaces.Graph;

public class Main {

        public static void main(final String[] args) {
                Graph[] adjacencyList = null;
                Graph[] adjacencyMatrix = null;
                try {
                        adjacencyList = GraphLoader.getGraphs(
                                        "data/vertices.txt",
                                        Graph.GRAPH_TYPE.ADJACENCY_LIST);
                        adjacencyMatrix = GraphLoader.getGraphs(
                                        "data/vertices.txt",
                                        Graph.GRAPH_TYPE.ADJACENCY_MATRIX);
                } catch (final TextFileFormatException e) {
                        e.printStackTrace();
                }
                System.out.println(adjacencyList[0].toString());
                System.out.println(adjacencyList[1].toString());
                System.out.println(adjacencyList[2].toString());
                System.out.println(adjacencyMatrix[0].toString());
                System.out.println(adjacencyMatrix[1].toString());
                System.out.println(adjacencyMatrix[2].toString());

                /*
                 * ArrayList<int[]> test = GraphLoader.parseFile(GraphLoader
                 * .readFile("data/vertices.txt")); for (int i = 0; i <
                 * test.size(); i++) { int[] test2 = test.get(i); for (int j =
                 * 0; j < test2.length; j++) { System.out.print(test2[j] + " ");
                 * } System.out.println(); }
                 */
        }

}
