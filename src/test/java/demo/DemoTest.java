package demo;

import com.epam.fxrates.dal.domain.Fxrate;
import com.epam.fxrates.dal.domain.Fxrates;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.neumannmedical.AbbriviationCreator;
import demo.neumannmedical.TestInheritance;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.util.buf.HexUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static demo.StatusOne.ORDER;
import static demo.StatusOne.ORDER_PENDING;
import static java.lang.String.valueOf;

@SpringBootTest
public class DemoTest {

    private AbbriviationCreator underTestString;

    @Value("string value")
    private String value;

    @Before
    public void setup() {
        underTestString = new AbbriviationCreator();
    }

    @Test
    public void testNullSetArrayList() {
//        Map<Long, List<Omega>> latest = new HashMap<>();
        var omega1 = new Omega("stat1", "msg1");
        var omega2 = new Omega("stat2", "msg2");
        var omega3 = new Omega("stat3", "msg3");
        var omega4 = new Omega("stat4", "msg4");
        var omega5 = new Omega("stat5", "msg5");
        var omega6 = new Omega("stat6", "msg6");
        var omega7 = new Omega("stat7", "msg7");
        var omega8 = new Omega("stat8", "msg8");
        var omega9 = new Omega("stat9", "msg9");
        var omega0 = new Omega("stat0", "msg0");
        omega1.setOrder(2);
        omega2.setOrder(1);
        omega3.setOrder(2);
        omega4.setOrder(3);
        omega5.setOrder(1);
        omega6.setOrder(1);
        omega7.setOrder(2);
        omega8.setOrder(1);
        omega9.setOrder(3);
        omega0.setOrder(2);
        omega1.setId(2);
        omega2.setId(3);
        omega3.setId(0);
        omega4.setId(1);
        omega5.setId(2);
        omega6.setId(3);
        omega7.setId(1);
        omega8.setId(3);
        omega9.setId(1);
        omega0.setId(2);
        var omegas1 = Arrays.asList(omega1, omega2, omega3, omega4, omega5, omega6, omega7, omega8, omega9, omega0);
//        var omegas2 = Arrays.asList(omega3, omega4, omega5);
//        var omegas3 = Arrays.asList(omega6, omega7, omega8);
//        var omegas4 = Arrays.asList(omega9, omega0);
//        latest.put(1L, omegas1);
//        latest.put(2L, omegas2);
//        latest.put(3L, omegas3);
//        latest.put(4L, omegas4);
//        latest.put(5L, omegas2);
//        latest.put(6L, omegas3);

        var latest = omegas1.stream().collect(Collectors.groupingBy(Omega::getId));
        for (int i = 0; i < latest.size(); i++) {
            var possible = latest.get(i);
            // this can throw NPE
            if (possible != null) {
//                var sortableList = new ArrayList<>(possible);
                possible.sort(Comparator.comparing(Omega::getOrder));
//                sortableList.sort(Comparator.comparing(Omega::getOrder));
                System.out.println("possible:" +possible);
//                System.out.println("sortableList:" +sortableList);
//                System.out.println("eq:" + sortableList.equals(possible));
            } else
                System.out.println(i +" has no match in latest");
        }
    }

    @Test
    public void testSystemPropertiesAndEnvVars() {
        System.out.println("prop os.arch: " + System.getProperty("os.arch"));
        System.out.println("prop os.name: " + System.getProperty("os.name"));
        System.out.println("prop os.version: " + System.getProperty("os.version"));
        var env = System.getenv();
        System.out.println("env os.arch: " + System.getenv("PROCESSOR_ARCHITECTURE"));
        System.out.println("env os.name: " + System.getenv("OS"));
        System.out.println("env os.version: " + System.getenv("OS_VER"));

        var currentPath = "";
        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (Exception e) {
            System.out.println("something error: " + e);
        }
        System.out.println("Current dir:" + currentPath);
    }

    @Test
    public void testStringEqualsWithPunctuationMark() {
        var actual = "targetBlabLA.yalm";
        var headText = "target";
        var tailText = ".yalm";

        System.out.println(actual.concat(headText));
        System.out.println(actual.concat(tailText));
    }


