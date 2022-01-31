package defpackage;

import com.google.firebase.messaging.FirebaseMessagingService;
import defpackage.nc5;

/* renamed from: sc5  reason: default package */
/* compiled from: MixpanelFCMMessagingService */
public class sc5 extends FirebaseMessagingService {
    public static final /* synthetic */ int f = 0;

    /* renamed from: sc5$a */
    /* compiled from: MixpanelFCMMessagingService */
    public class a implements nc5.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3203a;

        public a(String str) {
            this.f3203a = str;
        }

        @Override // defpackage.nc5.b
        public void a(nc5 nc5) {
            nc5.e.i(this.f3203a);
        }
    }

    public static void a(String str) {
        nc5.c(new a(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x011f, code lost:
        if (r0 < 0) goto L_0x0121;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0418 A[LOOP:1: B:165:0x040e->B:167:0x0418, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x043e A[LOOP:2: B:168:0x0434->B:170:0x043e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x04a0  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0172 A[SYNTHETIC, Splitter:B:49:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0235  */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage r28) {
        /*
        // Method dump skipped, instructions count: 1318
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sc5.onMessageReceived(com.google.firebase.messaging.RemoteMessage):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        a(str);
    }
}
