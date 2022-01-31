package com.google.firebase.database.tubesock;

import android.util.Base64;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.perf.util.Constants;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WebSocketHandshake {
    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders = null;
    private String nonce = null;
    private String protocol = null;
    private URI url = null;

    public WebSocketHandshake(URI uri, String str, Map<String, String> map) {
        this.url = uri;
        this.protocol = str;
        this.extraHeaders = map;
        this.nonce = createNonce();
    }

    private String createNonce() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) rand(0, Constants.MAX_HOST_LENGTH);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String generateHeader(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            str = hj1.a0(hj1.l0(str, str2, ": "), linkedHashMap.get(str2), "\r\n");
        }
        return str;
    }

    private int rand(int i, int i2) {
        return (int) ((Math.random() * ((double) i2)) + ((double) i));
    }

    public byte[] getHandshake() {
        String path = this.url.getPath();
        String query = this.url.getQuery();
        StringBuilder i0 = hj1.i0(path);
        i0.append(query == null ? "" : hj1.S("?", query));
        String sb = i0.toString();
        String host = this.url.getHost();
        if (this.url.getPort() != -1) {
            StringBuilder k0 = hj1.k0(host, ProductDiscountsObject.KEY_DELIMITER);
            k0.append(this.url.getPort());
            host = k0.toString();
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", WEBSOCKET_VERSION);
        linkedHashMap.put("Sec-WebSocket-Key", this.nonce);
        String str = this.protocol;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map<String, String> map = this.extraHeaders;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, this.extraHeaders.get(str2));
                }
            }
        }
        StringBuilder i02 = hj1.i0(hj1.T("GET ", sb, " HTTP/1.1\r\n"));
        i02.append(generateHeader(linkedHashMap));
        byte[] bytes = hj1.S(i02.toString(), "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> hashMap) {
        if (!"websocket".equals(hashMap.get("upgrade"))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
        } else if (!"upgrade".equals(hashMap.get("connection"))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
        }
    }

    public void verifyServerStatusLine(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 12));
        if (parseInt == 407) {
            throw new WebSocketException("connection failed: proxy authentication not supported");
        } else if (parseInt == 404) {
            throw new WebSocketException("connection failed: 404 not found");
        } else if (parseInt != 101) {
            throw new WebSocketException(hj1.I("connection failed: unknown status code ", parseInt));
        }
    }
}
