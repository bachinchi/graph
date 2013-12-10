package data;

public class Edge {

        private final int source;
        private final int target;
        private final int weight;

        public Edge(final int _source, final int _target, final int _weight) {
                source = _source;
                target = _target;
                weight = _weight;
        }

        public int getSource() {
                return source;
        }

        public int getTarget() {
                return target;
        }

        public int getWeight() {
                return weight;
        }

        @Override
        public String toString() {
                return source + "-" + target + ": " + weight;
        }

}
