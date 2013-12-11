package data;

import java.util.Map;

/**
 * @author BryanAlberto Structure based in
 *         http://opendatastructures.org/ods-java/12_Graphs.html
 */
public abstract class Graph {

        public static enum GRAPH_TYPE {
                ADJACENCY_MATRIX, ADJACENCY_LIST, OBJECT_GRAPH
        }

        public GRAPH_TYPE graph_type;

        public boolean directed;

        public abstract void addEdge(int a, int b);

        public abstract void addEdge(int a, int b, int weight);

        public abstract Edge[] getEdges();

        public abstract int getEdgesNumber();

        public abstract int getEdgeWeight(int a, int b);

        public abstract int getVerticesNumber();

        public abstract Map<Integer, Integer> inEdges(int a);

        public abstract Map<Integer, Integer> outEdges(int a);

        public abstract boolean removeEdge(int a, int b);
}
