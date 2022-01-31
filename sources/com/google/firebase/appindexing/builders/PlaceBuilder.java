package com.google.firebase.appindexing.builders;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class PlaceBuilder extends IndexableBuilder<PlaceBuilder> {
    public PlaceBuilder() {
        super("Place");
    }

    public final PlaceBuilder setGeo(GeoShapeBuilder geoShapeBuilder) {
        return (PlaceBuilder) put("geo", geoShapeBuilder);
    }
}
