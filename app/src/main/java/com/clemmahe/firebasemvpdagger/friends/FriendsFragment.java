package com.clemmahe.firebasemvpdagger.friends;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.clemmahe.firebasemvpdagger.BaseFragment;
import com.clemmahe.firebasemvpdagger.R;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by clem on 07/12/2016.
 */

public class FriendsFragment extends BaseFragment implements FriendsContract.View {


    @BindView(R.id.invite_button)
    Button inviteButton;

    private FriendsContract.Presenter mPresenter;
    private Handler uiThread;

    public static FriendsFragment newInstance() {
        return new FriendsFragment();
    }

    public FriendsFragment() {
        uiThread = new Handler(Looper.getMainLooper());
    }

    @Override
    public void setPresenter(@NonNull FriendsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.invitefriends_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }


    @OnClick(R.id.invite_button)
    public void onClick() {
        mPresenter.startInvite();
    }

    @Override
    public void inviteCompleted() {
        uiThread.post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(getView(),
                        R.string.invite_completed
                        ,Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void inviteCancelled() {
        uiThread.post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(getView(),
                        R.string.invite_cancelled
                        ,Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FirebaseManager.REQUEST_CODE_INVITE) {

            /*
            if (resultCode == Activity.RESULT_OK) {
                // Get the invitation IDs of all sent messages
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                for (String id : ids) {
                    Log.d(TAG, "onActivityResult: sent invitation " + id);
                }
            } else {
                // Sending failed or it was canceled, show failure message to the user
                // [START_EXCLUDE]
                showMessage(getString(R.string.send_failed));
                // [END_EXCLUDE]
            }
            */
        }
    }
}
