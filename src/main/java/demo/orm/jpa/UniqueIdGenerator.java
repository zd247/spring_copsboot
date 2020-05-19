package demo.orm.jpa;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}
