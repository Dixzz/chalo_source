package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

public abstract class Operation {
    public final Path path;
    public final OperationSource source;
    public final OperationType type;

    public enum OperationType {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    public Operation(OperationType operationType, OperationSource operationSource, Path path2) {
        this.type = operationType;
        this.source = operationSource;
        this.path = path2;
    }

    public Path getPath() {
        return this.path;
    }

    public OperationSource getSource() {
        return this.source;
    }

    public OperationType getType() {
        return this.type;
    }

    public abstract Operation operationForChild(ChildKey childKey);
}
