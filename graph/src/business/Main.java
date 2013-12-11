package business;

import business.generate.GraphGenerator;
import business.text.GraphLoader;
import business.text.TextFileFormatException;
import data.Graph;

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
                System.out.println("vista de grafos cargados de archivo");
                System.out.println(adjacencyList[0].toString());
                System.out.println(adjacencyList[1].toString());
                System.out.println(adjacencyList[2].toString());
                /*
                System.out.println(adjacencyMatrix[0].toString());
                System.out.println(adjacencyMatrix[1].toString());
                System.out.println(adjacencyMatrix[2].toString());
                 */

                //
                System.out.println("uso de floyd warshall, densidad");
                final int distance = Algorithm.FloydWarshallAlgorithm(
                                adjacencyList[1], 0, 2);
                System.out.println("distancia del segundo grafo de 0 a 2: " + distance);
                final int distance2 = Algorithm.FloydWarshallAlgorithm(
                                adjacencyList[1], 0, 0);
                System.out.println("distancia del segundo grafo de 0 a 0: " + distance2);
                final double density = Algorithm
                                .getGraphDensity(adjacencyList[1]);
                System.out.println("densidad del segundo grafo: " + density);
                final double density2 = Algorithm
                                .getGraphDensity(adjacencyList[2]);
                System.out.println("densidad del tercer grafo: " + density2);
                
                //
                System.out.println("vista de grafos generados simples, 10 nodos, 20 aristas");
                Graph generatedSimpleGraph = GraphGenerator.simpleGraph(Graph.GRAPH_TYPE.ADJACENCY_LIST, 10, 20);
                System.out.println(generatedSimpleGraph.toString());
                Graph generatedWeightedSimpleGraph = GraphGenerator.weightedSimpleGraph(Graph.GRAPH_TYPE.ADJACENCY_LIST, 10, 20);
                System.out.println(generatedWeightedSimpleGraph.toString());
                
                //
                System.out.println("grafos creados a partir de entrada de texto");
                Graph[] textInputGraphs = business.text.TextInput.parseInput();
                for(int i = 0; i < textInputGraphs.length; i++) {
                        System.out.println(textInputGraphs[i].toString());
                }
        }

}
