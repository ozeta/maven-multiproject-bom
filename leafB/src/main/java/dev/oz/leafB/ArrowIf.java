package dev.oz.leafB;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class ArrowIf {

    static public Branch branch(Boolean bool) {
        return new Branch();

    }

    static public class Dto {
        static List<Tuple> branchList = new LinkedList<>();
        public <T> void add(String key1, T i) {
            branchList.add(new Tuple<>(key1, i));
        }
    }

    static public class Metrics {

    }

    static public class Branch {
        static boolean condition;
        static boolean isComplete;
        static List<Branch> branchList = new LinkedList<>();

        public Branch branch(Boolean bool) {
            if (!isComplete) throw new RuntimeException("");
            Branch b = new Branch();
            branchList.add(b);
            condition = bool;
            return b;
        }

        public <T, R> Branch execute(Function<T, R> f, T par) {
            isComplete = true;
            return this;
        }

        public Branch elseif(Boolean bool) {
            return new Branch();
        }

        public Branch elseExecute(Function f) {
            return this;
        }

        public ArrowIf build() {
            return new ArrowIf();
        }

    }
}
