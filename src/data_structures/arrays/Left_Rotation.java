package data_structures.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class ResultLR {
	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		int rot = d% arr.size();
		while(rot>0) {
			arr.add(arr.remove(0));
			rot--;
		}
		return arr;

	    }

}

public class Left_Rotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultLR.rotateLeft(d, arr);
        System.out.println(result);

        bufferedReader.close();
    }
}