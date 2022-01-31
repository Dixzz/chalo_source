package defpackage;

/* renamed from: lk6  reason: default package */
/* compiled from: ErrorCode.kt */
public enum lk6 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    
    public static final a Companion = new a(null);
    private final int httpCode;

    /* renamed from: lk6$a */
    /* compiled from: ErrorCode.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final lk6 a(int i) {
            lk6[] values = lk6.values();
            for (int i2 = 0; i2 < 14; i2++) {
                lk6 lk6 = values[i2];
                if (lk6.getHttpCode() == i) {
                    return lk6;
                }
            }
            return null;
        }
    }

    private lk6(int i) {
        this.httpCode = i;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
