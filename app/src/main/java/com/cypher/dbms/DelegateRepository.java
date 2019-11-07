package com.cypher.dbms;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

public class DelegateRepository {       /* manages the query threads and allows us to use multiple backends
                                           choices between local or networked db*/

    private DelegateDao mDelegateDao;               //member variables
    private LiveData<List<Delegate>> mAllDelegates;

    DelegateRepository(Application application){                //constructor to handle db and get member variables
        DelegateRoomDatabase db=DelegateRoomDatabase.getDatabase(application);
        mDelegateDao=db.delegateDao();
        mAllDelegates=mDelegateDao.getAlphabatizedWords();
    }
    LiveData<List<Delegate>>getmAllDelegates(){
        return mAllDelegates;
    }
    public void insert(Delegate delegate){

        new insertAsyncTask(mDelegateDao).execute(delegate);  //running on non ui thread to prevent app crash
    }
    private static class insertAsyncTask extends AsyncTask<Delegate,Void,Void>{
        private DelegateDao mAsyncTaskDao;

        insertAsyncTask(DelegateDao dao){
            mAsyncTaskDao=dao;
        }
        @Override
        protected Void doInBackground(final Delegate...params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private DelegateDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(DelegateDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
    public void deleteAll()  {
        new deleteAllWordsAsyncTask(mDelegateDao).execute();
    }
    private static class deleteAsyncTask extends AsyncTask<Delegate, Void, Void> {
        private DelegateDao mAsyncTaskDao;

        deleteAsyncTask(DelegateDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Delegate... params) {
            mAsyncTaskDao.deleteDelegate(params[0]);
            return null;
        }
    }
    public void deleteDelegate(Delegate delegate){
        new deleteAsyncTask(mDelegateDao).execute(delegate);
    }
}
