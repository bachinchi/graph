package data;

import java.util.Arrays;
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
                if (matrix[a][b] == 0)
                        if (directed)
                                matrix[a][b] = 1;
                        else
                                matrix[a][b] = -1;
        }

        @Override
        public void addEdge(final int a, final int b, final boolean directed,
                        final int weight) {
                if (matrix[a][b] == 0)
                        if (directed)
                                matrix[a][b] = weight;
                        else
                                matrix[a][b] = -weight;
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
                return "AdjacencyMatrixGraph [n=" + n + ", matrix="
                                + Arrays.toString(matrix) + "]";
        }
}
