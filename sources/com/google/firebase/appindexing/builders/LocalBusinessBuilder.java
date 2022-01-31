package com.google.firebase.appindexing.builders;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class LocalBusinessBuilder extends IndexableBuilder<LocalBusinessBuilder> {
    public LocalBusinessBuilder() {
        super("LocalBusiness");
    }

    public final LocalBusinessBuilder setAddress(PostalAddressBuilder postalAddressBuilder) {
        return (LocalBusinessBuilder) put("address", postalAddressBuilder);
    }

    public final LocalBusinessBuilder setAggregateRating(AggregateRatingBuilder aggregateRatingBuilder) {
        return (LocalBusinessBuilder) put("aggregateRating", aggregateRatingBuilder);
    }

    public final LocalBusinessBuilder setGeo(GeoShapeBuilder geoShapeBuilder) {
        return (LocalBusinessBuilder) put("geo", geoShapeBuilder);
    }

    public final LocalBusinessBuilder setPriceRange(String str) {
        return (LocalBusinessBuilder) put("priceRange", str);
    }

    public final LocalBusinessBuilder setTelephone(String str) {
        return (LocalBusinessBuilder) put("telephone", str);
    }

    public LocalBusinessBuilder(String str) {
        super(str);
    }
}
