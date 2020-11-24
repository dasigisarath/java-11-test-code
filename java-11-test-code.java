package com.legato.devops;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


class TestStringFeatures{
	static TestStringFeatures testStringFeatures = new TestStringFeatures();
	
	//This instance method returns a boolean value. Empty Strings and Strings with only white spaces are treated as blank.
	public void testingIsBlank() {
		System.out.println(" ".isBlank()); //true
        String s = "sarath";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true
        System.out.println("====================================================");
        testStringFeatures.testingLines();
        
	}
	
	//This method returns a stream of strings, which is a collection of all substrings split by lines
	public void testingLines() {
		String str = "legato\nhealth\ntechnologies"; 
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));
        System.out.println("====================================================");
        testStringFeatures.testingStrip();
	}
	
	//Removes the white space from both, beginning and the end of string.
	public void testingStrip() {
		String str = "   Anthem   "; 
        System.out.print("Testing strip\n");
        System.out.print(str.strip());
        System.out.println("\nsuccess");
        
        System.out.print("Testing stripleading\n");
        System.out.print(str.stripLeading());
        System.out.println("\nsuccess");
        
        System.out.print("Testing stripTrailing\n");
        System.out.print(str.stripTrailing());
        System.out.println("\nsuccess");
        System.out.println("====================================================");
        testStringFeatures.testingRepeat();
	}
	
	//The repeat method simply repeats the string that many numbers of times as mentioned in the method in the form of an int.
	public void testingRepeat() {
		String str = "Test OK  ".repeat(3);
        System.out.println(str);
	}	
}
class TestPatternRecognizingFeatures{
	
	//This method is similar to Java 8 method asPredicate(). Introduced in JDK 11, this method will create a predicate if pattern matches with input string.
	public void testingAsMatchPredicate() {
		var str = Pattern.compile("aba").asMatchPredicate();
		String insideValue = "legato";
		System.out.println(str.test(insideValue));
		System.out.println(str.test("anthem"));
		System.out.println("====================================================");
	}
}
class TestTimeUnitFeatures {
	//This method is used to convert the given time to a unit like DAY, MONTH, YEAR and for time too.
	public void testingConvert() {
		TimeUnit timeUnit = TimeUnit.DAYS;
		System.out.println(timeUnit.convert(Duration.ofHours(24)));
		System.out.println(timeUnit.convert(Duration.ofHours(50)));
		System.out.println("====================================================");
	}
}

class TestOptionalFeatures {
	 //Optional.isEmpty() This method returns true if the value of any object is null and else returns false.
	public void testingIsEmpty() {
		Optional<Object> inputOne = Optional.empty();
		System.out.println(inputOne.isEmpty());
		Optional<String> inputTwo = Optional.of("TonyStark");
		System.out.println(inputTwo.isEmpty());
		System.out.println("====================================================");
	}
}

class TestNestedClassFeatures{
    private String name = "I can able to access private mem in nested class without creation of bridge internally";

     public class A {
        public void printName() {
            System.out.println("RESULT= "+name);            
        }
    }
}
class TestCollectionApiFeatures{
	//we can convert an collection to array .
	public void testingIsArray() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		Integer[] outputArray = arrayList.toArray(value -> new Integer[value]);
		System.out.println(Arrays.toString(outputArray));
		System.out.println(((Object)(outputArray)).getClass().isArray());
		System.out.println("Success converted an collection to Array");
		System.out.println("====================================================");
	}
	
}

public class App 
{
	private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
    	logger.info("TESTING JAVA JDK 11 STRING FEATURES\n");
    	TestStringFeatures testStringFeatures=new TestStringFeatures();
    	testStringFeatures.testingIsBlank();
    	logger.info("ALL JDK 11 STRING FEATURES ARE WORKING\n");
    	TestPatternRecognizingFeatures testPatternRecognizingFeatures = new TestPatternRecognizingFeatures();
    	testPatternRecognizingFeatures.testingAsMatchPredicate();
    	logger.info("ALL JAVA JDK 11 PATTERN RECOGNIZING FEATUERS ARE WORKING");
    	TestTimeUnitFeatures testTimeUnitFeatures = new TestTimeUnitFeatures();
    	testTimeUnitFeatures.testingConvert();
    	logger.info("ALL JAVA JDK 11 TIME UNIT FEATUERS ARE WORKING");
    	TestOptionalFeatures testOptionalFeatures= new TestOptionalFeatures();
    	testOptionalFeatures.testingIsEmpty();
    	logger.info("ALL JAVA JDK 11 OPTIONAL CLASS FEATUERS ARE WORKING");
    	TestNestedClassFeatures testNestedClassFeatures = new TestNestedClassFeatures();
    	TestNestedClassFeatures.A inner = testNestedClassFeatures.new A();
    	inner.printName();
    	logger.info("ALL JAVA JDK 11 NESTED CLASS FEATUERS ARE WORKING");
    	TestCollectionApiFeatures testCollectionApiFeatures = new TestCollectionApiFeatures();
    	testCollectionApiFeatures.testingIsArray();
    	logger.info("ALL JAVA JDK 11 COLLECTION FEATUERS ARE WORKING");
    	
    	
        }
}
