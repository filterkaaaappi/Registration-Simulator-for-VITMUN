package com.cypher.dbms;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DelegateViewModel extends AndroidViewModel {
    private static DelegateRepository mRepository;
    private LiveData<List<Delegate>> mAllDelegates;

    public DelegateViewModel(Application application){
        super(application);
        mRepository=new DelegateRepository(application);
        mAllDelegates=mRepository.getmAllDelegates();
    }
    LiveData<List<Delegate>> getmAllDelegates(){return mAllDelegates;}

    public void insert(Delegate delegate){mRepository.insert(delegate);}
    public static void deleteAll() {mRepository.deleteAll();}
    public static void deleteDelegate(Delegate delegate) {mRepository.deleteDelegate(delegate);}
}
