package data;

import java.util.LinkedHashMap;
import java.util.Map;

import data.interfaces.Graph;

/**
 * @author BryanAlberto
 */
public class AdjacencyListGraph implements Graph {

        private final int n;
        private final LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> adjList;

        public AdjacencyListGraph(final int _n) {
                n = _n;
                adjList = new LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>>();
                for (int i = 0; i < n; i++)
                        adjList.put(i, new LinkedHashMap<Integer, Integer>());
        }

        @Override
        public void addEdge(final int a, final int b, final boolean directed) {
                LinkedHashMap<Integer, Integer> adjacent = adjList.get(a);
                final LinkedHashMap<Integer, Integer> inner = new LinkedHashMap<Integer, Integer>();
                if (adjacent == null) {
                        adjacent = new LinkedHashMap<Integer, Integer>();
                        adjList.put(a, adjacent);
                }
                if (directed)
                        inner.put(b, 1);
                else
                        inner.put(b, -1);
                adjList.put(a, inner);
        }

        @Override
        public void addEdge(final int a, final int b, final boolean directed,
                        final int weight) {
                LinkedHashMap<Integer, Integer> adjacent = adjList.get(a);
                final LinkedHashMap<Integer, Integer> inner = new LinkedHashMap<Integer, Integer>();
                if (adjacent == null) {
                        adjacent = new LinkedHashMap<Integer, Integer>();
                        adjList.put(a, adjacent);
                }
                if (directed)
                        inner.put(b, weight);
                else
                        inner.put(b, -weight);
                adjList.put(a, inner);

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
