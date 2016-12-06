package com.clemmahe.firebasemvpdagger.authent;

import com.clemmahe.firebasemvpdagger.BasePresenter;
import com.clemmahe.firebasemvpdagger.BaseView;

/**
 * AuthentContract
 * Created by clem on 04/12/2016.
 */

public interface AuthentContract {

    interface View extends BaseView<Presenter> {

        void showConnectedStatus(boolean isConnected);

        /*
        void setLoadingIndicator(boolean active);

        void showMissingTask();

        void hideTitle();

        void showTitle(String title);

        void hideDescription();

        void showDescription(String description);

        void showCompletionStatus(boolean complete);

        void showEditTask(String taskId);

        void showTaskDeleted();

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        boolean isActive();
        */
    }

    interface Presenter extends BasePresenter {

        void login();

        /*
        void editTask();

        void deleteTask();

        void completeTask();

        void activateTask();
        */
    }
}