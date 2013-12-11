package business;

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
        public static int DijkstraAlgorithm(final Graph graph,
                        final int source, final int target) {
                return 1;
        }

        /**
         * Bases on pseudo-code in English Wikipedia
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

                for (int i = 0; i < vertexNumber; i++)
                        for (int j = 0; j < vertexNumber; j++)
                                if (graph.getEdgeWeight(i, j) != 0)
                                        dist[i][j] = graph.getEdgeWeight(i, j);

                for (int k = 0; k < vertexNumber; k++)
                        for (int i = 0; i < vertexNumber; i++)
                                for (int j = 0; j < vertexNumber; j++)
                                        if (dist[i][j] > dist[i][k]
                                                        + dist[k][j])
                                                dist[i][j] = dist[i][k]
                                                                + dist[k][j];
                return (int) dist[source][target];
        }

        /**
         * 
         */
        public static double getGraphDensity(final Graph graph) {
                double result = -1;
                result = 2.0
                                * graph.getEdgesNumber()
                                / (graph.getVerticesNumber() * (graph
                                                .getVerticesNumber() - 1));
                return result;
        }

        /**
         * 
         */
        public static boolean GraphIsomorphism(final Graph graph1,
                        final Graph graph2) {
                return true;
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
