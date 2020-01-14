package com.example.petrsumobile.ui.nav;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NavViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Данный раздел находится\n в разработке!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}