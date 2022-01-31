package com.rabbitmq.client;

import java.io.IOException;

public class UnknownClassOrMethodId extends IOException {
    private static final int NO_METHOD_ID = -1;
    private static final long serialVersionUID = 1;
    public final int classId;
    public final int methodId;

    public UnknownClassOrMethodId(int i) {
        this(i, -1);
    }

    public String toString() {
        if (this.methodId == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("<");
            return hj1.X(sb, this.classId, ">");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("<");
        sb2.append(this.classId);
        sb2.append(".");
        return hj1.X(sb2, this.methodId, ">");
    }

    public UnknownClassOrMethodId(int i, int i2) {
        this.classId = i;
        this.methodId = i2;
    }
}
