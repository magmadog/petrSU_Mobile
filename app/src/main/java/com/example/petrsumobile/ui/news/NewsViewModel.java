package com.example.petrsumobile.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petrsumobile.ui.model.RSSobject;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    RecyclerView recyclerView;
    RSSobject rssObject;
    private final String rss_link = "https://petrsu.ru/rss?type=1";
    private final String rss_to_json = "https://api.rss2json.com/v1/api.json?rss_url=";

    public NewsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is news fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}