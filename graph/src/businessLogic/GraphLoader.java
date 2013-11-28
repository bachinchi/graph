package businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphLoader {

        /**
         * Code based on 2013-10-15 class example.
         */
        private static ArrayList<int[]> readFile(final String fileName) {
                final ArrayList<int[]> answer = new ArrayList<int[]>();

                BufferedReader br = null;
                final File file = new File(fileName);
                if (file.exists() == false) {
                        System.err.println("Archivo " + fileName + " no existe");
                        return answer;
                }
                try {
                        br = new BufferedReader(new FileReader(file));
                        String str;
                        while ((str = br.readLine()) != null) {
                                final String[] tempStrings = str.split(" ");
                                final int[] numberArray = new int[tempStrings.length];
                                for (int i = 0; i < tempStrings.length; i++)
                                        numberArray[i] = Integer
                                                        .parseInt(tempStrings[i]);
                                answer.add(numberArray);
                        }
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
