import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;
import java.util.Scanner;

public class RandomWord {
    public static void main(String ar[]){

        int i = 0;
        String output = null;
        while(!StdIn.isEmpty()){
            String input = StdIn.readString();
            if(StdRandom.bernoulli(1/(i + 1.0))){
                output = input;
            }
            i++;
        }
        if(output!=null){
            StdOut.println(output);
        }


    }

}
