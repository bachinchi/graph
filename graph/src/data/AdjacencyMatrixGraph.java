package data;

import java.util.LinkedHashMap;
import java.util.Map;

import data.interfaces.Graph;

/**
 * @author BryanAlberto
 * Implementation loosely based on structure proposed in
 * http://opendatastructures.org/ods-java/12_1_AdjacencyMatrix_Repres.html
 */
public class AdjacencyMatrixGraph implements Graph {

        private int n;
        private int[][] matrix;

        public AdjacencyMatrixGraph(int _n) {
                n = _n;
                matrix = new int[n][n];
        }

        @Override
        public void addEdge(int a, int b, boolean directed) {
                if (matrix[a][b] == 0) {
                        if(directed)
                                matrix[a][b] = 1;
                        else
                                matrix[a][b] = -1;
                }
        }

        @Override
        public void addEdge(int a, int b, boolean directed, int weight) {
                if (matrix[a][b] == 0) {
                        if(directed)
                                matrix[a][b] = weight;
                        else
                                matrix[a][b] = -weight;
                }
        }

        @Override
        public boolean removeEdge(int a, int b) {
                if(matrix[a][b] != 0) {
                        matrix[a][b] = 0;
                        return true;
                }
                return false;
        }

        @Override
        public int getEdge(int a, int b) {
                return matrix[a][b];
        }

        @Override
        public Map<Integer, Integer> outEdges(int i) {
                Map<Integer, Integer> edges = new LinkedHashMap<Integer, Integer>();
                for (int j = 0; j < n; j++)
                        if (matrix[i][j] != 0)
                                edges.put(j, matrix[i][j]);
                return edges;
        }

        @Override
        public Map<Integer, Integer> inEdges(int i) {
                Map<Integer, Integer> edges = new LinkedHashMap<Integer, Integer>();
                for (int j = 0; j < n; j++)
                        if (matrix[j][i] != 0)
                                edges.put(j, matrix[i][j]);
                return edges;
        }
}
