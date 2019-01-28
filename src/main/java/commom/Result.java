package commom;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'secret_napoleon' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER players
     *  2. INTEGER_ARRAY ages
     *  3. INTEGER time
     */

    public static List<Integer> secret_napoleon(int players, List<Integer> ages, int time) {
    // Write your code here
    	List<Integer> resp = new ArrayList<Integer>();
    	
    	int bonapartists = players/2;
    	int royalists = (players - bonapartists)/2;
    	int coalitionists = players - royalists - bonapartists;
    	int napoleonTurn;
    	
    	return resp;

    }

}


