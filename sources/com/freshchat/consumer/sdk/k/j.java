package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.a.l;
import java.util.ArrayList;
import java.util.List;

public class j extends a {
    private int calendarType;
    private List<l.b> qa;

    public j(Context context) {
        super(context);
    }

    public void H(List<l.b> list) {
        this.qa = list;
    }

    public int getCalendarType() {
        return this.calendarType;
    }

    public List<l.b> hY() {
        List<l.b> list = this.qa;
        return list == null ? new ArrayList() : list;
    }

    public void setCalendarType(int i) {
        this.calendarType = i;
    }
}
