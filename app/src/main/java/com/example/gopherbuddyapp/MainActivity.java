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
    private static SettingsObject profileSettings;

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

        ArrayList<String[]> likes = FindSpaceViewModel.getFindSpaceLikesList();
        likes.add(new String[]{"Small groups (2-3 people)"});
        likes.add(new String[]{"Medium groups (3-5 people)"});
        likes.add(new String[]{"Large groups (5+ people)"});

        ArrayList<String[]> dislikes = FindSpaceViewModel.getFindSpaceDislikesList();
        dislikes.add(new String[]{"Noisy environments"});
        dislikes.add(new String[]{"Noisy environments"});
        dislikes.add(new String[]{"Noisy environments"});

        ArrayList<String[]> courses = FindSpaceViewModel.getFindSpaceCoursesList();
        courses.add(new String[]{"PE 1015: Weight Training", "BIOL 1009: General Biology"});
        courses.add(new String[]{"PE 1016: Weight Training", "BIOL 1010: General Biology"});
        courses.add(new String[]{"PE 1017: Weight Training", "BIOL 1011: General Biology"});
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

        ArrayList<String[]> likes = BuddyViewModel.getBuddyLikesList();
        likes.add(new String[]{"Large groups (200-300 people)", "Stadiums, fields, and on-campus spaces"});


        ArrayList<String[]> dislikes = BuddyViewModel.getBuddyDislikesList();
        dislikes.add(new String[]{"Online group work", "Quiet environments"});

        ArrayList<String[]> courses = BuddyViewModel.getBuddyCoursesList();
        courses.add(new String[]{"PE 1015: Weight Training", "PE 1012: Beginning Running", "PE 1031: Sabre Fencing", "PE 1205: Scuba and Skin Diving"});
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

    public static SettingsObject getSettings() {
        return profileSettings;
    }

}