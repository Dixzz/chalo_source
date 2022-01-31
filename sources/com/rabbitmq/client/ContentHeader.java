package com.rabbitmq.client;

public interface ContentHeader extends Cloneable {
    void appendPropertyDebugStringTo(StringBuilder sb);

    int getClassId();

    String getClassName();
}
