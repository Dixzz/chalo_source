package com.rabbitmq.utility;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Utility {

    public static class ThrowableCreatedElsewhere extends Throwable {
        private static final long serialVersionUID = 1;

        public ThrowableCreatedElsewhere(Throwable th) {
            super(th.getClass() + " created elsewhere");
            setStackTrace(th.getStackTrace());
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T extends Throwable & SensibleClone<T>> T fixStackTrace(T t) {
        T t2 = (T) ((Throwable) ((SensibleClone) t).sensibleClone());
        if (t2.getCause() == null) {
            try {
                t2.initCause(new ThrowableCreatedElsewhere(t2));
            } catch (IllegalStateException unused) {
            }
        }
        t2.fillInStackTrace();
        StackTraceElement[] stackTrace = t2.getStackTrace();
        int length = stackTrace.length - 1;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[length];
        System.arraycopy(stackTrace, 1, stackTraceElementArr, 0, length);
        t2.setStackTrace(stackTraceElementArr);
        return t2;
    }

    public static String makeStackTrace(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream((OutputStream) byteArrayOutputStream, false);
        th.printStackTrace(printStream);
        printStream.flush();
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        printStream.close();
        return byteArrayOutputStream2;
    }
}
