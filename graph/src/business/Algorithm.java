package business;

import java.util.Map;

import data.Graph;

public class Algorithm {

        /**
         * Runs in O(|V|^2) time.
         * 
         * @param graph
         * @param source
         * @param target
         * @return
         */
        public int DijkstraAlgorithm(final Graph graph, final int source,
                        final int target) {
                return 1;
        }

        /**
         * http://algs4.cs.princeton.edu/44sp/FloydWarshall.java.html
         * 
         * @param graph
         * @param source
         * @param target
         * @return
         */
        public static int FloydWarshallAlgorithm(final Graph graph,
                        final int source, final int target) {
                final int vertexNumber = graph.getVerticesNumber();
                final double[][] dist = new double[vertexNumber][vertexNumber];

                for (int i = 0; i < vertexNumber; i++)
                        for (int j = 0; j < vertexNumber; j++)
                                dist[i][j] = Double.POSITIVE_INFINITY;

                for (int i = 0; i < vertexNumber; i++) {
                        for (int j = 0; j < vertexNumber; j++) {
                                if (graph.getEdgeWeight(i, j) != 0)
                                        dist[i][j] = graph.getEdgeWeight(i, j);
                        }
                }

                for (int i = 0; i < vertexNumber; i++) {
                        for (int j = 0; j < vertexNumber; j++) {
                                System.out.print(dist[j][i] + "\t");
                        }
                        System.out.println();
                }

                // Wikipedia
                for (int k = 0; k < vertexNumber; k++) {
                        for (int i = 0; i < vertexNumber; i++) {
                                for (int j = 0; j < vertexNumber; j++)
                                        if (dist[i][j] > dist[i][k]
                                                        + dist[k][j])
                                                dist[i][j] = dist[i][k]
                                                                + dist[k][j];
                        }
                }
                //return dist[target][source];
                return (int)dist[source][target];
        }

        public int getGraphConnectivity(final Graph graph, final int source,
                        final int target) {
                return 1;
        }

        public int KruskalAlgorithm(final Graph graph) {
                return 1;
        }

        public int MaxFlowAlgorithm(final Graph graph) {
                return 1;
        }

        public int PrimAlgorithm(final Graph graph) {
                return 1;
        }
}
