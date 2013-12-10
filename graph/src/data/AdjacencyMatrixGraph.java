package data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author BryanAlberto
 */
public class AdjacencyMatrixGraph extends Graph {

        public static final GRAPH_TYPE TYPE = Graph.GRAPH_TYPE.ADJACENCY_MATRIX;

        private final int n;
        private final int[][] matrix;

        public AdjacencyMatrixGraph(final int _n, final boolean _directed) {
                graph_type = GRAPH_TYPE.ADJACENCY_MATRIX;
                n = _n;
                directed = _directed;
                matrix = new int[n][n];
        }

        @Override
        public void addEdge(final int a, final int b) {
                if (matrix[b][a] == 0)
                        matrix[b][a] = 1;
        }

        @Override
        public void addEdge(final int a, final int b, final int weight) {
                if (matrix[b][a] == 0)
                        matrix[b][a] = weight;
        }

        @Override
        public int getEdgeWeight(final int a, final int b) {
                return matrix[a][b];
        }

        @Override
        public Edge[] getEdges() {
                final Edge[] answer = new Edge[getEdgesNumber()];
                int index = 0;
                for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                                if (matrix[j][i] != 0) {
                                        answer[index] = new Edge(i, j,
                                                        matrix[j][i]);
                                        index++;
                                }
                return answer;
        }

        @Override
        public int getEdgesNumber() {
                int counter = 0;
                for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                                if (matrix[i][j] != 0)
                                        counter++;
                return counter;
        }

        @Override
        public int getVerticesNumber() {
                return n;
        }

        @Override
        public Map<Integer, Integer> inEdges(final int i) {
                final Map<Integer, Integer> edges = new LinkedHashMap<Integer, Integer>();
                for (int j = 0; j < n; j++)
                        if (matrix[j][i] != 0)
                                edges.put(j, matrix[i][j]);
                return edges;
        }

        @Override
        public Map<Integer, Integer> outEdges(final int i) {
                final Map<Integer, Integer> edges = new LinkedHashMap<Integer, Integer>();
                for (int j = 0; j < n; j++)
                        if (matrix[i][j] != 0)
                                edges.put(j, matrix[i][j]);
                return edges;
        }

        @Override
        public boolean removeEdge(final int a, final int b) {
                if (matrix[a][b] != 0) {
                        matrix[a][b] = 0;
                        return true;
                }
                return false;
        }

        @Override
        public String toString() {
                final StringBuilder matrixString = new StringBuilder();
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++)
                                matrixString.append(String
                                                .valueOf(matrix[i][j]) + " ");
                        matrixString.append("\n");
                }
                return "AdjacencyMatrixGraph [n=" + n + ",directed=" + directed
                                + ", matrix=\n" + matrixString.toString() + "]";
        }
}
