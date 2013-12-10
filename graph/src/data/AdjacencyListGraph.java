package data;

import java.util.LinkedHashMap;
import java.util.Map;

import data.interfaces.Graph;

/**
 * @author BryanAlberto
 */
public class AdjacencyListGraph extends Graph {

        private final int n;
        private final LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> adjList;

        public AdjacencyListGraph(final int _n, final boolean _directed) {
                graph_type = GRAPH_TYPE.ADJACENCY_LIST;
                n = _n;
                directed = _directed;
                adjList = new LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>>();
                for (int i = 0; i < n; i++)
                        adjList.put(i, new LinkedHashMap<Integer, Integer>());
        }

        @Override
        public void addEdge(final int a, final int b) {
                adjList.get(a).put(b, 1);
        }

        @Override
        public void addEdge(final int a, final int b, final int weight) {
                adjList.get(a).put(b, weight);
        }

        @Override
        public int getEdge(final int a, final int b) {
                return adjList.get(a).get(b);
        }

        @Override
        public Map<Integer, Integer> inEdges(final int a) {
                final Map<Integer, Integer> output = new LinkedHashMap<Integer, Integer>();
                for (int i = 0; i < n; i++)
                        if (adjList.get(i).containsKey(a))
                                output.put(i, adjList.get(i).get(a));
                return output;
        }

        @Override
        public Map<Integer, Integer> outEdges(final int a) {
                return adjList.get(a);
        }

        @Override
        public boolean removeEdge(final int a, final int b) {
                if (adjList.get(a).containsKey(b)) {
                        adjList.get(a).remove(b);
                        return true;
                }
                return false;
        }

        @Override
        public String toString() {
                return "AdjacencyListGraph [n=" + n + ", adjList=" + adjList
                                + "]";
        }
}
