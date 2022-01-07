package data_structures.arrays;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultSA {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    	
    	List<Integer> nums = new ArrayList<Integer>();
    	for(String query:queries) {
    		int num = 0;
    		for(String str:strings) {
    			if(query.equals(str)) num+=1;
    		}
    		nums.add(num);
    	}
    	
    	return nums;

    }

}
public class Spare_array {
	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine();
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .collect(toList());

	        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine();
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .collect(toList());

	        List<Integer> res = ResultSA.matchingStrings(strings, queries);
	        System.out.println(res);


	        bufferedReader.close();
	    }

}
