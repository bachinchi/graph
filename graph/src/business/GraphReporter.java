package business;

import data.interfaces.Graph;

public class GraphReporter {
        public int getGraphDensity(final Graph graph) {
                return 1;
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
