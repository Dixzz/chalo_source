package com.rabbitmq.client;

public class AlreadyClosedException extends ShutdownSignalException {
    private static final long serialVersionUID = 1;

    public AlreadyClosedException(ShutdownSignalException shutdownSignalException) {
        this(shutdownSignalException, null);
    }

    private static String composeMessagePrefix(ShutdownSignalException shutdownSignalException) {
        return hj1.S(shutdownSignalException.isHardError() ? "connection " : "channel ", "is already closed due to ");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlreadyClosedException(ShutdownSignalException shutdownSignalException, Throwable th) {
        super(shutdownSignalException.isHardError(), shutdownSignalException.isInitiatedByApplication(), shutdownSignalException.getReason(), shutdownSignalException.getReference(), composeMessagePrefix(shutdownSignalException), th == null ? shutdownSignalException.getCause() : th);
    }
}
