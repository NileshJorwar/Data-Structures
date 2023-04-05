package src.generics;

@FunctionalInterface
public interface FunctionalGenerics<T,R> {
    R execute(T t);
}
