package com.tatumalenko.algorithms.util;

public class BuilderExample {
    public String a;
    public String b;
    public String c;

    public BuilderExample(String a, String b, String c) {
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

        public Builder a(String a) {
            this.a = a;
            return this;
        }

        public Builder b(String b) {
            this.b = b;
            return this;
        }

        public Builder c(String c) {
            this.c = c;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(a, b, c);
        }
    }
}