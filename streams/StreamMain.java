package streams;

import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {








    static void main() {



            // Check whether  all the numbers in the given list are positive
        List<Integer> numbers = Arrays.asList(5, 10, 3, 8, 2);
        Boolean matched = numbers.stream().allMatch(x->x>0);
        System.out.print(matched);


    }
}
