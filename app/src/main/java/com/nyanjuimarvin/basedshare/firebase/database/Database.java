package com.nyanjuimarvin.basedshare.firebase.database;

import com.google.firebase.database.FirebaseDatabase;

public class Database {

    public static FirebaseDatabase getDatabase(){
        return FirebaseDatabase.getInstance();
    }
}
