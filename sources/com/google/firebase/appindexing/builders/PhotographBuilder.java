package com.google.firebase.appindexing.builders;

import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class PhotographBuilder extends IndexableBuilder<PhotographBuilder> {
    public PhotographBuilder() {
        super("Photograph");
    }

    public final PhotographBuilder setDateCreated(Date date) {
        return (PhotographBuilder) put("dateCreated", date.getTime());
    }

    public final PhotographBuilder setLocationCreated(PlaceBuilder placeBuilder) {
        return (PhotographBuilder) put("locationCreated", placeBuilder);
    }
}
