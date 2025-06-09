package crode.Specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}

