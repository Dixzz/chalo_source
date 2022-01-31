package com.freshchat.consumer.sdk.e;

import android.content.Context;
import com.google.firebase.perf.FirebasePerformance;
import com.rabbitmq.client.StringRpcServer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;

public class e {
    private String charset;
    private final String eF;
    private HttpURLConnection eG;
    private OutputStream eH;
    private PrintWriter eI;

    public e(Context context, String str) throws IOException {
        this(context, str, FirebasePerformance.HttpMethod.POST);
    }

    public e(Context context, String str, String str2) throws IOException {
        this.charset = StringRpcServer.STRING_ENCODING;
        StringBuilder i0 = hj1.i0("***");
        i0.append(System.currentTimeMillis());
        i0.append("***");
        String sb = i0.toString();
        this.eF = sb;
        HttpURLConnection a2 = new c(context).a(str, str2, c.ah(hj1.S("multipart/form-data; boundary=", sb)));
        this.eG = a2;
        this.eH = a2.getOutputStream();
        this.eI = new PrintWriter((Writer) new OutputStreamWriter(this.eH, this.charset), true);
    }

    public void a(String str, File file) throws IOException {
        a(str, file.getName(), new FileInputStream(file), null);
    }

    public void a(String str, String str2, InputStream inputStream, String str3) throws IOException {
        if (inputStream != null) {
            PrintWriter printWriter = this.eI;
            StringBuilder i0 = hj1.i0("--");
            i0.append(this.eF);
            printWriter.append((CharSequence) i0.toString()).append((CharSequence) "\r\n");
            PrintWriter printWriter2 = this.eI;
            printWriter2.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
            this.eI.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
            if (str3 != null) {
                PrintWriter printWriter3 = this.eI;
                printWriter3.append((CharSequence) ("Content-Type: " + str3)).append((CharSequence) "\r\n");
            }
            this.eI.append((CharSequence) "\r\n");
            this.eI.flush();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    this.eH.write(bArr, 0, read);
                } else {
                    this.eH.flush();
                    inputStream.close();
                    this.eI.append((CharSequence) "\r\n");
                    this.eI.flush();
                    return;
                }
            }
        }
    }

    public d dc() {
        try {
            this.eI.append((CharSequence) "\r\n").flush();
            PrintWriter printWriter = this.eI;
            printWriter.append((CharSequence) ("--" + this.eF + "--")).append((CharSequence) "\r\n");
            this.eI.close();
            InputStream a2 = c.a(this.eG);
            d dVar = new d();
            dVar.setInputStream(a2);
            dVar.setStatusCode(this.eG.getResponseCode());
            return dVar;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void f(String str, String str2) {
        PrintWriter printWriter = this.eI;
        StringBuilder i0 = hj1.i0("--");
        i0.append(this.eF);
        printWriter.append((CharSequence) i0.toString()).append((CharSequence) "\r\n");
        PrintWriter printWriter2 = this.eI;
        printWriter2.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"")).append((CharSequence) "\r\n");
        PrintWriter printWriter3 = this.eI;
        StringBuilder i02 = hj1.i0("Content-Type: text/plain; charset=");
        i02.append(this.charset);
        printWriter3.append((CharSequence) i02.toString()).append((CharSequence) "\r\n");
        this.eI.append((CharSequence) "\r\n");
        this.eI.append((CharSequence) str2).append((CharSequence) "\r\n");
        this.eI.flush();
    }
}
