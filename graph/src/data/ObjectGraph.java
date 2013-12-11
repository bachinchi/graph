package data;

import java.util.HashSet;
import java.util.Map;

public class ObjectGraph extends Graph {

        HashSet<Edge> edges;

        public ObjectGraph(final int _n, final boolean _directed) {
        }

        @Override
        public void addEdge(final int a, final int b) {
                // TODO Auto-generated method stub

        }

        @Override
        public void addEdge(final int a, final int b, final int weight) {
                // TODO Auto-generated method stub

        }

        @Override
        public Edge[] getEdges() {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public int getEdgesNumber() {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public int getEdgeWeight(final int a, final int b) {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public int getVerticesNumber() {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public Map<Integer, Integer> inEdges(final int a) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public Map<Integer, Integer> outEdges(final int a) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public boolean removeEdge(final int a, final int b) {
                // TODO Auto-generated method stub
                return false;
        }

}
