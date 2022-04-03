package com.example.gopherbuddyapp.ui.myprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentExternalPlatformBinding;


public class ExternalPlatformFragment extends Fragment {

    private FragmentExternalPlatformBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        final Button DiscordButton = binding.DiscordButton;
       DiscordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri webpage = Uri.parse("http://discord.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);

            }

        });

        return null;
    }

}