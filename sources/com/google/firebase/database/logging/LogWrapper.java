package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogWrapper {
    private final String component;
    private final Logger logger;
    private final String prefix;

    public LogWrapper(Logger logger2, String str) {
        this(logger2, str, null);
    }

    private static String exceptionStacktrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private String toLog(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.prefix == null ? str : hj1.b0(new StringBuilder(), this.prefix, " - ", str);
    }

    public void debug(String str, Object... objArr) {
        debug(str, null, objArr);
    }

    public void error(String str, Throwable th) {
        this.logger.onLogMessage(Logger.Level.ERROR, this.component, toLog(str, new Object[0]) + "\n" + exceptionStacktrace(th), now());
    }

    public void info(String str) {
        this.logger.onLogMessage(Logger.Level.INFO, this.component, toLog(str, new Object[0]), now());
    }

    public boolean logsDebug() {
        int ordinal = this.logger.getLogLevel().ordinal();
        Logger.Level level = Logger.Level.DEBUG;
        return ordinal <= 0;
    }

    public void warn(String str) {
        warn(str, null);
    }

    public LogWrapper(Logger logger2, String str, String str2) {
        this.logger = logger2;
        this.component = str;
        this.prefix = str2;
    }

    public void debug(String str, Throwable th, Object... objArr) {
        if (logsDebug()) {
            String log = toLog(str, objArr);
            if (th != null) {
                StringBuilder k0 = hj1.k0(log, "\n");
                k0.append(exceptionStacktrace(th));
                log = k0.toString();
            }
            this.logger.onLogMessage(Logger.Level.DEBUG, this.component, log, now());
        }
    }

    public void warn(String str, Throwable th) {
        String log = toLog(str, new Object[0]);
        if (th != null) {
            StringBuilder k0 = hj1.k0(log, "\n");
            k0.append(exceptionStacktrace(th));
            log = k0.toString();
        }
        this.logger.onLogMessage(Logger.Level.WARN, this.component, log, now());
    }
}
