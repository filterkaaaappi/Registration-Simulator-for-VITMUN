package com.cypher.dbms;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
    private final DelegateDao mDao;

    PopulateDbAsync(DelegateRoomDatabase db) {
        mDao = db.delegateDao();
    }

    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        Delegate delegate = new Delegate("Hello");
        mDao.insert(delegate);
        delegate = new Delegate("Delegate");
        mDao.insert(delegate);
        return null;
    }
}
