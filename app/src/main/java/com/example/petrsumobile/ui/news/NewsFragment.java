package com.example.petrsumobile.ui.news;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petrsumobile.MainActivity;
import com.example.petrsumobile.R;
import com.example.petrsumobile.ui.Adapter.FeedAdapter;
import com.example.petrsumobile.ui.Common.HTTPDataHandler;
import com.example.petrsumobile.ui.model.RSSobject;
import com.google.gson.Gson;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;

    RecyclerView recyclerView;
    RSSobject rssObject;
    private final String rss_link = "https://petrsu.ru/rss?type=1";
    private final String rss_to_json = "https://api.rss2json.com/v1/api.json?rss_url=";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.news, container, false);

        recyclerView = (RecyclerView)root.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //loadRSS();

        return root;
    }

    private void loadRSS() {
        @SuppressLint("StaticFieldLeak") AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

//            ProgressDialog mDialog = new ProgressDialog(this);

//            @Override
//            protected void onPreExecute() {
//                mDialog.setMessage("Пожалуйста подождите!");
//                mDialog.show();
//            }

            @Override
            protected String doInBackground(String... strings) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(strings[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
//                mDialog.dismiss();
                RSSobject rssObject = new Gson().fromJson(s,RSSobject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject, getContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        };

        StringBuilder url_get_data = new StringBuilder(rss_to_json);
        url_get_data.append(rss_link);
        loadRSSAsync.execute(url_get_data.toString());
    }


}