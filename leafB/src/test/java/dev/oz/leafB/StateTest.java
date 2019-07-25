package dev.oz.leafB;

import org.junit.Test;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class StateTest {

    Function<String, String> func = s -> s.replace("a", "A");
    BiFunction<String, String, String> func2 = (s, u) -> {
        String r = s.replace("a", s);
        r = r.replace("a", u);
        return r;
    };
    private boolean cond0 = false;
    private boolean cond1 = false;
    private boolean cond2 = false;
    private boolean cond3 = true;
    private boolean cond4 = false;
    private boolean cond5 = true;
    private int val0 = 3;
    private int val1 = 6;
    private int val2 = 5;
    private int val3 = 2;
    private int val4 = 8;
    private int val5 = 9;

    private static int fun(int... arg) {
        for (int i : arg) {
            System.out.println(i);
        }

        return IntStream.of(arg).sum();
    }

    private void oracle() {
        if (cond0 && cond1) {
            if (!cond2 || !cond4) {
                System.out.println("branch 1");
                fun(val0);
            } else if (cond2 && cond5) {
                System.out.println("branch 2");
                fun(val0, val1);
            }
        } else if (!cond0 || (cond2 && !cond4) || (cond3 && cond5 || (cond1 && cond2))) {
            System.out.println("branch 3");
            int fun = fun(val0, val1, val2);
            System.out.println("returned: " + fun);
        } else if (cond4 && !cond5) {
            System.out.println("branch 4");
            fun(val0, val1, val3, val4);
        }
    }

    @Test
    public void testOracle() {
        oracle();
    }

    @Test
    public void testA() {

        State state = new State();
        State.Condition condition0 = state.compose().conditionIf(cond0).and(cond1).build();
        State.Condition condition1 = state.compose().conditionIf(!cond2).or(!cond4).build();
        State.Condition condition2 = state.compose().conditionIf(!cond4).or(cond3).build();
        State.Condition condition3 = state.compose().conditionIf(!cond4).or(cond5).build();
        State.Condition condition4 = state.compose().conditionIf(cond4).build();
    }

    @Test
    public void test() {

        String s0 = "pippo";
        String s1 = "pluto";
        String s2 = "pippo";
        String s3 = "paperino";

        Predicate<String> p0_1 = s -> s.equals(s1);
        Predicate<String> p0_2 = s -> s.equals(s1);
        Predicate<String> p3 = s -> s.contains("pap");
        State state = new State();
        State.Condition condition0 = state
                .compose()
                .conditionIf(p0_1, s0)
                .and(p0_2, s0)
                .build();
        State.Condition condition1 = state
                .compose()
                .conditionIf(p3, s0)
                .or(p3, s3)
                .build();
/*        State.Result<String> res = condition0.thenIf(condition1).then(func, "stringa").orElse("default");
        System.out.println(s);
        assertEquals(true, true);
        condition0.thenIf(condition2).then(func2, "S", "U");*/

    }

}
