package data_structures.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {


    public static int hourglassSum(List<List<Integer>> arr) {
    	int max = Integer.MIN_VALUE;
    	for(int i=0;3>=i;i++) {
    		for(int j=0;3>=j;j++) {
    			int sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
    			+ arr.get(i+1).get(j+1)
    			+ arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
    			max = Math.max(sum, max);
    		}
    		
    	}
		return max;

    }

}
public class array_ds {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        System.out.println(result);
        bufferedReader.close();
    }

}
