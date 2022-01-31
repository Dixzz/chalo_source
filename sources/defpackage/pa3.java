package defpackage;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* renamed from: pa3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class pa3 implements ObjectEncoder<MessagingClientEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final pa3 f2789a = new pa3();
    public static final FieldDescriptor b = FieldDescriptor.builder("projectNumber").withProperty(new kb3(1, nb3.DEFAULT)).build();
    public static final FieldDescriptor c = FieldDescriptor.builder("messageId").withProperty(new kb3(2, nb3.DEFAULT)).build();
    public static final FieldDescriptor d = FieldDescriptor.builder("instanceId").withProperty(new kb3(3, nb3.DEFAULT)).build();
    public static final FieldDescriptor e = FieldDescriptor.builder("messageType").withProperty(new kb3(4, nb3.DEFAULT)).build();
    public static final FieldDescriptor f = FieldDescriptor.builder("sdkPlatform").withProperty(new kb3(5, nb3.DEFAULT)).build();
    public static final FieldDescriptor g = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME).withProperty(new kb3(6, nb3.DEFAULT)).build();
    public static final FieldDescriptor h = FieldDescriptor.builder("collapseKey").withProperty(new kb3(7, nb3.DEFAULT)).build();
    public static final FieldDescriptor i = FieldDescriptor.builder("priority").withProperty(new kb3(8, nb3.DEFAULT)).build();
    public static final FieldDescriptor j = FieldDescriptor.builder("ttl").withProperty(new kb3(9, nb3.DEFAULT)).build();
    public static final FieldDescriptor k = FieldDescriptor.builder("topic").withProperty(new kb3(10, nb3.DEFAULT)).build();
    public static final FieldDescriptor l = FieldDescriptor.builder("bulkId").withProperty(new kb3(11, nb3.DEFAULT)).build();
    public static final FieldDescriptor m = FieldDescriptor.builder("event").withProperty(new kb3(12, nb3.DEFAULT)).build();
    public static final FieldDescriptor n = FieldDescriptor.builder("analyticsLabel").withProperty(new kb3(13, nb3.DEFAULT)).build();
    public static final FieldDescriptor o = FieldDescriptor.builder("campaignId").withProperty(new kb3(14, nb3.DEFAULT)).build();
    public static final FieldDescriptor p = FieldDescriptor.builder("composerLabel").withProperty(new kb3(15, nb3.DEFAULT)).build();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(b, messagingClientEvent.getProjectNumber());
        objectEncoderContext2.add(c, messagingClientEvent.getMessageId());
        objectEncoderContext2.add(d, messagingClientEvent.getInstanceId());
        objectEncoderContext2.add(e, messagingClientEvent.getMessageType());
        objectEncoderContext2.add(f, messagingClientEvent.getSdkPlatform());
        objectEncoderContext2.add(g, messagingClientEvent.getPackageName());
        objectEncoderContext2.add(h, messagingClientEvent.getCollapseKey());
        objectEncoderContext2.add(i, messagingClientEvent.getPriority());
        objectEncoderContext2.add(j, messagingClientEvent.getTtl());
        objectEncoderContext2.add(k, messagingClientEvent.getTopic());
        objectEncoderContext2.add(l, messagingClientEvent.getBulkId());
        objectEncoderContext2.add(m, messagingClientEvent.getEvent());
        objectEncoderContext2.add(n, messagingClientEvent.getAnalyticsLabel());
        objectEncoderContext2.add(o, messagingClientEvent.getCampaignId());
        objectEncoderContext2.add(p, messagingClientEvent.getComposerLabel());
    }
}
