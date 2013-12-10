package business.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.AdjacencyListGraph;
import data.AdjacencyMatrixGraph;
import data.ObjectGraph;
import data.interfaces.Graph;

public class GraphLoader {

        public static Graph[] getGraphs(final String fileName,
                        final Graph.GRAPH_TYPE type)
                        throws TextFileFormatException {
                final ArrayList<char[]> parsedFile = parseFile(readFile(fileName));
                Graph[] graphs;
                final int numberOfGraphs = parsedFile.get(0)[0];
                if (parsedFile.get(0).length > 1 || numberOfGraphs < 1)
                        throw new TextFileFormatException();
                if (type == Graph.GRAPH_TYPE.ADJACENCY_LIST)
                        graphs = new AdjacencyListGraph[numberOfGraphs];
                else if (type == Graph.GRAPH_TYPE.ADJACENCY_MATRIX)
                        graphs = new AdjacencyMatrixGraph[numberOfGraphs];
                else
                        graphs = new ObjectGraph[numberOfGraphs];
                int lineIndex = 1;
                for (int i = 0; i < numberOfGraphs; i++) {
                        final int vertexNumber = parsedFile.get(i + lineIndex)[0];
                        final int edgeNumber = parsedFile.get(i + lineIndex)[1];
                        final boolean directed = parsedFile.get(i + lineIndex)[2] == 'd' ? true
                                        : false;
                        if (parsedFile.get(i + lineIndex).length > 3
                                        || vertexNumber < 1 || edgeNumber < 0)
                                throw new TextFileFormatException();
                        lineIndex++;
                        if (type == Graph.GRAPH_TYPE.ADJACENCY_LIST)
                                graphs[i] = new AdjacencyListGraph(
                                                vertexNumber, directed);
                        else if (type == Graph.GRAPH_TYPE.ADJACENCY_MATRIX)
                                graphs[i] = new AdjacencyMatrixGraph(
                                                vertexNumber, directed);
                        else
                                graphs[i] = new ObjectGraph(vertexNumber,
                                                directed);
                        for (int j = 0; j < edgeNumber; j++) {
                                final char[] edge = parsedFile.get(i
                                                + lineIndex);
                                if (edge.length > 3 || edge[0] < 0
                                                || edge[1] < 0 || edge[2] == 0)
                                        throw new TextFileFormatException();
                                graphs[i].addEdge(edge[0], edge[1], edge[2]);
                                if (j + 1 < edgeNumber)
                                        lineIndex++;
                        }
                }
                return graphs;
        }

        private static ArrayList<char[]> parseFile(
                        final ArrayList<String> strings) {
                final ArrayList<char[]> answer = new ArrayList<char[]>();
                for (final String str : strings) {
                        final String[] lineString = str.split(" ");
                        final char[] charArray = new char[lineString.length];
                        for (int i = 0; i < lineString.length; i++)
                                charArray[i] = lineString[i].charAt(0);
                        answer.add(charArray);
                }
                return answer;
        }

        /**
         * Code based on 2013-10-15 class example. TODO: Throw
         * TextFileFormatException when the text file isnt correct.
         */
        private static ArrayList<String> readFile(final String fileName) {
                // throws TextFileFormatException {
                final ArrayList<String> answer = new ArrayList<String>();

                BufferedReader br = null;
                final File file = new File(fileName);
                if (file.exists() == false) {
                        System.err.println("Archivo " + fileName + " no existe");
                        return answer;
                }
                try {
                        br = new BufferedReader(new FileReader(file));
                        String str;
                        while ((str = br.readLine()) != null)
                                answer.add(str);
                        br.close();
                } catch (final FileNotFoundException e) {
                        System.err.println("Ups, un error: FileNotFoundException");
                        e.printStackTrace();
                } catch (final IOException e) {
                        System.err.println("Ups, un error: IOException ");
                        e.printStackTrace();
                }

                return answer;
        }
}
