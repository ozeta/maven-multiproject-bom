package dev.oz.leafB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class State {

    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public ConditionBuilder compose() {
        return new ConditionBuilder();
    }

    private enum BoolOp {AND, OR}

    public class Result<R> {

    }

    public class Condition {
        Predicate first;
        Object firstCondition;
        List<Tuple<BoolOp, Predicate, Object>> predicates = new LinkedList<>();

        public Condition thenIf(Condition condition) {
            return new Condition();
        }

        public <T, R> Result<R> orElse(T par) {
            return new Result<>();
        }

        public <T, R> Result<R> then(Function<T, R> func, T par) {
            func.apply(par);
            return new Result<>();

        }

        public <T, U, R> Result<R> then(BiFunction<T, U, R> func, T par0, U par1) {
            func.apply(par0, par1);
            return new Result<>();
        }
    }

    public class ConditionBuilder {
        Predicate first;
        Object firstCondition;
        List<Tuple<BoolOp, Predicate, Object>> predicates = new LinkedList<>();

        public <C> ConditionBuilder conditionIf(Predicate<C> p0_1, C c0) {
            logger.debug("Adding first predicate and condtion");
            if (Objects.nonNull(first)) {
                throw new RuntimeException("Condition builder is already initialized." +
                        " Use .and() or .or() methods to build a condition pipe");
            }
            first = p0_1;
            firstCondition = c0;
            return this;
        }

        public <C> ConditionBuilder and(Predicate<C> predicate, C condition) {
            logger.debug("Adding an AND predicate");
            predicates.add(new Tuple<>(BoolOp.AND, predicate, condition));
            return this;
        }


        public <C> ConditionBuilder or(Predicate<C> predicate, C condition) {
            logger.debug("Adding an OR predicate");
            predicates.add(new Tuple<>(BoolOp.OR, predicate, condition));
            return this;
        }


        public ConditionBuilder conditionIf(boolean condition) {
            logger.debug("Adding condition: " + condition);
            return this;
        }

        public ConditionBuilder and(boolean condition) {
            logger.debug("Adding AND condition: " + condition);
            return this;
        }

        public ConditionBuilder or(boolean condition) {
            logger.debug("Adding OR condition: " + condition);
            return this;
        }

        public Condition build() {
            logger.debug("Closing condition building");
            return new Condition();
        }
    }
}
