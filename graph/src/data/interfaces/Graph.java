package data.interfaces;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Graph {
        public void addEdge(int a, int b, boolean directed);

        public void addEdge(int a, int b, boolean directed, int weight);

        public boolean removeEdge(int a, int b);

        public int getEdge(int a, int b);

        public Map<Integer, Integer> outEdges(int a);

        public Map<Integer, Integer> inEdges(int a);
}
