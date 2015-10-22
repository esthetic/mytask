package com.thecabine.sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.thecabine.sample.R;
import com.thecabine.sample.domain.Item;
import com.thecabine.sample.domain.ItemsResponse;
import com.thecabine.sample.rest.RetrofitApiManager;
import com.thecabine.sample.rest.SampleApi;
import com.thecabine.sample.ui.adapter.ListAdapter;
import com.thecabine.sample.util.ConnectionUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 10/21/15.
 */
public class ListFragment extends Fragment implements ListAdapter.OnDetailItemClicked {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.loadingView)
    ProgressBar mLoadingView;

    private String mType;

    private ListAdapter mListAdapter;

    public static ListFragment newInstance(String type) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            mType = getArguments().getString("type");

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mListAdapter != null && mListAdapter.isEmpty())
            loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListAdapter = new ListAdapter(this, getActivity());
        mRecyclerView.setAdapter(mListAdapter);
    }


    private void loadData() {
        if (!ConnectionUtils.isConnected(getActivity())) {
            Toast.makeText(getActivity(), "Please, check your internet connection", Toast.LENGTH_LONG).show();
            return;
        }
        mLoadingView.setVisibility(View.VISIBLE);
        RetrofitApiManager manager = new RetrofitApiManager();
        SampleApi api = manager.getApi();
        api.getAllItems()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ItemsResponse>() {
                               @Override
                               public void onCompleted() {
                                   mLoadingView.setVisibility(View.GONE);

                               }

                               @Override
                               public void onError(Throwable e) {
                                   mLoadingView.setVisibility(View.GONE);

                               }

                               @Override
                               public void onNext(ItemsResponse response) {
                                   mLoadingView.setVisibility(View.GONE);
                                   List<Item> result = new ArrayList<>();
                                   for (Item item : response.getItems()) {
                                       if (mType.equalsIgnoreCase(item.getType()))
                                           result.add(item);
                                   }
                                   mListAdapter.setData(result);
                                   mListAdapter.notifyDataSetChanged();
                               }
                           }
                );
    }

    @Override
    public void onClick(Item item) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
