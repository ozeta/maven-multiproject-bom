package dev.oz.leafB;

import org.junit.Test;

import java.util.function.*;

public class ArrowIfTest {
    String s0 = "pippo";
    String s1 = "pluto";
    String s2 = "pippo";
    String s3 = "paperino";
    Predicate<String> p0_1 = s -> s.equals(s1);
    Predicate<String> p0_2 = s -> s.equals(s1);
    Predicate<String> p3 = s -> s.contains("pap");
    Function<String, Integer> fun = o -> {
        System.out.println(o);
        return 0;
    };
    BiFunction<String, String, Integer> biFun = (a, b) -> {
        System.out.println(a + " " + b);
        return 0;
    };
    Consumer<String> con = (a) -> {
        System.out.println(a);
    };
    BiConsumer<String, String> biCon = (a, b) -> {
        System.out.println(a + " " + b);
    };
    private boolean cond0 = false;
    private boolean cond1 = false;
    private boolean cond2 = false;
    private boolean cond3 = true;
    private boolean cond4 = false;
    private boolean cond5 = true;

    private int sout(String arg) {
        System.out.println(arg);
        return 0;
    }

    @Test
    public void test() {
        int res;
        if (cond0) {
            sout("0");
            if (cond1) {
                sout("1");
                if (cond2) {
                    sout("2");
                } else if (cond3) {
                    sout("3");
                }
            } else {
                sout("4");
            }
        } else if (!cond4 || cond5 && cond3) {
            sout("5");
        } else if (cond4 || !cond5 && cond3) {
            sout("5");
        }
    }

    @Test
    public void testA() {

        ArrowIf.Dto dto = new ArrowIf.Dto();
        dto.add("key0", "");
        dto.add("key1", 3);

        ArrowIf.Branch b0 = ArrowIf.branch(cond0);
        b0.execute(fun, "0").elseif(cond4).execute(f -> "00", "a")
                .elseif(cond4).execute(f -> "000","b")
                .elseExecute(f -> 0);

        ArrowIf.Branch b1 = b0.branch(cond1);
        b1.execute(f -> "1","c").elseExecute(f -> 0);

        ArrowIf.Branch b2 = b1.branch(cond1);
        b2.execute(f -> "1", "d").elseExecute(f -> 0)
                .branch(cond2).execute(f -> "2", "e").elseExecute(f -> 0)
                .branch(cond3).execute(f -> "3", "f").elseExecute(f -> 0)
                .build();

        ArrowIf.Metrics executedbranch = b0.process();
    }

}
