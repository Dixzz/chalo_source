package com.rabbitmq.utility;

import com.rabbitmq.utility.SensibleClone;
import java.lang.Throwable;

public class ValueOrException<V, E extends Throwable & SensibleClone<E>> {
    private final E _exception;
    private final boolean _useValue;
    private final V _value;

    private ValueOrException(V v, E e, boolean z) {
        this._useValue = z;
        if (z) {
            this._value = v;
            this._exception = null;
            return;
        }
        this._value = null;
        this._exception = e;
    }

    public static <V, E extends Throwable & SensibleClone<E>> ValueOrException<V, E> makeException(E e) {
        return new ValueOrException<>(null, e, false);
    }

    public static <V, E extends Throwable & SensibleClone<E>> ValueOrException<V, E> makeValue(V v) {
        return new ValueOrException<>(v, null, true);
    }

    public V getValue() throws Throwable {
        if (this._useValue) {
            return this._value;
        }
        throw Utility.fixStackTrace(this._exception);
    }
}
