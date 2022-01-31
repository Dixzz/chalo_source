package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import com.urbanairship.UAirship;

public class WalletAction extends OpenExternalUrlAction {
    @Override // com.urbanairship.actions.OpenExternalUrlAction, defpackage.nk5
    public boolean a(ok5 ok5) {
        if (UAirship.l().h() != 2) {
            return false;
        }
        return super.a(ok5);
    }

    @Override // com.urbanairship.actions.OpenExternalUrlAction, defpackage.nk5
    public rk5 d(ok5 ok5) {
        yj5.f("Processing Wallet adaptive link.", new Object[0]);
        Intent intent = new Intent(UAirship.d(), WalletLoadingActivity.class);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(ok5.b.d()));
        UAirship.d().startActivity(intent);
        return rk5.a();
    }
}
