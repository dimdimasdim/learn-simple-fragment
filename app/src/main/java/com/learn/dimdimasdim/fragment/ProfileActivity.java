package com.learn.dimdimasdim.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvProfileUser;

    public static String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String name = getIntent().getStringExtra(EXTRA_NAME);

        tvProfileUser = findViewById(R.id.tv_profile_user);

        tvProfileUser.setText(String.format("profil user : %s", name));

    }
}
