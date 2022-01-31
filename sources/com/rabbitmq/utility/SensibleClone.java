package com.rabbitmq.utility;

import com.rabbitmq.utility.SensibleClone;

public interface SensibleClone<T extends SensibleClone<T>> extends Cloneable {
    T sensibleClone();
}
