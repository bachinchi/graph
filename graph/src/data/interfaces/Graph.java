package data.interfaces;

import java.util.Map;

/**
 * @author BryanAlberto
 * Structure bases in
 * http://opendatastructures.org/ods-java/12_Graphs.html
 */
public interface Graph {
        public enum GRAPH_TYPES {
                ADJACENCY_MATRIX, ADJACENCY_LIST
        }

        public void addEdge(int a, int b, boolean directed);

        public void addEdge(int a, int b, boolean directed, int weight);

        public int getEdge(int a, int b);

        // public int getEdges();

        public Map<Integer, Integer> inEdges(int a);

        public Map<Integer, Integer> outEdges(int a);

        public boolean removeEdge(int a, int b);
}
