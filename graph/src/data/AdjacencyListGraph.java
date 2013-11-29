package data;

import java.util.LinkedHashMap;
import java.util.Map;

import data.interfaces.Graph;

/**
 * @author BryanAlberto
 * Implementation loosely based on structure proposed in
 * http://opendatastructures.org/ods-java/12_2_AdjacencyLists_Graph_a.html
 */
public class AdjacencyListGraph implements Graph {

        private int n;
        private LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>> adjList;

        public AdjacencyListGraph(int _n) {
                n = _n;
                adjList = new LinkedHashMap<Integer, LinkedHashMap<Integer, Integer>>();
                for (int i = 0; i < n; i++)
                        adjList.put(i, new LinkedHashMap<Integer, Integer>());
        }

        @Override
        public void addEdge(int a, int b, boolean directed) {
                LinkedHashMap<Integer, Integer> adjacent = adjList.get(a);
                LinkedHashMap<Integer, Integer> inner = new LinkedHashMap<Integer, Integer>();
                if (adjacent == null) {
                        adjacent = new LinkedHashMap<Integer, Integer>();
                        adjList.put(a, adjacent);
                }
                if(directed)
                        inner.put(b, 1);
                else
                        inner.put(b, -1);
                adjList.put(a, inner);
        }

        @Override
        public void addEdge(int a, int b, boolean directed, int weight) {
                LinkedHashMap<Integer, Integer> adjacent = adjList.get(a);
                LinkedHashMap<Integer, Integer> inner = new LinkedHashMap<Integer, Integer>();
                if (adjacent == null) {
                        adjacent = new LinkedHashMap<Integer, Integer>();
                        adjList.put(a, adjacent);
                }
                if(directed)
                        inner.put(b, weight);
                else
                        inner.put(b, -weight);
                adjList.put(a, inner);

        }

        @Override
        public boolean removeEdge(int a, int b) {
                if(adjList.get(a).containsKey(b)) {
                        adjList.get(a).remove(b);
                        return true;
                }
                return false;
        }

        @Override
        public int getEdge(int a, int b) {
                return adjList.get(a).get(b);
        }

        @Override
        public Map<Integer, Integer> outEdges(int a) {
                return adjList.get(a);
        }

        @Override
        public Map<Integer, Integer> inEdges(int a) {
                Map<Integer, Integer> output = new LinkedHashMap<Integer, Integer>();
                for(int i = 0; i < n; i++) {
                        if(adjList.get(i).containsKey(a))
                                output.put(i, adjList.get(i).get(a));
                }
                return output;
        }
}
