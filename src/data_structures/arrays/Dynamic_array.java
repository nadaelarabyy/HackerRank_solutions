package data_structures.arrays;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultDS {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    	List<List<Integer>> arr = new ArrayList<List<Integer>>();
    	List<Integer> answer = new ArrayList<Integer>();
    	for(int i=0;n>i;i++)
    		arr.add(new ArrayList<Integer>());
    	int lastAnswer = 0;
    	for(List<Integer> query:queries) {
    		int idx = (query.get(1) ^ lastAnswer) % n;
    		int y = query.get(2);
    		
    		if(query.get(0) == 1) 
    			arr.get(idx).add(query.get(2));
    		
    		if(query.get(0) == 2) {
    			lastAnswer = arr.get(idx).get(y%(arr.get(idx).size()));
    			answer.add(lastAnswer);
    		}
    			
    	}
		return answer;

    }

}
public class Dynamic_array {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = ResultDS.dynamicArray(n, queries);
        System.out.println(result);


        bufferedReader.close();
    }

}
