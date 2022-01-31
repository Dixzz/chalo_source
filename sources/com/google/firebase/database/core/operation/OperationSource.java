package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;

public class OperationSource {
    public static final OperationSource SERVER = new OperationSource(Source.Server, null, false);
    public static final OperationSource USER = new OperationSource(Source.User, null, false);
    private final QueryParams queryParams;
    private final Source source;
    private final boolean tagged;

    public enum Source {
        User,
        Server
    }

    public OperationSource(Source source2, QueryParams queryParams2, boolean z) {
        this.source = source2;
        this.queryParams = queryParams2;
        this.tagged = z;
        Utilities.hardAssert(!z || isFromServer());
    }

    public static OperationSource forServerTaggedQuery(QueryParams queryParams2) {
        return new OperationSource(Source.Server, queryParams2, true);
    }

    public QueryParams getQueryParams() {
        return this.queryParams;
    }

    public boolean isFromServer() {
        return this.source == Source.Server;
    }

    public boolean isFromUser() {
        return this.source == Source.User;
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("OperationSource{source=");
        i0.append(this.source);
        i0.append(", queryParams=");
        i0.append(this.queryParams);
        i0.append(", tagged=");
        i0.append(this.tagged);
        i0.append('}');
        return i0.toString();
    }
}
