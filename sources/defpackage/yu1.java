package defpackage;

import android.util.SparseArray;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: yu1  reason: default package */
/* compiled from: NetworkConnectionInfo */
public abstract class yu1 {

    /* renamed from: yu1$a */
    /* compiled from: NetworkConnectionInfo */
    public enum a {
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
        
        private static final SparseArray<a> valueMap;
        private final int value;

        /* access modifiers changed from: public */
        static {
            a aVar;
            a aVar2;
            a aVar3;
            a aVar4;
            a aVar5;
            a aVar6;
            a aVar7;
            a aVar8;
            a aVar9;
            a aVar10;
            a aVar11;
            a aVar12;
            a aVar13;
            a aVar14;
            a aVar15;
            a aVar16;
            a aVar17;
            a aVar18;
            a aVar19;
            a aVar20;
            SparseArray<a> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, aVar);
            sparseArray.put(1, aVar2);
            sparseArray.put(2, aVar3);
            sparseArray.put(3, aVar4);
            sparseArray.put(4, aVar5);
            sparseArray.put(5, aVar6);
            sparseArray.put(6, aVar7);
            sparseArray.put(7, aVar8);
            sparseArray.put(8, aVar9);
            sparseArray.put(9, aVar10);
            sparseArray.put(10, aVar11);
            sparseArray.put(11, aVar12);
            sparseArray.put(12, aVar13);
            sparseArray.put(13, aVar14);
            sparseArray.put(14, aVar15);
            sparseArray.put(15, aVar16);
            sparseArray.put(16, aVar17);
            sparseArray.put(17, aVar18);
            sparseArray.put(18, aVar19);
            sparseArray.put(19, aVar20);
        }

        private a(int i) {
            this.value = i;
        }

        public static a forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }

    /* renamed from: yu1$b */
    /* compiled from: NetworkConnectionInfo */
    public enum b {
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
        VPN(17),
        NONE(-1);
        
        private static final SparseArray<b> valueMap;
        private final int value;

        /* access modifiers changed from: public */
        static {
            b bVar;
            b bVar2;
            b bVar3;
            b bVar4;
            b bVar5;
            b bVar6;
            b bVar7;
            b bVar8;
            b bVar9;
            b bVar10;
            b bVar11;
            b bVar12;
            b bVar13;
            b bVar14;
            b bVar15;
            b bVar16;
            b bVar17;
            b bVar18;
            b bVar19;
            SparseArray<b> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(1, bVar2);
            sparseArray.put(2, bVar3);
            sparseArray.put(3, bVar4);
            sparseArray.put(4, bVar5);
            sparseArray.put(5, bVar6);
            sparseArray.put(6, bVar7);
            sparseArray.put(7, bVar8);
            sparseArray.put(8, bVar9);
            sparseArray.put(9, bVar10);
            sparseArray.put(10, bVar11);
            sparseArray.put(11, bVar12);
            sparseArray.put(12, bVar13);
            sparseArray.put(13, bVar14);
            sparseArray.put(14, bVar15);
            sparseArray.put(15, bVar16);
            sparseArray.put(16, bVar17);
            sparseArray.put(17, bVar18);
            sparseArray.put(-1, bVar19);
        }

        private b(int i) {
            this.value = i;
        }

        public static b forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }

    public abstract a a();

    public abstract b b();
}
