package demo.neumannmedical;

public class TestInheritance {
    int a;

    public void increment() {
        doincrement();
        System.out.println(a);
    }

    protected void doincrement() {
        a += 1;
    }

    public static class ChildTestInheritance extends TestInheritance {
        public void doincrement() {
            a -= 1;
        }
    }
}

