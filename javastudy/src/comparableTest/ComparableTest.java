package comparableTest;

import java.util.ArrayList;

/**
 * Created by cchen on 5/16/2017.
 */
public class ComparableTest {

    public static void main(String[] args){
//        Comparable[] comparables = {"abc",6,new UnComparable()}; //Error!
//        Comparable[] comparables = {"abc",6,new ArrayList<Integer>().add(1)};
        int[] arraysizeTest = {1};
        System.out.println(arraysizeTest.length);
        String s1 = "1";
        String s2 = null;
        System.out.println(s1.compareTo(s2));
    }

    private static class UnComparable{
    }
}
