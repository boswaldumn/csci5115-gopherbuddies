package com.example.gopherbuddyapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;
import com.example.gopherbuddyapp.ui.findspace.FindSpaceViewModel;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileFragment;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileViewModel;
import com.example.gopherbuddyapp.ui.myprofile.ProfileSettingsFragment;
import com.example.gopherbuddyapp.ui.myprofile.SettingsObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gopherbuddyapp.databinding.ActivityMainBinding;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SettingsObject profileSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeFindSpaceUsers();
        initializeBuddies();
        profileSettings = new SettingsObject();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_findspace, R.id.navigation_notifications, R.id.navigation_myprofile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void initializeFindSpaceUsers() {
        ArrayList<Integer> pics = FindSpaceViewModel.getFindSpaceProfilePicList();
        pics.add(R.drawable.annedroid);
        pics.add(R.drawable.samsung);
        pics.add(R.drawable.edvidia);

        ArrayList<String> names = FindSpaceViewModel.getFindSpaceNameList();
        names.add("Anne Droid");
        names.add("Sam Sung");
        names.add("Ed Vidia");

        ArrayList<String> majors = FindSpaceViewModel.getFindSpaceMajorList();
        majors.add("Computer Science Major");
        majors.add("Acting Major");
        majors.add("Apparel Design Major");

        ArrayList<String> colleges = FindSpaceViewModel.getFindSpaceCollegeList();
        colleges.add("College of Science and Engineering");
        colleges.add("College of Liberal Arts");
        colleges.add("College of Design");

        ArrayList<String> habits = FindSpaceViewModel.getFindSpaceHabitsList();
        habits.add("Likes:\n + Small groups (2-3 people)\n\n" + "Dislikes:\n - Noisy environments\n");
        habits.add("Likes:\n + Medium groups (3-5 people)\n\n" + "Dislikes:\n - Noisy environments\n");
        habits.add("Likes:\n + Large groups (5+ people)\n\n" + "Dislikes:\n - Noisy environments\n");

        ArrayList<String> courses = FindSpaceViewModel.getFindSpaceCoursesList();
        courses.add("PE 1015: Weight Training\nBIOL 1009: General Biology\n");
        courses.add("PE 1016: Weight Training\nBIOL 1010: General Biology\n");
        courses.add("PE 1017: Weight Training\nBIOL 1011: General Biology\n");
    }

    public void initializeBuddies() {
        ArrayList<Integer> pics = BuddyViewModel.getBuddyProfilePicList();
        pics.add(R.drawable.goldy);

        ArrayList<String> names = BuddyViewModel.getBuddyNameList();
        names.add("Goldy Gopher");

        ArrayList<String> majors = BuddyViewModel.getBuddyMajorList();
        majors.add("Mascot Major");

        ArrayList<String> colleges = BuddyViewModel.getBuddyCollegeList();
        colleges.add("College of Liberal Arts");

        ArrayList<String> habits = BuddyViewModel.getBuddyHabitsList();
        habits.add("Likes:\n + Large groups (200-300 people)\n + Stadiums, fields, and on-campus spaces\n\n"
                + "Dislikes:\n - Online group work\n - Quiet environments");

        ArrayList<String> courses = BuddyViewModel.getBuddyCoursesList();
        courses.add("PE 1015: Weight Training\nPE 1012: Beginning Running\nPE 1031: Sabre Fencing\nPE 1205: Scuba and Skin Diving");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
                bottomNavigationView.setSelectedItemId(R.id.navigation_myprofile);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void updateSettings(SettingsObject newSettings) {
        profileSettings = newSettings;
    }

    public SettingsObject getSettings() {
        return profileSettings;
    }

}