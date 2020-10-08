package pens.lab.app.belajaractivity.modul.profile;

import android.content.Context;
import android.content.SharedPreferences;

import pens.lab.app.belajaractivity.R;

/**
 * Created by fahrul on 13/03/19.
 */

public class ProfilePresenter implements ProfileContract.Presenter{
    private final ProfileContract.View view;
    private final SharedPreferences sharedPreferences;
    private Context context;
    public static final String PREFERENCE_KEY = "mvp_android";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public ProfilePresenter(ProfileContract.View view, Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
        this.view = view;
    }

    @Override
    public void start() {
        getProfile();
    }

    @Override
    public void getProfile(){
        String email = this.sharedPreferences.getString(EMAIL, context.getResources().getString(R.string.default_value));
        String password = this.sharedPreferences.getString(PASSWORD, context.getResources().getString(R.string.default_value));

        view.updateProfile(email, password);
    }

    @Override
    public void performBack(){
        view.redirectToLogin();
    }
}
