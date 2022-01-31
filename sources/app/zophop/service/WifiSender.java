package app.zophop.service;

import android.app.IntentService;
import android.content.Intent;
import app.zophop.pubsub.eventbus.events.WifiMessageSent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WifiSender extends IntentService {
    public WifiSender() {
        super("d");
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onHandleIntent(Intent intent) {
        Throwable th;
        IOException e;
        String stringExtra = intent.getStringExtra("address");
        String stringExtra2 = intent.getStringExtra("data");
        String stringExtra3 = intent.getStringExtra("request_id");
        int intExtra = intent.getIntExtra("port", 3689);
        Socket socket = null;
        try {
            Socket socket2 = new Socket();
            try {
                socket2.bind(null);
                socket2.connect(new InetSocketAddress(stringExtra, intExtra), 5000);
                socket2.isConnected();
                OutputStream outputStream = socket2.getOutputStream();
                outputStream.write(stringExtra2.getBytes());
                outputStream.close();
                jz5.b().i(new WifiMessageSent(stringExtra3, ad1.SUCCESS));
                if (socket2.isConnected()) {
                    try {
                        socket2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                socket = socket2;
                try {
                    e.getMessage();
                    e.printStackTrace();
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                    jz5.b().i(new WifiMessageSent(stringExtra3, ad1.FAILED));
                    if (socket != null && socket.isConnected()) {
                        socket.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    socket2 = socket;
                    try {
                        socket2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (socket2 != null && socket2.isConnected()) {
                    socket2.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.getMessage();
            e.printStackTrace();
            b00 b002 = b00.f358a;
            b00.a().b(e);
            jz5.b().i(new WifiMessageSent(stringExtra3, ad1.FAILED));
            if (socket != null) {
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
