package com.clemmahe.firebasemvpdagger.storeddatas;

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
import android.widget.TextView;

import com.clemmahe.firebasemvpdagger.BaseFragment;
import com.clemmahe.firebasemvpdagger.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by clem on 07/12/2016.
 */

public class StoredDataFragment extends BaseFragment implements StoredDataContract.View {


    @BindView(R.id.storeddata_textview)
    TextView storeddataTextview;
    @BindView(R.id.storeddata_storefakeposition)
    Button storeddataStorefakeposition;
    @BindView(R.id.storeddata_received)
    TextView storeddataReceived;

    private StoredDataContract.Presenter mPresenter;
    private Handler uiThread;

    public static StoredDataFragment newInstance() {
        return new StoredDataFragment();
    }

    public StoredDataFragment() {
        uiThread = new Handler(Looper.getMainLooper());
    }

    @Override
    public void setPresenter(@NonNull StoredDataContract.Presenter presenter) {
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
        View root = inflater.inflate(R.layout.storedatas_fragment, container, false);
        ButterKnife.bind(this, root);
        return root;
    }


    @OnClick(R.id.storeddata_storefakeposition)
    public void onClick() {
        mPresenter.addPosition(new Date().getTime(), 3, -47);
    }


    @Override
    public void positionAdded(final long latitude, final long longitude) {
        uiThread.post(new Runnable() {
            @Override
            public void run() {
                storeddataTextview.setText("PositionSaved Lat:"+latitude+" Long:"+longitude);
                Snackbar.make(getView(),
                        R.string.storeddata_positionadded
                        , Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void positionNotAdded() {
        uiThread.post(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(getView(),
                        R.string.storeddata_positionnotadded
                        , Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
