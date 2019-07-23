package com.tatumalenko.algorithms.util;

import com.google.common.annotations.VisibleForTesting;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StackTraceUtils {

    private static Supplier<Set<StackTraceElement>> stackTraceSupplier =
            () -> Thread.getAllStackTraces().values().stream()
                    .flatMap(Arrays::stream).collect(Collectors.toSet());

    private StackTraceUtils() {
        throw new IllegalStateException("Util class");
    }

    @VisibleForTesting
    void setStackTraceSupplier(Supplier<Set<StackTraceElement>> stackTraceSupplier) {
        StackTraceUtils.stackTraceSupplier = stackTraceSupplier;
    }

    @SafeVarargs
    public static <T extends AnnotatedElement> Predicate<T> withAnnotations(
            final Class<? extends Annotation>... annotations) {
        return input -> input != null && Arrays.equals(annotations,
                annotationTypes(input.getAnnotations()));
    }

    @SafeVarargs
    static public Set<Method> getMethods(Class<?> type,
                                         Predicate<Method>... predicates) {
        return filter(type.isInterface() ? type.getMethods() :
                type.getDeclaredMethods(), predicates);
    }

    @SafeVarargs
    static public Set<Method> getStackTraceMethods(Predicate<Method>... predicates) {
        Set<Method> methods = new HashSet<>();
        Set<StackTraceElement> stackTraceElements = stackTraceSupplier.get();
        for (var stackTraceElement : stackTraceElements) {
            try {
                Class<?> type = Class.forName(stackTraceElement.getClassName());
                String methodName = stackTraceElement.getMethodName();
                Predicate<Method> withMethodName =
                        (Method input) -> input.getName().equals(methodName);
                Set<Method> methodsOfClass =
                        filter(getMethods(type, predicates)
                                .toArray(new Method[0]), withMethodName);
                methods.addAll(methodsOfClass);
            } catch (Exception e) {

            }
        }
        return methods;
    }

    @SafeVarargs
    private static <T> Set<T> filter(final T[] elements, Predicate<T>... predicates) {
        return predicates.length == 0
                ?
                Set.of(elements)
                :
                Arrays.stream(elements)
                        .filter(Arrays.stream(predicates).reduce(x -> true, Predicate::and))
                        .collect(Collectors.toSet());
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends Annotation>[] annotationTypes(Annotation[] annotations) {
        Class<? extends Annotation>[] result = new Class[annotations.length];
        for (int i = 0; i < annotations.length; i++)
            result[i] = annotations[i].annotationType();
        return result;
    }

}