    @Test
    public void testEqusals() {
        Integer one = 1;
        Integer egy = 1;
        Integer three = null;

        System.out.println("eguals:" + one.equals(egy));
        System.out.println("eguals:" + one.equals(three));
        System.out.println("eguals:" + (one == egy));
        System.out.println("eguals:" + (three == egy));
    }

    @Test
    public void innerTEST() {
        int[] prices = {1, 3, 5, 4, 2};
        int discount = 10;

        Arrays.sort(prices);
        int biggest = prices[prices.length - 1];
        prices = removeArrayElement(prices, prices.length - 1);
        int result = 0;
        for (int sum : prices) {
            result += sum;
        }
        int discounted = biggest * (100 - discount) / 100;

        result += discounted;

        System.out.println(result);
    }

    public int[] removeArrayElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }


    @Test
    public void testFibonacci() {
        BigInteger firstElem = BigInteger.valueOf(0L);
        BigInteger secondElem = BigInteger.valueOf(1L);

        BigInteger result = BigInteger.valueOf(0L);

        long i = 0;

        List<BigInteger> fibonaccis = new LinkedList<>();

        fibonaccis.add(firstElem);
        fibonaccis.add(secondElem);
        while (i < 1000) {
            result = firstElem.add(secondElem);
            fibonaccis.add(result);
            firstElem = secondElem;
            secondElem = result;
            i++;
        }
//        fibonaccis.stream().forEach(System.out::println);
        fibonaccis.stream().map(it -> it + ", ")
                .forEach(System.out::print);
    }

    @Test
    public void testPrimes() {
        int start = 0;
        int end = 1000;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testObjectMapperToString() {
        ObjectMapper mapper = new ObjectMapper();

        Omega omega = new Omega("good1", "words1");

        String json = "";
        try {
            json = mapper.writeValueAsString(omega);

        } catch (Exception e) {
            System.out.println("syntax erra");
        }

        System.out.println(json);
    }

    @Test
    public void bitbucketAccessTest() {
        System.out.println("Something, something, testing, testing");
    }

    @Test
    public void testSignatureCheck() {
        String secretKey = "aGr9jZxVG0";

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("PS_SIGNATURE", "294e0e77d32750323cfe1f81d59cd672cea66286");
        requestParameters.put("PS_EXPIRETIME", "1644487248");
        requestParameters.put("PS_SIGTYPE", "PSSHA1");
        requestParameters.put("client_id", "738204");
        requestParameters.put("domain", "emerchantpay.com");
        requestParameters.put("notification_type", "orderdeclined");
        requestParameters.put("order_id", "1155422624");
        requestParameters.put("order_reference", "722131231");
        requestParameters.put("trans_id", "145238088600");
        requestParameters.put("trans_type", "auth");
        requestParameters.put("payment_method", "creditcard");
        requestParameters.put("response", "D");
        requestParameters.put("response_code", "OP-123");
        requestParameters.put("response_text", "3rd Party abandoned");

        String expected = requestParameters.remove("PS_SIGNATURE");

        String signatureString = requestParameters
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(queryParam -> String.format("%s=%s", queryParam.getKey(), queryParam.getValue()))
                .collect(Collectors.joining("&", String.format("%s&", secretKey), ""));

        System.out.println(signatureString);

        String digestAlgorithm = requestParameters.get("PS_SIGTYPE");

        String result = "";
        if (digestAlgorithm != null) {
            byte[] signatureBytes = signatureString.getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes;
            try {
                if ("PSMD5".equalsIgnoreCase(digestAlgorithm)) {
                    hashBytes = MessageDigest.getInstance("MD5").digest(signatureBytes);
                } else if ("PSSHA1".equalsIgnoreCase(digestAlgorithm)) {
                    hashBytes = MessageDigest.getInstance("SHA-1").digest(signatureBytes);
                } else {
                    hashBytes = new byte[0];
                }

                result = HexUtils.toHexString(hashBytes);
                System.out.println("Signature middle= " + result);
                System.out.println("result = " + result.equals(expected));

            } catch (NoSuchAlgorithmException e) {
                System.out.println("Unsupported SIG algorithm: " + digestAlgorithm);
                System.out.println("Exception occurred during hashing: " + e.getMessage());
            }
        }
    }

    @Test
    public void testEnumIterationStream() {
        String notificationType = "orderdeclined";
        Set<String> SUCCESS_NOTIFICATION_TYPES = Collections.unmodifiableSet(
                Stream.of(ORDER.getValue(),
                                ORDER_PENDING.getValue(),
                                StatusOne.ORDER_DECLINED.getValue())
                        .collect(Collectors.toSet()));

        boolean result = SUCCESS_NOTIFICATION_TYPES.contains(notificationType);

        System.out.println("Result: " + result);
        System.out.println(String.format("Enum name: %s", ORDER_PENDING.name()));
    }

    @Test
    public void Collatz() {
        long n = 3;
        long elementsNumber = 0;
        long effectiveNumber = elementsNumber;
        long counter = 0;
        int limit = 10;
        do {
            elementsNumber = recurziveCollatz(n);
            if (isPrime(elementsNumber)) {
                counter++;
                effectiveNumber = n;
//                if (counter % 5000 == 0) {
                System.out.println("elementsNumber = " + elementsNumber);
                System.out.println("counter = " + counter);
                System.out.println("hatékony szám = " + effectiveNumber);
                System.out.println("---------------------------");
//                }
            }
            n++;
//            System.out.println("elem = " + n);
        } while (counter != limit);
        System.out.println("counter = " + counter);
        System.out.println("hatékony szám = " + effectiveNumber);
    }

    private boolean isPrime(long n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private int recurziveCollatz(long n) {
        int elementsNumber = 0;
        while (n != 1) {
            elementsNumber++;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
//            System.out.println("N= " + n);
        }
//        System.out.println("A sorozat elemszáma = " + elementsNumber);
        return elementsNumber;
    }

    @Test
    public void testIndexOutOfBoundsException() {
        List<String> list = new ArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println("4th elem of list: " + list.get(4));

    }

    @Test
    public void timeNowEpoch() {
        long time = Instant.now().toEpochMilli();
        long time2 = Math.abs(Instant.now().toEpochMilli() - 11000000000000L);
        long nano = LocalTime.now().toNanoOfDay();
        int sec = LocalTime.now().toSecondOfDay();
        String secString = valueOf(sec);

        System.out.println("time: " + time);
        System.out.println("time2: " + time2);
        System.out.println("nano: " + nano / 1000000);
        System.out.println("sec: " + sec);
        System.out.println("secString: " + secString);
    }

    @Test
    public void stringFormat() {

        String text = "Alpha";
        String text2 = "Beta";
        String formattedText = String.format("%s %s", text, text2);

        String fieldName = "pan";

        String defaultMessageTemplate = "Credit cards %s are blocked";

        System.out.println("message: " + String.format(defaultMessageTemplate, fieldName));

        System.out.println("Formatted text: " + formattedText);

        System.out.println("line feed check");
    }

    @Test
    public void testDefaultValue() {
        System.out.println("The value is: " + value);
    }

    @Test
    public void multiConcat() {
        String sid = "1234";
        String text = "first";
        String result = text.concat("&sid=").concat(sid).concat("&second=2nd");
        System.out.println("Result: " + result);
    }

    @Test
    public void tetIncrement() {
        int increment = 42;
        Function<Integer, Integer> increaseFunction = this.createIncreaseFunction(increment);
        increment += 2;
        int secretCode = increaseFunction.apply(10);
        System.out.println("secretCode: " + secretCode);

    }

    public Function<Integer, Integer> createIncreaseFunction(int inc) {
        Function<Integer, Integer> integerIntegerFunction = value -> value + inc / 2;
        return integerIntegerFunction;
    }


    class Book {
        private String name;
        private int releaseYear;
        private String isbn;

        public Book(String name, int releaseYear, String isbn) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.isbn = isbn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }

    @Test
    public void asciiCode() throws IOException {
        String text = "abcd";
        String[] textSplit = text.split("");
        FileWriter writer = new FileWriter(new File("encrypt.txt"));
        Arrays.stream(textSplit).forEach(System.out::println);
        Arrays.stream(textSplit).map(it -> convert(it, writer)).forEach(System.out::println);
        writer.close();
    }

    private String convert(String letter, FileWriter writer) {
        char character = letter.charAt(0);
        System.out.println("character :" + character);
        int ascii = (int) character - 96;
        System.out.println("ascii: " + ascii);
        String result = String.valueOf(Character.toChars(ascii));

        System.out.println("result: " + result);
        try {

            writer.write(result + "\\n");
        } catch (IOException ioException) {
            System.out.println("ERROR: " + ioException);
        }
        return result;
    }

    @Test
    public void nullCheck() {
        Fxrate fxrate = new Fxrate();
        fxrate.setBaseCurrencyCode("USD");
        fxrate.setTargetCurrencyCode("EUR");
        fxrate.setRate("1,234");
        System.out.println("Fxrates: " + fxrate);
        fxrate = null;
        System.out.println("Fxrates2 : " + fxrate);
//        System.out.println("Fxrates: " + fxrate.toString());
    }

    @Test
    public void staticCheck() {
        DemoStaticStatus demo = new DemoStaticStatus();
        DemoStaticStatus.doSum();
        demo = null;
        demo.doSum();
    }

    @Test
    public void checkNullParam() {
        Fxrate fxrate = new Fxrate();
        fxrate.setBaseCurrencyCode("USD");
        fxrate.setTargetCurrencyCode("EUR");
        fxrate.setRate("1,234");
        Fxrates fxrates = new Fxrates();
        List<Fxrate> fxrateList = new ArrayList<>();
        fxrateList.add(fxrate);
        fxrates.setFxrates(fxrateList);
//        fxrates.setCurrentVersion(123);
        Fxrates fxrates2 = null;

        System.out.println("fx rate: " + fxrates.getCurrentVersion());
//        testCallNullParam(fxrates.getCurrentVersion());
//        testCallNullParam(fxrates2.getCurrentVersion());

    }

    @Test
    public void emptyListCheck() {
        List<Long> list = new ArrayList<>();
        for (Long element : list) {
            System.out.println("element:" + element);
        }
    }

    @Test
    public void emptyStringCheck() {
        String empty = "";
        Assert.assertTrue(empty.isEmpty());
    }

    @Test
    public void testListOfNull() {
        List<String> nulls = new ArrayList<>();
        nulls.add(null);
        nulls.add(null);
        nulls.add(null);

        nulls.forEach(System.out::println);
    }

    @Test
    public void testOracle() {

        int[] steps = new int[1];
        System.out.println(steps[0]);

    }

    @Test
    public void testListOfNumberAndNumbeExttends() {
        List<Number> numbers = new ArrayList<>();

        List<Integer> intNumbers = new ArrayList<>();

        Integer one = new Integer("1");
        Integer two = new Integer("2");
        Long three = new Long("3");
        Long four = new Long("4");

        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(null);

        intNumbers.add(one);
        intNumbers.add(two);
        intNumbers.add(null);

        printListElements(numbers);
        printListElements(intNumbers);

    }

    @Test
    public void testWhiteSpaceSplit() {
        String text = "1 2 3 4 5";
        List<String> splitText = Arrays.asList(text.split(" "));
        System.out.println(splitText);
    }

    @Test
    public void testInputStream() {
        String listOfFavorites =
                "Béla Gábor András" +
                        "\nGábor Péter Balázs\n" +
                        "Péter András Balázs\n" +
                        "Gábor Balázs Péter Gábor\n" +
                        "András Balázs Péter András\n" +
                        "Balázs Péter Béla\n" +
                        "Béla Péter Balázs";
        System.out.println(listOfFavorites);
        InputStream is = new ByteArrayInputStream(listOfFavorites.getBytes());
        System.out.println(is);
        List<String> result = new BufferedReader(new InputStreamReader(is))
                .lines()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void regex() {
        String text = "asdQÄW.Eqw-e";
        boolean regex = text.matches("^[a-zA-Z./'-Ä]*$");
        System.out.println("result: " + regex);
        Assert.assertTrue(regex);
    }

    @Test
    public void toStringCheck() {
        System.out.println("text".toString() == "text");
    }

    @Test
    public void toDoubleEQualsCheck() {
        System.out.println(0.0 == -0.0 ? false : true);
    }

    @Test
    public void toTwoInterfaceSameMethodImpl() {
        new TwoInterfaceImpl().method();
    }

    @Test
    public void testIntegerParseIntNull() {
        String nothing = null;
//        Integer.parseInt(nothing);
    }

    @Test
    public void testHappyTest() {
        String name = "neumann Medicval";
        String expected = "NM";

        String actual = underTestString.createAbbreviation(name);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyStringTest() {
        String name = "";

        String actual = underTestString.createAbbreviation(name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullStringTest() {
        String name = null;

        String actual = underTestString.createAbbreviation(name);
    }

    @Test
    public void testModifies() {
        int i = 1;
        Integer bigInt = new Integer("1");
        String s = "foo";
        StringBuffer sb = new StringBuffer();

        modify(i, bigInt, s, sb);

        Assert.assertEquals(1, i);
        Assert.assertEquals(new Integer("1"), bigInt);
        Assert.assertEquals("foo", s);
        Assert.assertEquals("stuff", sb.toString());
    }

    @Test
    public void testInteregEquals() {
        Integer x = new Integer("1");
        Integer y = new Integer(1);

        Assert.assertFalse(x == y);
        Assert.assertTrue(x.equals(y));
    }

    @Test
    public void testStrignPoolEquals() {
        String a = "foo";
        String b = "foo";

        Assert.assertTrue(a == b);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testNewStringEquals() {
        String a = new String("foo");
        String b = new String("foo");

        Assert.assertFalse(a == b);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testTrimWthiteSpaces() {
        String whiteSpaces = "         ";
        String expected = "";

        String actual = whiteSpaces.trim();

        Assert.assertEquals(expected, actual);
        Assert.assertTrue(actual.isEmpty());

    }

    @Test
    public void testChildOverride() {
        new TestInheritance.ChildTestInheritance().increment();
    }

    private void modify(int i, Integer bigInt, String s, StringBuffer stringBuffer) {
        i += 2;
        bigInt = new Integer("3");
        s = s.toUpperCase();
        stringBuffer.append("stuff");
    }


    private void printListElements(List<? extends Number> digits) {
        digits.add(null);
        digits.forEach(System.out::println);
    }

    private void testCallNullParam(int number) {
        System.out.println("number is: " + number);
        long sum = number + 1;
        System.out.println("sum = " + sum);
    }

    @Test
    public void longEquals() {
        Long a = 123456789L;
        long b = 123456789L;
        Long c = 123456789L;
        long d = 123456789L;

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));

        System.out.println(a.equals(b));

        System.out.println(b == c);
        System.out.println(b == d);
    }

    @Test
    public void radGauge() {
        double radGuage = 3.6;

        if (radGuage > 4) {
            System.out.println("Terrbile");
        } else if (radGuage > 3) {
            System.out.println("Not great, not terrible");
        } else {
            System.out.println("Great");
        }
//        Assert.assertEquals(new A(5), new A(5.0));

//        Assert.assertEquals(new Float(4.5), new Double(4.5));
    }

    @Test
    public void intRecurzive() {
        int num = 1234;

        recurziveIntSout2(2);
    }

    @Test
    public void collectionPrint() {
        List<String> list = new ArrayList<>();

        list.add("First");
        list.add("Second");
        list.add("Third");

        System.out.println("The list: " + list);

    }

    @Test
    public void testEmptyStringList() {
        List<String> strings = Arrays.asList("First", "", "third", "", "fifth");
        System.out.println("Strings: " + strings);
    }

    @Test
    public void testNewStringValue() {
        List<String> texts = Arrays.asList(new String(), new String(), "", "");

        System.out.println("texts: " + texts);
    }

    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        String firstPart = "first";
        String emptyString = "";
        String secondPart = "second";

        sb.append(emptyString);
        sb.append(emptyString);


        System.out.println("text: " + sb.toString());
    }

    @Test
    public void testFromListToArray() {
        List<String> texts = Arrays.asList("one", "two", "three");
        String[] textArray = texts.toArray(new String[0]);
        for (String s : textArray) {
            System.out.println(s);
        }
    }

    @Test
    public void testStringArrayDuplicates() {

        String[] textsOne = new String[]{"one", " two", "three"};
        String[] textsTow = new String[]{"two", " two", "three"};
        String[] textsThree = new String[]{"one", " two", "three"};
        String[] textsFour = new String[]{"one", " one", "rwo"};

        Set<String[]> setOfArray = new HashSet<>();
        setOfArray.add(textsOne);
        setOfArray.add(textsTow);
        setOfArray.add(textsThree);
        setOfArray.add(textsFour);

        List<String[]> newTexts = setOfArray.stream().distinct().collect(Collectors.toList());

        newTexts.stream().forEach(it -> Arrays.stream(it).forEach(System.out::println));
    }

    private void recurziveIntSout(int x) {
        System.out.println(x % 10);

        if ((x / 10) != 0) {
            recurziveIntSout(x / 10);
        }
        System.out.println(x % 10);
    }

    private int recurziveIntSout2(int n) {
        if (n == 4) {
            System.out.println(n);
            return n;
        } else {
            int result = 2 * recurziveIntSout2(n + 1);
            System.out.println((result));

            return result;
        }
    }

    @Test
    public void checkAndOrMix() {

        boolean firstTrue = true;
        boolean secondTrue = true;
        boolean firstFalse = false;
        boolean secondFalse = false;

        boolean result;

        if (istrue(firstTrue)
                && (istrue(secondTrue)
                || istrue(firstFalse))) {
            result = true;
        } else {
            result = false;
        }

//        Assert.assertTrue(!result);

    }

    @Test
    public void testBase64() {

        String text = "simple text";
        String encodeString = Base64.getEncoder().encodeToString(text.getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encodeString);
        String decodedString = new String(decodedBytes);
        System.out.println("The result:" + decodedString);

        Assert.assertEquals(text, decodedString);
    }

    @Test
    public void randomLong() {
        long leftLimit = 1L;
        long rightLimit = 10000000L;

        for (int i = 0; i < 20; i++) {
            System.out.println(leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
        }
    }

    @Test
    public void ifElseIfElseChecck() {
        long result1 = executeIfElseMethod(true, true, true);
        long result2 = executeIfElseMethod(false, true, true);
        long result3 = executeIfElseMethod(false, false, true);
        long result4 = executeIfElseMethod(false, false, false);

        long expected1 = 1L;
        long expected2 = 2L;
        long expected3 = 3L;
        long expected4 = 4L;

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);

    }

    @Test
    public void testReturnBooleanOrBoolean() {
        boolean result11 = false;
        boolean result12 = false;
        Boolean expected1 = false;

        boolean result21 = true;
        boolean result22 = false;
        Boolean expected2 = true;

        boolean result31 = false;
        boolean result32 = true;
        Boolean expected3 = true;

        boolean result41 = true;
        boolean result42 = true;
        Boolean expected4 = true;

        Boolean actual1 = getTwoBooleansWirthOr(result11, result12);
        Boolean actual2 = getTwoBooleansWirthOr(result21, result22);
        Boolean actual3 = getTwoBooleansWirthOr(result31, result32);
        Boolean actual4 = getTwoBooleansWirthOr(result41, result42);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
    }

    @Test
    public void testFilterNonAndMap() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(5);
        ints.add(8);
        ints.add(10);

        List<Integer> list = ints.stream().filter(number -> number > 10).collect(Collectors.toList());

        Omega first = new Omega("alpha", "11200");

        Omega second = new Omega("beta", "15100");

        Set<Omega> states = new HashSet<>();
        states.add(first);
        states.add(second);

        Long sampleState = 15100L;

        Omega result = states.stream().filter(it -> it.getState().equals(sampleState.toString())).findFirst().orElseThrow(() -> new RuntimeException());

        System.out.println("Result = " + result);

    }

    @Test
    public void testNumbersAdding() {
        int i = 5;
        int j = 6;
        int sum1 = 1;
        int sum2 = 1;

        sum1 = +i;
        sum2 += i;
        System.out.println(sum1);
        System.out.println(sum2);
    }

    @Test
    public void binarySearchBatmanCodingGame() {
        int W = 10;
        int H = 10;
        int N = 6;
        int X0 = 2;
        int Y0 = 5;
        int xLow = 0;
        int xHigh = 0;
        int yLow = 0;
        int yHigh = 0;

        String bombDir = "DR";
        switch (bombDir) {
            case "U":
                yHigh = Y0;
                Y0 = getY0(yLow, yHigh);
                break;
            case "UR":
                xLow = X0;
                yHigh = Y0;
                X0 = getX0(xLow, xHigh);
                Y0 = getY0(yLow, yHigh);
                break;
            case "R":
                xLow = X0;
                X0 = getX0(xLow, xHigh);
                break;
            case "DR":
                xLow = X0;
                yLow = Y0;
                X0 = getX0(xLow, xHigh);
                Y0 = getY0(yLow, yHigh);
                break;
            case "D":
                yLow = Y0;
                Y0 = getY0(yLow, yHigh);
                break;
            case "DL":
                xHigh = X0;
                yLow = Y0;
                X0 = getX0(xLow, xHigh);
                Y0 = getY0(yLow, yHigh);
                break;
            case "L":
                xHigh = X0;
                X0 = getX0(xLow, xHigh);
                break;
            case "UL":
                xHigh = X0;
                yHigh = Y0;
                X0 = getX0(xLow, xHigh);
                Y0 = getY0(yLow, yHigh);
                break;
        }
        System.out.println(X0 + " " + Y0);
    }

    @Test
    public void testStringAndInt() {
        System.out.println(1 + 2 + "3");
        System.out.println("1" + 2 + 3);
    }

    @Test
    public void testListContains() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(1);
        ints.add(5);
        ints.add(8);
        ints.add(2);

        Assert.assertTrue(ints.contains(1));
    }

    @Test
    public void nullLongToString() {
        Long id = null;
        String first = "first";
        String second = "second";

        System.out.println("long: " + id);
        System.out.println("long: " + first + id + second);
    }

    private int getX0(int xLow, int xHigh) {
        return (xLow + xHigh) / 2;
    }

    private int getY0(int yLow, int yHigh) {
        return (yLow + yHigh) / 2;
    }

    private Integer plusOne(Integer number) {
        return ++number;
    }

    private Boolean getTwoBooleansWirthOr(boolean resutl1, boolean resut21) {
        return resutl1 || resut21;
    }

    private long executeIfElseMethod(boolean condi1, boolean condi2, boolean condi3) {
        long result = 0;
        if (condi1) {
            result = 1;
        } else if (condi2) {
            result = 2;
        } else {
            if (condi3) {
                result = 3;
            } else {
                result = 4;
            }
        }
        return result;
    }

    private boolean istrue(boolean condi) {
        return condi;

    }
}
@Data
@RequiredArgsConstructor
@ToString
class Omega {

    private int id;
    private int order;

    private final String state;

    private final String text;
}


// -----------------------------------------------------------------------------

class TwoInterfaceImpl implements DemoInterfaceFirst, DemoInterfaceSecond {

    @Override
    public void method() {
        System.out.println("implementation");
    }
}

enum StatusOne {
    ORDER("order"),

    //for notifications
    ORDER_DECLINED("orderdeclined"),
    ORDER_PENDING("orderpending"),
    ORDER_FAILURE("orderfailure");

    private final String value;

    StatusOne(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusOne parse(String value) {
        StatusOne result = null;

        for (StatusOne notificationType : values()) {
            if (notificationType.getValue().equals(value)) {
                result = notificationType;
                break;
            }
        }

        return result;
    }

}

enum StatusTwo {
    THREE,
    FOUR,
    FIVE
}