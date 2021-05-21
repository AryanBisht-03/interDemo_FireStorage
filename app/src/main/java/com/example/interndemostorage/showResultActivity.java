package com.example.interndemostorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.interndemostorage.databinding.ActivityShowResultBinding;
import com.squareup.picasso.Picasso;

public class showResultActivity extends AppCompatActivity {

    ActivityShowResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if(intent.hasExtra("image"))
        {
            binding.videoView.setVisibility(View.GONE);
            binding.imageView.setVisibility(View.VISIBLE);
            String uriString = intent.getStringExtra("image");
            Picasso.get().load(uriString).into(binding.imageView);
        }
        else if(intent.hasExtra("video"))
        {
            binding.imageView.setVisibility(View.GONE);
            binding.videoView.setVisibility(View.VISIBLE);
            String uriString = intent.getStringExtra("video");
            binding.videoView.setVideoURI(Uri.parse(uriString));
            binding.videoView.start();
        }

    }
}