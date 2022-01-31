package com.google.firebase.database.core.view;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Index;
import java.util.Map;

public final class QuerySpec {
    private final QueryParams params;
    private final Path path;

    public QuerySpec(Path path2, QueryParams queryParams) {
        this.path = path2;
        this.params = queryParams;
    }

    public static QuerySpec defaultQueryAtPath(Path path2) {
        return new QuerySpec(path2, QueryParams.DEFAULT_PARAMS);
    }

    public static QuerySpec fromPathAndQueryObject(Path path2, Map<String, Object> map) {
        return new QuerySpec(path2, QueryParams.fromQueryObject(map));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QuerySpec.class != obj.getClass()) {
            return false;
        }
        QuerySpec querySpec = (QuerySpec) obj;
        return this.path.equals(querySpec.path) && this.params.equals(querySpec.params);
    }

    public Index getIndex() {
        return this.params.getIndex();
    }

    public QueryParams getParams() {
        return this.params;
    }

    public Path getPath() {
        return this.path;
    }

    public int hashCode() {
        return this.params.hashCode() + (this.path.hashCode() * 31);
    }

    public boolean isDefault() {
        return this.params.isDefault();
    }

    public boolean loadsAllData() {
        return this.params.loadsAllData();
    }

    public String toString() {
        return this.path + ProductDiscountsObject.KEY_DELIMITER + this.params;
    }
}
