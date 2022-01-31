package defpackage;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* renamed from: zb5  reason: default package */
/* compiled from: Charsetfunctions */
public class zb5 {

    /* renamed from: a  reason: collision with root package name */
    public static CodingErrorAction f4153a = CodingErrorAction.REPORT;

    public static String a(ByteBuffer byteBuffer) throws hb5 {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(f4153a);
        newDecoder.onUnmappableCharacter(f4153a);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e) {
            throw new hb5(1007, e);
        }
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
