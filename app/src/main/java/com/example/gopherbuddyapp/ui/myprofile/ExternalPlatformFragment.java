package com.example.gopherbuddyapp.ui.myprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gopherbuddyapp.R;
import com.example.gopherbuddyapp.databinding.FragmentExternalPlatformBinding;


public class ExternalPlatformFragment extends Fragment {

    private FragmentExternalPlatformBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExternalPlatformBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        final Button discordButton = binding.DiscordButton;
        discordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://discord.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        final Button zoomButton = binding.ZoomButton;
        zoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://zoom.us/signin");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        final Button googleButton = binding.Googlebutton;
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://accounts.google.com/accountchooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        final Button canvasButton = binding.CanvasButton;
        canvasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://learn.canvas.net/login/canvas");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}