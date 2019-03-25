package com.pooja.indiatopnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.pooja.indiatopnews.Activity.GoogleNewsDetails;
import com.pooja.indiatopnews.Adapter.GoogleNewsAdapter;
import com.pooja.indiatopnews.VollyApi.GetApiCall;
import com.pooja.indiatopnews.pojo.Article;
import com.pooja.indiatopnews.pojo.GoogleNews;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleNewsIndia extends Fragment {
    RecyclerView mRecyclerView;
    String business;
    int position;
    String category;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;
    private ProgressBar mProgressBar;

    public GoogleNewsIndia() {
        // Required empty public constructor
    }

    public static GoogleNewsIndia newInstance(int sectionNumber) {
        GoogleNewsIndia fragment = new GoogleNewsIndia();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_google_news_india, container, false);

        //   callNewsApi();
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        if (sectionNumber == 0) {
            category = "business";
            callNewsApi(category);

        } else if (sectionNumber == 1) {
            category = "health";
            callNewsApi(category);

        } else if (sectionNumber == 2) {
            category = "sports";
            callNewsApi(category);

        } else if (sectionNumber == 3) {
            category = "technology";
            callNewsApi(category);

        } else if (sectionNumber == 4) {
            category = "science";
            callNewsApi(category);

        } else if (sectionNumber == 5) {
            category = "entertainment";
            callNewsApi(category);

        }

        Log.e("tag_position", String.valueOf(position));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv);

        return view;
    }

    private void callNewsApi(String category) {
        try {
            mProgressBar.setVisibility(View.VISIBLE);

            String url = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apiKey=ef0a2f344e964325beab2abe36b784ae";
            GetApiCall getApiCall = new GetApiCall() {
                @Override
                public Response.Listener<JSONObject> createMyReqSuccessListener() {
                    return new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            mProgressBar.setVisibility(View.GONE);
                            Log.e("tag_re", String.valueOf(response));
                            Gson gson = new Gson();
                            GoogleNews googleNews = gson.fromJson(response.toString(), GoogleNews.class);
                            ArrayList<Article> articles = new ArrayList<>();
                            if (googleNews != null && !googleNews.getArticles().isEmpty()) {
                                for (int i = 0; i < googleNews.getArticles().size(); i++) {
                                    articles.add(googleNews.getArticles().get(i));

                                    callAdapter(articles);

                                }
                                Log.e("tag_gn", googleNews.getArticles().get(0).getTitle());
                            } else {
                                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                              //  new CommonUtils().NoRecordFoundPrint(getActivity());
                            }
                        }
                    };
                }
            };
            getApiCall.getProduct(null, getActivity(), url, null, null, null, null, null, null);
        } catch (Exception ex) {
            ex.printStackTrace();
          //  Crashlytics.logException(ex);
        }

    }

    private void callAdapter(final ArrayList<Article> articles) {

        GoogleNewsAdapter adapter = new GoogleNewsAdapter(getActivity(), articles);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


/*
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(getActivity(), GoogleNewsDetails.class);

                intent.putExtra("title", articles.get(position).getTitle());
                intent.putExtra("content", articles.get(position).getContent());
                intent.putExtra("description", articles.get(position).getDescription());
                intent.putExtra("publishedAt", articles.get(position).getPublishedAt());
                intent.putExtra("urlToImage", articles.get(position).getUrlToImage());
                intent.putExtra("url", articles.get(position).getUrl());

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
*/

    }
}