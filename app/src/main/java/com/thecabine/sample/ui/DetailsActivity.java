package com.thecabine.sample.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thecabine.sample.R;
import com.thecabine.sample.domain.Item;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 10/21/15.
 */
public class DetailsActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbarActionBar;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.short_description)
    TextView mShortDesc;
    @Bind(R.id.description)
    TextView mDesc;
    @Bind(R.id.image)
    ImageView mMainImage;

    private Item mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        if (getIntent() != null)
            mItem = (Item) getIntent().getSerializableExtra("item");

        setupToolbar();
        setupView();
    }

    @OnClick(R.id.btn_show)
    void showOnMap() {
        Uri gmmIntentUri = Uri.parse("geo:" + mItem.getLatitude() + "," + mItem.getLongitude() + "?q=" + mItem.getLatitude() + "," + mItem.getLongitude());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null)
            startActivity(mapIntent);
        else
            Toast.makeText(this, "Please, install Google maps first", Toast.LENGTH_LONG)
                    .show();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbarActionBar);
        mToolbarActionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setTitle(mItem.getType().toUpperCase());
    }

    private void setupView() {
        if (mItem != null) {
            mTitle.setText(mItem.getTitle());
            mShortDesc.setText(mItem.getShortDescription());
            mDesc.setText(mItem.getDescription());

            Picasso.with(this)
                    .load(mItem.getBigImageUrl())
//                    .placeholder(R.drawable.placeholder_big)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(mMainImage);
        }
    }
}
