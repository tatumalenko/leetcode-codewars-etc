package com.tatumalenko.algorithms.java.util;

public class BuilderExample {

    public String a;

    public String b;

    public String c;

    public BuilderExample(final String a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return a + b + c;
    }

    static class Builder {

        String a;

        String b;

        String c;

        public Builder a(final String a) {
            this.a = a;
            return this;
        }

        public Builder b(final String b) {
            this.b = b;
            return this;
        }

        public Builder c(final String c) {
            this.c = c;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(a, b, c);
        }

    }

}