package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Favourites.Favourite;

public class FavoriteChanged {
    private final Favourite _fav;
    private final boolean _isAddOrUpdate;

    public FavoriteChanged(Favourite favourite, boolean z) {
        this._fav = favourite;
        this._isAddOrUpdate = z;
    }

    public Favourite getFav() {
        return this._fav;
    }

    public boolean isAddOrUpdate() {
        return this._isAddOrUpdate;
    }
}
