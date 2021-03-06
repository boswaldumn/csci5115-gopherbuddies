package com.example.gopherbuddyapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.gopherbuddyapp.ui.buddypage.BuddyViewModel;
import com.example.gopherbuddyapp.ui.findspace.FindSpaceViewModel;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileFragment;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileViewModel;
import com.example.gopherbuddyapp.ui.myprofile.ProfileSettingsFragment;
import com.example.gopherbuddyapp.ui.myprofile.SettingsObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
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
        getSupportActionBar().hide();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_findspace, R.id.navigation_buddyprofile, R.id.navigation_myprofile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.GONE);
    }

    public void initializeFindSpaceUsers() {
        ArrayList<Integer> pics = FindSpaceViewModel.getFindSpaceProfilePicList();
        pics.add(R.drawable.annedroid);
        pics.add(R.drawable.samsung);
        pics.add(R.drawable.edvidia);
        pics.add(R.drawable.mikerosoft);
        pics.add(R.drawable.toshiba);
        pics.add(R.drawable.amyzon);
        pics.add(R.drawable.betsybuy);
        pics.add(R.drawable.cameroncanon);
        pics.add(R.drawable.pamsonic);
        pics.add(R.drawable.acesoos);
        pics.add(R.drawable.noahkia);
        pics.add(R.drawable.roblocks);
        pics.add(R.drawable.taraguest);
        pics.add(R.drawable.nedflecks);


        ArrayList<String> names = FindSpaceViewModel.getFindSpaceNameList();
        names.add("Anne Droid");
        names.add("Sam Sung");
        names.add("Ed Vidia");
        names.add("Mike Rosoft");
        names.add("Tosh Iba");
        names.add("Amy Zon");
        names.add("Betsy Buy");
        names.add("Cameron Canon");
        names.add("Pam Sonic");
        names.add("Ace Soos");
        names.add("Noah Kia");
        names.add("Rob Locks");
        names.add("Tara Guest");
        names.add("Ned Flecks");


        ArrayList<String> majors = FindSpaceViewModel.getFindSpaceMajorList();
        majors.add("Computer Science Major");
        majors.add("Acting Major");
        majors.add("Apparel Design Major");
        majors.add("Computer Science Major");
        majors.add("Electrical Engineering Major");
        majors.add("Retail Merchandising Major");
        majors.add("Management Information Systems Major");
        majors.add("Art Major");
        majors.add("Mechanical Engineering Major");
        majors.add("Computer Science Major");
        majors.add("Industrial and Systems Engineering Major");
        majors.add("Construction Management Major");
        majors.add("Product Design Major");
        majors.add("Cinema and Media Culture Major");


        ArrayList<String> colleges = FindSpaceViewModel.getFindSpaceCollegeList();
        colleges.add("College of Science and Engineering");
        colleges.add("College of Liberal Arts");
        colleges.add("College of Design");
        colleges.add("College of Science and Engineering");
        colleges.add("College of Science and Engineering");
        colleges.add("College of Design");
        colleges.add("Carlson School of Management");
        colleges.add("College of Liberal Arts");
        colleges.add("College of Science and Engineering");
        colleges.add("College of Liberal Arts");
        colleges.add("College of Science and Engineering");
        colleges.add("College of Continuing and Professional Studies");
        colleges.add("College of Design");
        colleges.add("College of Liberal Arts");


        ArrayList<String[]> likes = FindSpaceViewModel.getFindSpaceLikesList();
        likes.add(new String[]{"Small groups (2-3 people)"});
        likes.add(new String[]{"Medium groups (3-5 people)"});
        likes.add(new String[]{"Large groups (5+ people)"});
        likes.add(new String[]{"Libraries, coffee shops, and on-campus spaces", "Small groups (2-3 people)"});
        likes.add(new String[]{"Organization and lists"});
        likes.add(new String[]{"Flashcards"});
        likes.add(new String[]{"Music while studying"});
        likes.add(new String[]{"Interactive studying"});
        likes.add(new String[]{"Visual learning"});
        likes.add(new String[]{"Organization and lists"});
        likes.add(new String[]{"Note taking"});
        likes.add(new String[]{"Visual learning"});
        likes.add(new String[]{"Interactive studying"});
        likes.add(new String[]{"Flashcards"});

        ArrayList<String[]> dislikes = FindSpaceViewModel.getFindSpaceDislikesList();
        dislikes.add(new String[]{"Noisy environments", "Online group work"});
        dislikes.add(new String[]{"Noisy environments"});
        dislikes.add(new String[]{"Noisy environments"});
        dislikes.add(new String[]{"Online group work"});
        dislikes.add(new String[]{"Ebooks"});
        dislikes.add(new String[]{"Music while studying"});
        dislikes.add(new String[]{"Cramming"});
        dislikes.add(new String[]{"Too much structure"});
        dislikes.add(new String[]{"Too much structure"});
        dislikes.add(new String[]{"Not enough structure"});
        dislikes.add(new String[]{"Practice problems"});
        dislikes.add(new String[]{"Cramming"});
        dislikes.add(new String[]{"Flashcards"});
        dislikes.add(new String[]{"Ebooks"});

        ArrayList<String[]> courses = FindSpaceViewModel.getFindSpaceCoursesList();
        courses.add(new String[]{"PE 1015: Weight Training", "BIOL 1009: General Biology"});
        courses.add(new String[]{"PE 1016: Weight Training", "BIOL 1010: General Biology"});
        courses.add(new String[]{"PE 1017: Weight Training", "BIOL 1011: General Biology"});
        courses.add(new String[]{"CSCI 1133: Introduction to Computing", "BIOL 1009: General Biology", "PHYS 1301: Introductory Physics"});
        courses.add(new String[]{"EE 2301: Intro to Digital System Design", "CHEM 1061: Chem Principles I"});
        courses.add(new String[]{"DES 1101W: Introduction to Design Thinking", "RM 2215: Intro to Retail Merchandising"});
        courses.add(new String[]{"IDSC 4471: Agile Methods", "IDSC 4431: Advanced Database Design"});
        courses.add(new String[]{"ARTS 3890: 3D Modeling and Digital Fabrication", "ARTS 1107: Introduction to Digital Drawing", "AMES 3576: Language and Society of Two Koreas", "JOUR 1501: Digital Games and Society"});
        courses.add(new String[]{"ME 3332: Fluid Mechanics", "IE 3521: Stats, Quality, & Reliability"});
        courses.add(new String[]{"CSCI 4061: Intro to Operating Systems", "CSCI 3081W: Program Design & Development"});
        courses.add(new String[]{"IE 3522: Quality Engineering and Reliability", "IE 4011 Stochastic Models"});
        courses.add(new String[]{"CMGT 4021: Construction Planning and Scheduling", "ABUS 4701: Introduction to Marketing"});
        courses.add(new String[]{"PDES 2701: Creative Design Methods", "PDES 2702: Concept Sketching", "ARTS 3890: 3D Modelling and Digital Fabrication", "DES 3131: User Experience in Design"});
        courses.add(new String[]{"JOUR 3614: History of Media Communication ", "AMES 3456: Japanese Film"});
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