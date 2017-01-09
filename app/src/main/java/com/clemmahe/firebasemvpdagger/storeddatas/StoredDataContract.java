package com.clemmahe.firebasemvpdagger.storeddatas;

import com.clemmahe.firebasemvpdagger.BasePresenter;
import com.clemmahe.firebasemvpdagger.BaseView;

/**
 * StoredDataContract
 * Created by clem on 04/12/2016.
 */

public interface StoredDataContract {

    /**
     * Authent View
     */
    interface View extends BaseView<Presenter> {

        void positionAdded(final long latitude, final long longitude);
        void positionLoaded(final long latitude, final long longitude);
    }

    /**
     * Authent Presenter
     */
    interface Presenter extends BasePresenter {
        void addPosition(long time, long latitude, long longitude);
    }
}