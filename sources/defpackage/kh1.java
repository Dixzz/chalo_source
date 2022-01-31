package defpackage;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.rabbitmq.client.StringRpcServer;
import defpackage.yj1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* renamed from: kh1  reason: default package */
/* compiled from: VolleyMultipartRequest */
public class kh1 extends wj1<tj1> {
    public final String u;
    public yj1.b<tj1> v;
    public yj1.a w;

    /* renamed from: kh1$a */
    /* compiled from: VolleyMultipartRequest */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2058a;
        public byte[] b;

        public a(kh1 kh1, String str, byte[] bArr) {
            this.f2058a = str;
            this.b = bArr;
        }
    }

    public kh1(int i, String str, yj1.b<tj1> bVar, yj1.a aVar) {
        super(i, str, aVar);
        StringBuilder i0 = hj1.i0("apiclient-");
        i0.append(System.currentTimeMillis());
        this.u = i0.toString();
        this.v = bVar;
        this.w = aVar;
    }

    @Override // defpackage.wj1
    public yj1<tj1> A(tj1 tj1) {
        try {
            return new yj1<>(tj1, gj1.W(tj1));
        } catch (Exception e) {
            return new yj1<>(new vj1(e));
        }
    }

    public final void D(DataOutputStream dataOutputStream, String str, String str2) throws IOException {
        StringBuilder i0 = hj1.i0("--");
        i0.append(this.u);
        i0.append("\r\n");
        dataOutputStream.writeBytes(i0.toString());
        dataOutputStream.writeBytes("Content-Type: text/plain\r\n");
        dataOutputStream.writeBytes(hj1.c0(new StringBuilder(), "Content-Disposition: form-data; name=\"", str, "\"", "\r\n"));
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes(str2 + "\r\n");
    }

    public final void E(DataOutputStream dataOutputStream, Map<String, a> map) throws IOException {
        for (Map.Entry<String, a> entry : map.entrySet()) {
            a value = entry.getValue();
            StringBuilder i0 = hj1.i0("--");
            i0.append(this.u);
            i0.append("\r\n");
            dataOutputStream.writeBytes(i0.toString());
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"; filename=\"" + value.f2058a + "\"" + "\r\n");
            dataOutputStream.writeBytes("Content-Type: application/octet-stream\r\n");
            dataOutputStream.writeBytes("Content-Transfer-Encoding: binary\r\n");
            dataOutputStream.writeBytes("\r\n");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value.b);
            int min = Math.min(byteArrayInputStream.available(), (int) CommonUtils.BYTES_IN_A_MEGABYTE);
            byte[] bArr = new byte[min];
            int read = byteArrayInputStream.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(byteArrayInputStream.available(), (int) CommonUtils.BYTES_IN_A_MEGABYTE);
                read = byteArrayInputStream.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes("\r\n");
        }
    }

    public Map<String, a> J() throws ij1 {
        throw null;
    }

    public final void K(DataOutputStream dataOutputStream, Map<String, String> map, String str) throws IOException {
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                D(dataOutputStream, entry.getKey(), entry.getValue());
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(hj1.S("Encoding not supported: ", str), e);
        }
    }

    @Override // defpackage.wj1
    public void f(dk1 dk1) {
        this.w.a(dk1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.wj1
    public void g(tj1 tj1) {
        this.v.a(tj1);
    }

    @Override // defpackage.wj1
    public byte[] j() throws ij1 {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            Map<String, String> o = o();
            if (o != null && o.size() > 0) {
                K(dataOutputStream, o, StringRpcServer.STRING_ENCODING);
            }
            Map<String, a> J = J();
            if (J != null && J.size() > 0) {
                E(dataOutputStream, J);
            }
            dataOutputStream.writeBytes("--" + this.u + "--" + "\r\n");
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.wj1
    public String k() {
        StringBuilder i0 = hj1.i0("multipart/form-data;boundary=");
        i0.append(this.u);
        return i0.toString();
    }
}
