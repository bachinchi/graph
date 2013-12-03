package data;

import java.util.LinkedHashMap;
import java.util.Map;

import data.interfaces.Graph;

/**
 * @author BryanAlberto
 */
public class AdjacencyMatrixGraph implements Graph {

        private final int n;
        private final int[][] matrix;

        public AdjacencyMatrixGraph(final int _n) {
                n = _n;
                matrix = new int[n][n];
        }

        @Override
        public void addEdge(final int a, final int b, final boolean directed) {
                if (matrix[b][a] == 0)
                        if(directed)
                                matrix[b][a] = 1;
                        else
                                matrix[b][a] = -1;
        }

        @Override
        public void addEdge(final int a, final int b, final boolean directed,
                        final int weight) {
                if (matrix[b][a] == 0)
                        matrix[b][a] = weight;
        }

        @Override
        public int getEdge(final int a, final int b) {
                return matrix[a][b];
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
                for (int i = 0; i < matrix[0].length; i++) {
                        for (int j = 0; j < matrix[0].length; j++)
                                matrixString.append(String
                                                .valueOf(matrix[i][j]) + " ");
                        matrixString.append("\n");
                }
                return "AdjacencyMatrixGraph [n=" + n + ",matrix=\n"
                                + matrixString.toString() + "]";
        }
}
