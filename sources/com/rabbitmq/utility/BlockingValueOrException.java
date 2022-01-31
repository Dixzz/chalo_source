package com.rabbitmq.utility;

import com.rabbitmq.utility.SensibleClone;
import java.lang.Throwable;
import java.util.concurrent.TimeoutException;

public class BlockingValueOrException<V, E extends Throwable & SensibleClone<E>> extends BlockingCell<ValueOrException<V, E>> {
    public void setException(E e) {
        super.set(ValueOrException.makeException(e));
    }

    public void setValue(V v) {
        super.set(ValueOrException.makeValue(v));
    }

    public V uninterruptibleGetValue() throws Throwable {
        return (V) ((ValueOrException) uninterruptibleGet()).getValue();
    }

    public V uninterruptibleGetValue(int i) throws Throwable, TimeoutException {
        return (V) ((ValueOrException) uninterruptibleGet(i)).getValue();
    }
}
