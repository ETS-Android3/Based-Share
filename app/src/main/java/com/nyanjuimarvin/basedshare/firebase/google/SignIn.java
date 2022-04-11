package com.nyanjuimarvin.basedshare.firebase.google;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class SignIn {

    public static GoogleSignInOptions getSignInOptions(){
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    }
}
