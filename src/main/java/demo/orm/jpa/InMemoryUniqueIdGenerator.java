package demo.orm.jpa;

import java.util.UUID;

public class InMemoryUniqueIdGenerator implements UniqueIdGenerator{
    @Override
    public Object getNextUniqueId() {
        return UUID.randomUUID();
    }
}
