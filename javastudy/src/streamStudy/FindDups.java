package streamStudy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by cchen on 5/25/2017.
 */
public class FindDups {
    public static void main(String[] args){
        Set<String> distinctWords = Arrays.asList(args).stream()
                .collect(Collectors.toSet());
        System.out.println(distinctWords.size() + "distinct words:" + distinctWords);
    }
}
