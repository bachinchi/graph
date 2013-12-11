package business.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.AdjacencyListGraph;
import data.Graph;

public class TextInput {
        
        /**
         * Code based in stackoverflow example
         * http://stackoverflow.com/questions/13694201/find-out-if-graph-is-isomorphic-java
         * A weight parameter is added to the sample code.
         * Input format should be 
         * n (number of graphs)
         * d 3 0-1:1 0-2:2 1-2:1 1-3:4 2-3:6 (directed, number of vertex, edges...)
         * 4 0-1 0-2 1-2 1-3 2-3 (not directed, number of vertex, edges...[unweighted])
         * ...
         * n graphs
         * TODO: Throw exception when wrong format is introduced.
         * TODO: doesnt check if number of vertices or edges is valid.
         * @return
         */
        public static List<String[]> readInput() {
                List<String[]> answer = new ArrayList<String[]>();
                String input;
                Scanner in = new Scanner(System.in);
                input = in.nextLine();
                int numberOfGraphs = Integer.parseInt(input);
                answer.add(input.split(" "));
                
                for(int i = 0; i < numberOfGraphs; i++) {
                        input = in.nextLine();
                        answer.add(input.split(" "));
                }
                
                return answer;
        }
        
        public static Graph[] parseInput() {
                List<String[]> input = readInput();
                final int numberOfGraphs = Integer.parseInt(input.get(0)[0]);
                Graph[] answer = new Graph[numberOfGraphs];
                for(int i = 0; i < numberOfGraphs; i++) {
                        int j;
                        boolean directed;
                        String[] stringArray = input.get(i + 1);
                        if(stringArray[0].equals("d")) {
                                directed = true;
                                j = 1;
                        } else {
                                directed = false;
                                j = 0;
                        }
                        int numberOfVertices = Character.getNumericValue(stringArray[j].charAt(0));
                        j++;
                        answer[i] = new AdjacencyListGraph(numberOfVertices, directed);
                        for(; j < stringArray.length; j++) {
                                int source = Character.getNumericValue(stringArray[j].charAt(0));
                                int target = Character.getNumericValue(stringArray[j].charAt(2));
                                int weight = 1;
                                if(stringArray[j].length() > 3)
                                        weight = Character.getNumericValue(stringArray[j].charAt(4));
                                answer[i].addEdge(source, target, weight);
                        }
                        
                }
                return answer;
        }
}
