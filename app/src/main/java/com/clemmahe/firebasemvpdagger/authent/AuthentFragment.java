package com.clemmahe.firebasemvpdagger.authent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clemmahe.firebasemvpdagger.BaseFragment;
import com.clemmahe.firebasemvpdagger.R;
import com.google.android.gms.common.SignInButton;

import butterknife.BindView;
import butterknife.ButterKnife;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by clem on 07/12/2016.
 */

public class AuthentFragment extends BaseFragment implements AuthentContract.View {


    @BindView(R.id.authent_googlesigninbutton)
    SignInButton authentGooglesigninbutton;

    private AuthentContract.Presenter mPresenter;

    public static AuthentFragment newInstance() {
        return new AuthentFragment();
    }

    @Override
    public void setPresenter(@NonNull AuthentContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_authent, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void showConnectedStatus(boolean isConnected) {

    }


}
