package defpackage;

import android.net.Uri;

/* renamed from: ll3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ll3 implements gl3 {

    /* renamed from: a  reason: collision with root package name */
    public static final yf3<Boolean> f2234a;

    static {
        Uri orDefault;
        n2<String, Uri> n2Var = vf3.f3643a;
        synchronized (vf3.class) {
            n2<String, Uri> n2Var2 = vf3.f3643a;
            orDefault = n2Var2.getOrDefault("com.google.android.gms.icing", null);
            if (orDefault == null) {
                String valueOf = String.valueOf(Uri.encode("com.google.android.gms.icing"));
                orDefault = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                n2Var2.put("com.google.android.gms.icing", orDefault);
            }
        }
        cg3 cg3 = new cg3(orDefault);
        cg3.a("block_action_upload_if_data_sharing_disabled", false);
        cg3.a("drop_usage_reports_for_account_mismatch", false);
        cg3.a("enable_additional_type_for_email", true);
        f2234a = cg3.a("enable_client_grant_slice_permission", true);
        cg3.a("enable_custom_action_url_generation", false);
        cg3.a("enable_failure_response_for_apitask_exceptions", false);
        cg3.a("enable_on_device_sharing_control_ui", false);
        cg3.a("enable_safe_app_indexing_package_removal", false);
        cg3.a("enable_slice_authority_validation", false);
        cg3.a("redirect_user_actions_from_persistent_to_main", false);
        cg3.a("type_access_whitelist_enforce_platform_permissions", true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e1  */
    @Override // defpackage.gl3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
        // Method dump skipped, instructions count: 322
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ll3.a():boolean");
    }
}
