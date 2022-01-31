package com.rabbitmq.tools;

import com.rabbitmq.client.impl.AMQCommand;
import com.rabbitmq.client.impl.AMQContentHeader;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.client.impl.Frame;
import com.rabbitmq.utility.BlockingCell;
import com.rabbitmq.utility.Utility;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Tracer implements Runnable {
    private static final String DEFAULT_CONNECT_HOST = "localhost";
    private static final int DEFAULT_CONNECT_PORT = 5672;
    private static final int DEFAULT_LISTEN_PORT = 5673;
    private static final String PROP_PREFIX = "com.rabbitmq.tools.Tracer.";
    private final String idLabel;
    private final DataInputStream iis;
    private final Socket inSock;
    private final DataOutputStream ios;
    private final Logger logger;
    private final DataInputStream ois;
    private final DataOutputStream oos;
    private final Socket outSock;
    private final Properties props;
    private final BlockingCell<Exception> reportEnd;
    private final AtomicBoolean started;

    public static class AsyncLogger implements Logger {
        private static final int BUFFER_SIZE = 10485760;
        private static final int LOG_QUEUE_SIZE = 1048576;
        private static final int MIN_FLUSH_INTERVAL = 100;
        private static final int ONE_SECOND_INTERVAL = 1000;
        private final SafeCounter countStarted;
        private final Runnable loggerRunnable;
        private volatile Thread loggerThread;
        private final BlockingQueue<Pr<String, LogCmd>> queue;

        public class AsyncLoggerRunnable implements Runnable {
            private final int flushInterval;
            private final PrintStream ps;
            private final BlockingQueue<Pr<String, LogCmd>> queue;

            public AsyncLoggerRunnable(PrintStream printStream, int i, BlockingQueue<Pr<String, LogCmd>> blockingQueue) {
                this.flushInterval = i;
                this.ps = printStream;
                this.queue = blockingQueue;
            }

            private void drainCurrentQueue() {
                int size = this.queue.size();
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        Pr<String, LogCmd> poll = this.queue.poll();
                        if (!(poll == null || poll.left() == null)) {
                            this.ps.println(poll.left());
                        }
                        size = i;
                    } else {
                        return;
                    }
                }
            }

            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis() + ((long) this.flushInterval);
                    boolean z = false;
                    while (true) {
                        long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                        if (0 >= currentTimeMillis2) {
                            if (z) {
                                this.ps.flush();
                                z = false;
                            }
                            currentTimeMillis += (long) this.flushInterval;
                        } else {
                            Pr<String, LogCmd> poll = this.queue.poll(currentTimeMillis2, TimeUnit.MILLISECONDS);
                            if (poll == null) {
                                continue;
                            } else {
                                if (poll.left() != null) {
                                    this.ps.println(poll.left());
                                    z = true;
                                }
                                if (poll.right() == LogCmd.STOP) {
                                    drainCurrentQueue();
                                    this.ps.println("Stopped.");
                                    this.ps.flush();
                                    return;
                                }
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                    AsyncLogger.this.countStarted.reset();
                    drainCurrentQueue();
                    this.ps.println("Interrupted.");
                    this.ps.flush();
                }
            }
        }

        public enum LogCmd {
            STOP,
            PRINT
        }

        public static class Pr<L, R> {
            private final L left;
            private final R right;

            public Pr(L l, R r) {
                this.left = l;
                this.right = r;
            }

            public L left() {
                return this.left;
            }

            public R right() {
                return this.right;
            }
        }

        public AsyncLogger(OutputStream outputStream) {
            this(outputStream, 1000);
        }

        @Override // com.rabbitmq.tools.Tracer.Logger
        public void log(String str) {
            if (str != null) {
                try {
                    this.queue.put(new Pr<>(str, LogCmd.PRINT));
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted while logging.", e);
                }
            }
        }

        @Override // com.rabbitmq.tools.Tracer.Logger
        public boolean start() {
            if (!this.countStarted.testZeroAndIncrement()) {
                return false;
            }
            this.loggerThread = new Thread(this.loggerRunnable);
            this.loggerThread.start();
            return true;
        }

        @Override // com.rabbitmq.tools.Tracer.Logger
        public boolean stop() {
            if (!this.countStarted.decrementAndTestZero()) {
                return false;
            }
            if (this.loggerThread == null) {
                return true;
            }
            try {
                this.queue.put(new Pr<>(null, LogCmd.STOP));
                this.loggerThread = null;
                return true;
            } catch (InterruptedException e) {
                this.loggerThread.interrupt();
                throw new RuntimeException("Interrupted while stopping.", e);
            }
        }

        public AsyncLogger(OutputStream outputStream, int i) {
            this.loggerThread = null;
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1048576, true);
            this.queue = arrayBlockingQueue;
            if (i >= 100) {
                this.countStarted = new SafeCounter();
                this.loggerRunnable = new AsyncLoggerRunnable(new PrintStream((OutputStream) new BufferedOutputStream(outputStream, BUFFER_SIZE), false), i, arrayBlockingQueue);
                return;
            }
            throw new IllegalArgumentException("Flush interval (" + i + "ms) must be positive and at least " + 100 + "ms.");
        }
    }

    public class DirectionHandler implements Runnable {
        private final Map<Integer, AMQCommand> commands;
        private final String directionIndicator;
        private final DataInputStream inStream;
        private final boolean noAssembleFrames;
        private final boolean noDecodeFrames;
        private final DataOutputStream outStream;
        private final boolean silentMode;
        private final boolean suppressCommandBodies;
        private final BlockingCell<Exception> waitCell;
        private final boolean writeHeartBeats;

        public DirectionHandler(BlockingCell<Exception> blockingCell, boolean z, DataInputStream dataInputStream, DataOutputStream dataOutputStream, Properties properties) {
            this.waitCell = blockingCell;
            this.silentMode = Tracer.getBoolProperty("SILENT_MODE", properties);
            this.noDecodeFrames = Tracer.getBoolProperty("NO_DECODE_FRAMES", properties);
            this.noAssembleFrames = Tracer.getBoolProperty("NO_ASSEMBLE_FRAMES", properties);
            this.suppressCommandBodies = Tracer.getBoolProperty("SUPPRESS_COMMAND_BODIES", properties);
            this.writeHeartBeats = (z && !Tracer.getBoolProperty("WITHHOLD_INBOUND_HEARTBEATS", properties)) || (!z && !Tracer.getBoolProperty("WITHHOLD_OUTBOUND_HEARTBEATS", properties));
            this.directionIndicator = z ? " -> " : " <- ";
            this.inStream = dataInputStream;
            this.outStream = dataOutputStream;
            this.commands = new HashMap();
        }

        private void doFrame() throws IOException {
            Frame readFrame = readFrame();
            if (readFrame == null) {
                return;
            }
            if (this.silentMode) {
                readFrame.writeTo(this.outStream);
            } else if (readFrame.type != 8) {
                readFrame.writeTo(this.outStream);
                if (this.noDecodeFrames) {
                    report(readFrame.channel, readFrame);
                } else if (this.noAssembleFrames) {
                    reportFrame(readFrame);
                } else {
                    AMQCommand aMQCommand = this.commands.get(Integer.valueOf(readFrame.channel));
                    if (aMQCommand == null) {
                        aMQCommand = new AMQCommand();
                        this.commands.put(Integer.valueOf(readFrame.channel), aMQCommand);
                    }
                    if (aMQCommand.handleFrame(readFrame)) {
                        report(readFrame.channel, aMQCommand.toString(this.suppressCommandBodies));
                        this.commands.remove(Integer.valueOf(readFrame.channel));
                    }
                }
            } else if (this.writeHeartBeats) {
                readFrame.writeTo(this.outStream);
                report(readFrame.channel, readFrame);
            } else {
                int i = readFrame.channel;
                StringBuilder i0 = hj1.i0("(withheld) ");
                i0.append(readFrame.toString());
                report(i, i0.toString());
            }
        }

        private Frame readFrame() throws IOException {
            return Frame.readFrom(this.inStream);
        }

        private void report(int i, Object obj) {
            Tracer.this.log("ch#" + i + this.directionIndicator + obj);
        }

        private void reportFrame(Frame frame) throws IOException {
            int i = frame.type;
            if (i == 1) {
                report(frame.channel, AMQImpl.readMethodFrom(frame.getInputStream()));
            } else if (i != 2) {
                report(frame.channel, frame);
            } else {
                AMQContentHeader readContentHeaderFrom = AMQImpl.readContentHeaderFrom(frame.getInputStream());
                long bodySize = readContentHeaderFrom.getBodySize();
                StringBuilder sb = new StringBuilder("Expected body size: ");
                sb.append(bodySize);
                sb.append("; ");
                sb.append(readContentHeaderFrom);
                report(frame.channel, sb);
            }
        }

        public void run() {
            while (true) {
                Exception e = null;
                try {
                    doFrame();
                } catch (Exception e2) {
                    return;
                } finally {
                    this.waitCell.setIfUnset(e2);
                }
            }
        }
    }

    public interface Logger {
        void log(String str);

        boolean start();

        boolean stop();
    }

    public static class SafeCounter {
        private int count = 0;
        private final Object countMonitor = new Object();

        public boolean decrementAndTestZero() {
            synchronized (this.countMonitor) {
                int i = this.count;
                boolean z = false;
                if (i == 0) {
                    return false;
                }
                int i2 = i - 1;
                this.count = i2;
                if (i2 == 0) {
                    z = true;
                }
                return z;
            }
        }

        public void reset() {
            synchronized (this.countMonitor) {
                this.count = 0;
            }
        }

        public boolean testZeroAndIncrement() {
            boolean z;
            synchronized (this.countMonitor) {
                int i = this.count;
                this.count = i + 1;
                z = i == 0;
            }
            return z;
        }
    }

    private Tracer(Socket socket, String str, String str2, int i, Logger logger2, BlockingCell<Exception> blockingCell, Properties properties) throws IOException {
        this.props = properties;
        this.inSock = socket;
        Socket socket2 = new Socket(str2, i);
        this.outSock = socket2;
        this.idLabel = hj1.T(": <", str, "> ");
        this.iis = new DataInputStream(socket.getInputStream());
        this.ios = new DataOutputStream(socket.getOutputStream());
        this.ois = new DataInputStream(socket2.getInputStream());
        this.oos = new DataOutputStream(socket2.getOutputStream());
        this.logger = logger2;
        this.reportEnd = blockingCell;
        this.started = new AtomicBoolean(false);
    }

    /* access modifiers changed from: private */
    public static boolean getBoolProperty(String str, Properties properties) {
        return Boolean.parseBoolean(properties.getProperty(PROP_PREFIX + str));
    }

    public static void main(String[] strArr) {
        int i = 0;
        int parseInt = strArr.length > 0 ? Integer.parseInt(strArr[0]) : DEFAULT_LISTEN_PORT;
        String str = strArr.length > 1 ? strArr[1] : "localhost";
        int parseInt2 = strArr.length > 2 ? Integer.parseInt(strArr[2]) : 5672;
        System.out.println("Usage: Tracer [<listenport> [<connecthost> [<connectport>]]]");
        System.out.println("   Serially traces connections on the <listenport>, logging\n   frames received and passing them to the connect host and port.");
        PrintStream printStream = System.out;
        printStream.println("Invoked as: Tracer " + parseInt + " " + str + " " + parseInt2);
        Properties properties = System.getProperties();
        printBoolProperty("WITHHOLD_INBOUND_HEARTBEATS", properties);
        printBoolProperty("WITHHOLD_OUTBOUND_HEARTBEATS", properties);
        printBoolProperty("NO_ASSEMBLE_FRAMES", properties);
        printBoolProperty("NO_DECODE_FRAMES", properties);
        printBoolProperty("SUPPRESS_COMMAND_BODIES", properties);
        AsyncLogger asyncLogger = new AsyncLogger(System.out);
        try {
            while (true) {
                Socket accept = new ServerSocket(parseInt).accept();
                StringBuilder sb = new StringBuilder();
                sb.append("Tracer-");
                int i2 = i + 1;
                sb.append(i);
                new Tracer(accept, sb.toString(), str, parseInt2, asyncLogger).start();
                i = i2;
            }
        } catch (Exception e) {
            asyncLogger.stop();
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void printBoolProperty(String str, Properties properties) {
        StringBuilder sb = new StringBuilder(100);
        PrintStream printStream = System.out;
        sb.append(PROP_PREFIX);
        sb.append(str);
        sb.append(" = ");
        sb.append(getBoolProperty(str, properties));
        printStream.println(sb.toString());
    }

    private void reportAndLogNonNullException(Exception exc) {
        if (exc != null) {
            this.reportEnd.setIfUnset(exc);
            logException(exc);
        }
    }

    private void waitAndLogException(BlockingCell<Exception> blockingCell) throws InterruptedException {
        reportAndLogNonNullException(blockingCell.get());
    }

    public void log(String str) {
        StringBuilder sb = new StringBuilder();
        Logger logger2 = this.logger;
        sb.append(System.currentTimeMillis());
        sb.append(this.idLabel);
        sb.append(str);
        logger2.log(sb.toString());
    }

    public void logException(Exception exc) {
        StringBuilder i0 = hj1.i0("uncaught ");
        i0.append(Utility.makeStackTrace(exc));
        log(i0.toString());
    }

    public void run() {
        Exception e;
        try {
            byte[] bArr = new byte[8];
            this.iis.readFully(bArr);
            this.oos.write(bArr);
            BlockingCell<Exception> blockingCell = new BlockingCell<>();
            new Thread(new DirectionHandler(blockingCell, true, this.iis, this.oos, this.props)).start();
            new Thread(new DirectionHandler(blockingCell, false, this.ois, this.ios, this.props)).start();
            waitAndLogException(blockingCell);
            try {
                this.inSock.close();
            } catch (Exception e2) {
                logException(e2);
            }
            try {
                this.outSock.close();
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            reportAndLogNonNullException(e4);
            try {
                this.inSock.close();
            } catch (Exception e5) {
                logException(e5);
            }
            try {
                this.outSock.close();
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th) {
            try {
                this.inSock.close();
            } catch (Exception e7) {
                logException(e7);
            }
            try {
                this.outSock.close();
            } catch (Exception e8) {
                logException(e8);
            }
            this.reportEnd.setIfUnset(null);
            this.logger.stop();
            throw th;
        }
        this.reportEnd.setIfUnset(null);
        this.logger.stop();
        logException(e);
        this.reportEnd.setIfUnset(null);
        this.logger.stop();
    }

    public void start() {
        if (this.started.compareAndSet(false, true)) {
            this.logger.start();
            new Thread(this).start();
        }
    }

    private Tracer(Socket socket, String str, String str2, int i, Logger logger2) throws IOException {
        this(socket, str, str2, i, logger2, new BlockingCell(), System.getProperties());
    }

    private Tracer(int i, String str, String str2, int i2, Logger logger2, BlockingCell<Exception> blockingCell, Properties properties) throws IOException {
        this(new ServerSocket(i).accept(), str, str2, i2, logger2, blockingCell, properties);
    }

    public Tracer(int i, String str, String str2, int i2, Logger logger2, Properties properties) throws IOException {
        this(i, str, str2, i2, logger2, new BlockingCell(), properties);
    }

    public Tracer(String str) throws IOException {
        this((int) DEFAULT_LISTEN_PORT, str, "localhost", 5672, new AsyncLogger(System.out), new BlockingCell(), System.getProperties());
    }

    public Tracer(String str, Properties properties) throws IOException {
        this((int) DEFAULT_LISTEN_PORT, str, "localhost", 5672, new AsyncLogger(System.out), new BlockingCell(), properties);
    }
}
