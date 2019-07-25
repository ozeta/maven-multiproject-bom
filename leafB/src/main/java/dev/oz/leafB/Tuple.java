package dev.oz.leafB;

class Tuple<A, B, C> {
    public A first;
    public B second;
    public C third;

    public Tuple(A a) {
        first = a;
    }

    public Tuple(A a, B b) {
        first = a;
        second = b;
    }

    public Tuple(A a, B b, C c) {
        first = a;
        second = b;
        third = c;
    }
}
