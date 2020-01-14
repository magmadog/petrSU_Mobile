package com.example.petrsumobile.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Приложение 'PetrSU Mobile'.\n\n\nСоздано в ходе разработки проекта по курсу ТППО.\n\n\n Автор: Сарбаев Артур гр. 22307 \n\n Год создания: 2019");
    }

    public LiveData<String> getText() {
        return mText;
    }
}