package com.tatumalenko.algorithms.java.util;

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
    static void setStackTraceSupplier(final Supplier<Set<StackTraceElement>> stackTraceSupplier) {
        StackTraceUtils.stackTraceSupplier = stackTraceSupplier;
    }

    @SafeVarargs
    public static <T extends AnnotatedElement> Predicate<T> withAnnotations(
        final Class<? extends Annotation>... annotations) {
        return input -> input != null && Arrays.equals(annotations,
            annotationTypes(input.getAnnotations()));
    }

    @SafeVarargs
    static public Set<Method> getMethods(final Class<?> type,
                                         final Predicate<Method>... predicates) {
        return filter(type.isInterface() ? type.getMethods() :
            type.getDeclaredMethods(), predicates);
    }

    @SafeVarargs
    static public Set<Method> getStackTraceMethods(final Predicate<Method>... predicates) {
        final Set<Method> methods = new HashSet<>();
        final Set<StackTraceElement> stackTraceElements = stackTraceSupplier.get();
        for (final var stackTraceElement : stackTraceElements) {
            try {
                final Class<?> type = Class.forName(stackTraceElement.getClassName());
                final String methodName = stackTraceElement.getMethodName();
                final Predicate<Method> withMethodName =
                    (Method input) -> input.getName().equals(methodName);
                final Set<Method> methodsOfClass =
                    filter(getMethods(type, predicates)
                        .toArray(new Method[0]), withMethodName);
                methods.addAll(methodsOfClass);
            } catch (final Exception e) {

            }
        }
        return methods;
    }

    @SafeVarargs
    private static <T> Set<T> filter(final T[] elements, final Predicate<T>... predicates) {
        return predicates.length == 0
            ?
            Set.of(elements)
            :
            Arrays.stream(elements)
                .filter(Arrays.stream(predicates).reduce(x -> true, Predicate::and))
                .collect(Collectors.toSet());
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends Annotation>[] annotationTypes(final Annotation[] annotations) {
        final Class<? extends Annotation>[] result = new Class[annotations.length];
        for (int i = 0; i < annotations.length; i++) {
            result[i] = annotations[i].annotationType();
        }
        return result;
    }

}
