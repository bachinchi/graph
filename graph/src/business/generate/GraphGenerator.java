package business.generate;

import java.util.HashSet;
import java.util.Set;

import data.AdjacencyListGraph;
import data.AdjacencyMatrixGraph;
import data.Edge;
import data.Graph;
import data.ObjectGraph;

/**
 * Generators based in code from
 * TODO: http://algs4.cs.princeton.edu/41undirected/GraphGenerator.java.html
 */
public class GraphGenerator {

        /**
         * No loops, undirected, no multigraph, unweighted
         */
        public static Graph simpleGraph(final Graph.GRAPH_TYPE graph_type,
                        final int vertices, final int edges) {
                if (edges > (long) vertices * (vertices - 1) / 2)
                        throw new IllegalArgumentException();
                if (edges < 0)
                        throw new IllegalArgumentException();
                Graph graph;
                final Set<Edge> set = new HashSet<Edge>();
                if (graph_type == Graph.GRAPH_TYPE.ADJACENCY_LIST)
                        graph = new AdjacencyListGraph(vertices, false);
                else if (graph_type == Graph.GRAPH_TYPE.ADJACENCY_MATRIX)
                        graph = new AdjacencyMatrixGraph(vertices, false);
                else
                        graph = new ObjectGraph(vertices, false);
                while (graph.getEdgesNumber() < edges) {
                        final int source = business.StdRandom.uniform(vertices);
                        final int target = business.StdRandom.uniform(vertices);
                        final Edge e = new Edge(source, target);
                        if (source != target && !set.contains(e)) {
                                set.add(e);
                                graph.addEdge(source, target);
                        }
                }
                return graph;
        }

        /**
         * No loops, undirected, no multigraph, weighted
         */
        public static Graph weightedSimpleGraph(
                        final Graph.GRAPH_TYPE graph_type, final int vertices,
                        final int edges) {
                if (edges > (long) vertices * (vertices - 1) / 2)
                        throw new IllegalArgumentException();
                if (edges < 0)
                        throw new IllegalArgumentException();
                Graph graph;
                final Set<Edge> set = new HashSet<Edge>();
                if (graph_type == Graph.GRAPH_TYPE.ADJACENCY_LIST)
                        graph = new AdjacencyListGraph(vertices, false);
                else if (graph_type == Graph.GRAPH_TYPE.ADJACENCY_MATRIX)
                        graph = new AdjacencyMatrixGraph(vertices, false);
                else
                        graph = new ObjectGraph(vertices, false);
                while (graph.getEdgesNumber() < edges) {
                        final int source = business.StdRandom.uniform(vertices);
                        final int target = business.StdRandom.uniform(vertices);
                        final int weight = business.StdRandom.uniform(vertices);
                        final Edge e = new Edge(source, target);
                        if (source != target && !set.contains(e)) {
                                set.add(e);
                                graph.addEdge(source, target, weight);
                        }
                }
                return graph;
        }

}
