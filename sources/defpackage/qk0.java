package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.products.ProductSelectionActivity;
import com.google.gson.Gson;

/* renamed from: qk0  reason: default package */
/* compiled from: TripDetailsAdapter */
public class qk0 implements View.OnClickListener {
    public final /* synthetic */ Route f;
    public final /* synthetic */ Stop g;
    public final /* synthetic */ Stop h;
    public final /* synthetic */ ok0 i;

    public qk0(ok0 ok0, Route route, Stop stop, Stop stop2) {
        this.i = ok0;
        this.f = route;
        this.g = stop;
        this.h = stop2;
    }

    public void onClick(View view) {
        Gson gson = new Gson();
        Intent intent = new Intent(this.i.f, ProductSelectionActivity.class);
        intent.putExtra("src", this.i.g);
        intent.putExtra("route_extra", gson.toJson(this.f));
        intent.putExtra("from_stop_extra", gson.toJson(this.g));
        intent.putExtra("to_stop_extra", gson.toJson(this.h));
        this.i.f.startActivity(intent);
    }
}
