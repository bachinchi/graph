package data;

public class Edge {

        private Object source;
        private Object target;

        public Edge() {
                // TODO Auto-generated constructor stub
        }

        public Object getSource() {
                return source;
        }

        public Object getTarget() {
                return target;
        }

        @Override
        public String toString() {
                return "(" + source + ", " + target + ")";
        }

}
