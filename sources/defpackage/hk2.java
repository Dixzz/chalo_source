package defpackage;

import defpackage.ug2;

/* renamed from: hk2  reason: default package */
public final class hk2 extends ug2<hk2, a> implements bi2 {
    private static final hk2 zzbfc;
    private static volatile ii2<hk2> zzbg;
    private int zzbb;
    private int zzbfa = -1;
    private int zzbfb;

    /* renamed from: hk2$a */
    public static final class a extends ug2.a<hk2, a> implements bi2 {
        public a(jk2 jk2) {
            super(hk2.zzbfc);
        }
    }

    /* renamed from: hk2$b */
    public enum b implements xg2 {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        private static final yg2<b> zzbq = new kk2();
        private final int value;

        private b(int i) {
            this.value = i;
        }

        public static b zzaz(int i) {
            if (i == 100) {
                return COMBINED;
            }
            switch (i) {
                case 0:
                    return UNKNOWN_MOBILE_SUBTYPE;
                case 1:
                    return GPRS;
                case 2:
                    return EDGE;
                case 3:
                    return UMTS;
                case 4:
                    return CDMA;
                case 5:
                    return EVDO_0;
                case 6:
                    return EVDO_A;
                case 7:
                    return RTT;
                case 8:
                    return HSDPA;
                case 9:
                    return HSUPA;
                case 10:
                    return HSPA;
                case 11:
                    return IDEN;
                case 12:
                    return EVDO_B;
                case 13:
                    return LTE;
                case 14:
                    return EHRPD;
                case 15:
                    return HSPAP;
                case 16:
                    return GSM;
                case 17:
                    return TD_SCDMA;
                case 18:
                    return IWLAN;
                case 19:
                    return LTE_CA;
                default:
                    return null;
            }
        }

        public static yg2<b> zzd() {
            return zzbq;
        }

        @Override // defpackage.xg2
        public final int zzc() {
            return this.value;
        }
    }

    /* renamed from: hk2$c */
    public enum c implements xg2 {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        private static final yg2<c> zzbq = new lk2();
        private final int value;

        private c(int i) {
            this.value = i;
        }

        public static c zzba(int i) {
            switch (i) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static yg2<c> zzd() {
            return zzbq;
        }

        @Override // defpackage.xg2
        public final int zzc() {
            return this.value;
        }
    }

    static {
        hk2 hk2 = new hk2();
        zzbfc = hk2;
        ug2.k(hk2.class, hk2);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [ii2<hk2>, ug2$b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.ug2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hk2.i(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
