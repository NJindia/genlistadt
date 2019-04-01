package cs1302.genlist;
import cs1302.genlistadt.GenList;
import java.util.*;
import java.util.function.*;

/** Test driver for LinkedGenList objects. Tests map, reduce, filter, min, and allMatch methods. */
public class LinkedGenListTest {
    
    public static void main(String[] args) {
        GenList<Integer> iList = new LinkedGenList<Integer>();
        iList.add(10);
        iList.add(20);
        iList.add(30);
        iList.add(4);
        iList.add(34);
        GenList<String> sList = new LinkedGenList<String>();
        sList.add("John");
        sList.add("Jeremy");
        sList.add("Samantha");
        sList.add("Roberto");
        sList.add("Anthony");
        
        LinkedGenListTest.demoMap(iList, sList);
        LinkedGenListTest.demoReduce(iList, sList);
        LinkedGenListTest.demoFilter(iList, sList);
        LinkedGenListTest.demoMin(iList, sList);
        LinkedGenListTest.demoAllMatch(iList, sList);
    } //main
    
    /**
     * Demonstrates and tests the {@code map} method on a {@code GenList} of type {@code Integer}
     * and {@code String}. For the {@code Integer} list, 2 is added to every element. For the
     * {@code String} list, every element is completely capitalized.
     * @param i a parameterized {@code GenList} object of type {@code Integer}
     * @param s a parameterized {@code GenList} object of type {@code String}
     */
    public static void demoMap(GenList<Integer> i, GenList<String> s) {
        //Adds 2.5 to the Integer and makes it a Double
        Function<Integer, Double> iMap = (Integer a) -> a+2.5;
        System.out.println("demoMap: Integer");
        System.out.println("Original List: " + i.makeString(", "));
        System.out.println("Mapped List (Added 2.5 and converted to Double): "
                           + i.map(iMap).makeString(", "));
        System.out.println();
        
        //Makes the String upper-case
        Function<String, String> sMap = (String a) -> a.toUpperCase();
        System.out.println("demoMap: String");
        System.out.println("Original List: " + s.makeString(", "));
        System.out.println("Mapped List (Converted to upper-case): " +
                           s.map(sMap).makeString(", "));
        System.out.println();
    } //demoMap
    
    /**
     * Demonstrates and tests the {@code reduce} method on a {@code GenList} of type 
     * {@code Integer} and {@code String}. For the {@code Integer} list, every element is added to
     * a result, which starts at 0. For the {@code String} list, the first character of each element
     * is added to the {@code String} "First characters: ".
     * @param i a parameterized {@code GenList} object of type {@code Integer}
     * @param s a parameterized {@code GenList} object of type {@code String}
     */
    public static void demoReduce(GenList<Integer> i, GenList<String> s) {
        BinaryOperator<Integer> iReduce = (Integer a, Integer b) -> a + b;
        System.out.println("demoReduce: Integer");
        System.out.println("Original List: " + i.makeString(", "));
        System.out.println("Reduces list by adding each elements to result, which is initially 0");
        System.out.println("Reduction: " + i.reduce(0, iReduce));
        System.out.println();

        BinaryOperator<String> sReduce = (String a, String b) -> a.concat(b.substring(0, 1));
        System.out.println("demoReduce: String");
        System.out.println("Original List: " + s.makeString(", "));
        System.out.println("Reduces list by adding the first character of each element to" +
                           " \"First characters = \"");
        System.out.println("Reduction: " + s.reduce("First characters = ", sReduce));
        System.out.println();
    } //demoReduce

    /**
     * Demonstrates and tests the {@code filter} method on a {@code GenList} of type {@code Integer}
     * and {@code String}. For the {@code Integer} list, elements that aren't less than 25 are
     * filtered out. For the {@code String} list, elements that don't contain "a" are filtered out.
     * @param i a parameterized {@code GenList} object of type {@code Integer}
     * @param s a parameterized {@code GenList} object of type {@code String}
     */
    public static void demoFilter(GenList<Integer> i, GenList<String> s) {
        //True if the Integer is < 25 and > 10
        Predicate<Integer> iFilter = (Integer a) -> (a < 25 && a > 10);
        System.out.println("demoFilter: Integer");
        System.out.println("Original List: " + i.makeString(", "));
        System.out.println("Filtered List (values < 25 and > 10): "
                           + i.filter(iFilter).makeString(", "));
        System.out.println();
        
        //True if the String contains "a" or "m"
        Predicate<String> sFilter = (String a) -> (a.indexOf("a") != -1) || (a.indexOf("m") != -1);
        System.out.println("demoFilter: String");
        System.out.println("Original List: " + s.makeString(", "));
        System.out.println("Filtered List (contains \"a\" or \"m\"): "
                           + s.filter(sFilter).makeString(", "));
        System.out.println();
    } //demoFilter
    
    /**
     * Demonstrates and tests the {@code min} method on a {@code GenList} of type {@code Integer}
     * and {@code String}. For the {@code Integer} list, the element with the minimum value is
     * printed. For the {@code String} list, the element with the minimum length is printed.
     * @param i a parameterized {@code GenList} object of type {@code Integer}
     * @param s a parameterized {@code GenList} object of type {@code String}
     */
    public static void demoMin(GenList<Integer> i, GenList<String> s) {
        //Compares 2 Integers based on their numerical values
        Comparator<Integer> iMin = (Integer a, Integer b) -> {
            if (a < b) {
                return -1;
            } else if (a == b) {
                return 0;
            } else {
                return 1;
            }
        };
        System.out.println("demoMin: Integer");
        System.out.println("Original List: " + i.makeString(", "));
        System.out.println("Min Value: " + i.min(iMin));
        System.out.println();

        //Compares 2 Strings based on their lengths
        Comparator<String> sMin = (String a, String b) -> {
            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() == b.length()) {
                return 0;
            } else {
                return 1;
            }
        };
        System.out.println("demoMin: String");
        System.out.println("Original List: " + s.makeString(", "));
        System.out.println("Min String Length: " + s.min(sMin));
        System.out.println();
    } //demoMin

    /**
     * Demonstrates and tests the {@code allMatch} method on a {@code GenList} of type 
     * {@code Integer} and {@code String}. For the {@code Integer} list, if all elements are
     * non-negative, this prints true. For the {@code String} list, if all {@code Strings}
     * begin with 'J', this prints true.
     * @param i a parameterized {@code GenList} object of type {@code Integer}
     * @param s a parameterized {@code GenList} object of type {@code String}
     */
    public static void demoAllMatch(GenList<Integer> i, GenList<String> s) {
        //True if Integer is not negative or 0
        Predicate<Integer> iMatch = (Integer a) -> (a >= 0) && (a != 0);
        System.out.println("demoAllMatch: Integer");
        System.out.println("Original List: " + i.makeString(", "));
        System.out.println("All elements are non-negative and != 0: " + i.allMatch(iMatch));
        System.out.println();

        //True if the String's first character is 'J' or 'A'
        Predicate<String> sMatch = (String a) -> a.charAt(0) == 'J' || a.charAt(0) == 'A';
        System.out.println("demoAllMatch: String");
        System.out.println("Original List: " + s.makeString(", "));
        System.out.println("All elements begin with 'J' or 'A': " + s.allMatch(sMatch));
        System.out.println();
    } //demoAllMatch
} //LinkedGenListTest
