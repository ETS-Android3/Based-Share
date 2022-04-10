package com.nyanjuimarvin.basedshare.firebase.authentication;

import com.google.firebase.auth.FirebaseAuth;

public class Authentication {

    public static FirebaseAuth getAuth() {
        return FirebaseAuth.getInstance();
    }
}
