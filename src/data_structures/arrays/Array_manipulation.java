package data_structures.arrays;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultAM {


    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    	long[] arr = new long[n+2];
    	long max = Long.MIN_VALUE;
    	for(List<Integer> query:queries) {
    		int a = query.get(0);
    		int b = query.get(1);
    		int k = query.get(2);
    		arr[a] +=k;
    		arr[b+1] -=k;
    	}
    	
    	// prefix sum algorithm to avoid doing a nested loop when updating an array between a range
    	long[] prefix_sum = new long[n+2];
    	for(int i=1;prefix_sum.length-1>i;i++) {
    		prefix_sum[i] = prefix_sum[i-1] + arr[i];
    		max = Math.max(max, prefix_sum[i]);
    	
    	}
    	
		return max;

    }

}
public class Array_manipulation {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
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

        long result = ResultAM.arrayManipulation(n, queries);

        System.out.println(result);
        bufferedReader.close();
    }

}
