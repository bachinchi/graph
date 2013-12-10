package business;

import data.Graph;

public class GraphReporter {

        /**
         * D = 2E/(V*(V-1))
         * 
         * @param graph
         * @return
         */
        public double getGraphDensity(final Graph graph) {
                final double density = 2
                                * graph.getEdgesNumber()
                                / (graph.getVerticesNumber() * (graph
                                                .getVerticesNumber() - 1));
                return density;
        }

        public boolean isCircuit(final Graph graph) {
                return false;
        }

        public boolean isEulereanPath(final Graph graph) {
                return false;
        }

        public boolean isHamiltonianPath(final Graph graph) {
                return false;
        }

        public boolean isTree(final Graph graph) {
                return false;
        }
}
