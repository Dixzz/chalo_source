package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.logging.LogWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventRaiser {
    private final EventTarget eventTarget;
    private final LogWrapper logger;

    public EventRaiser(Context context) {
        this.eventTarget = context.getEventTarget();
        this.logger = context.getLogger("EventRaiser");
    }

    public void raiseEvents(List<? extends Event> list) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder i0 = hj1.i0("Raising ");
            i0.append(list.size());
            i0.append(" event(s)");
            logWrapper.debug(i0.toString(), new Object[0]);
        }
        final ArrayList arrayList = new ArrayList(list);
        this.eventTarget.postEvent(new Runnable() {
            /* class com.google.firebase.database.core.view.EventRaiser.AnonymousClass1 */

            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Event event = (Event) it.next();
                    if (EventRaiser.this.logger.logsDebug()) {
                        LogWrapper logWrapper = EventRaiser.this.logger;
                        StringBuilder i0 = hj1.i0("Raising ");
                        i0.append(event.toString());
                        logWrapper.debug(i0.toString(), new Object[0]);
                    }
                    event.fire();
                }
            }
        });
    }
}
