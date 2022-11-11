package demo.OITM.fifth;

import org.junit.jupiter.api.Test;

public class Fibonacci {

    @Test
    public void testFib() {
        var n = 10;
        var a = 0;
        var b = 1;

        System.out.println("fib: " + fib(n,a,b));
    }

    private int fib(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        return fib(n-1, b, a+b);
    }
}
