package server.zophop.models;

import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.json.JSONObject;
import server.zophop.Constants;

public class SimpleLogger {
    private static Logger _logger;

    static {
        init();
    }

    public static void config(String str) {
        _logger.config(str);
    }

    public static void debug(String str) {
        _logger.fine(str);
    }

    public static void info(String str) {
        _logger.info(str);
    }

    public static void init() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Constants.LOGGER_HANDLE);
        consoleHandler.setFormatter(new Formatter());
        Logger logger = LogManager.getLogManager().getLogger("global");
        _logger = logger;
        logger.setUseParentHandlers(false);
        _logger.setLevel(Constants.LOGGER_LEVEL);
        _logger.addHandler(consoleHandler);
    }

    public static void log(JSONObject jSONObject) {
        PrintStream printStream = System.out;
        printStream.println(jSONObject + "\n");
    }

    public static void logException(Throwable th) {
        System.out.println(th.getMessage());
        th.printStackTrace();
    }

    public static void setLevel(Level level) {
        _logger.setLevel(level);
    }

    public static void severe(String str) {
        _logger.severe(str);
    }

    public static void warning(String str) {
        _logger.warning(str);
    }
}
