package demo.OITM.second;

public class SummCounter {


    static {
        System.out.println("static init");
        init();
    }

    private static int sum;

    public SummCounter() {
        System.out.println("const");
        init();
        System.out.println("const" + sum);
    }

    public static int getSum() {
        System.out.println("getsum");
        init();
        System.out.println("getsum:" + sum);
        return sum;
    }

    private static volatile boolean initialized = false;

    private static synchronized void init() {
        System.out.println("initialized: " + initialized);
        if(!initialized) {
            System.out.println("iterate");
            for(int i = 0; i < 5; ++i) {
                sum += i;
                System.out.println("sum: " + sum);
            }
            System.out.println("init: " + sum);
            initialized = true;
        }
        System.out.println("initialized: " + initialized);
    }

    public static void main(String[] args) {
        System.out.println(SummCounter.getSum());
    }
}
