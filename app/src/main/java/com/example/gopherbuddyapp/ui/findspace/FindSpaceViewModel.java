package com.example.gopherbuddyapp.ui.findspace;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gopherbuddyapp.MainActivity;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileFragment;
import com.example.gopherbuddyapp.ui.myprofile.MyProfileViewModel;
import com.example.gopherbuddyapp.ui.myprofile.SettingsObject;

import java.util.ArrayList;

public class FindSpaceViewModel extends ViewModel {
    // Lists for ALL users
    private static ArrayList<Integer> findSpaceProfilePicList = new ArrayList<Integer>();
    private static ArrayList<String> findSpaceNameList = new ArrayList<String>();
    private static ArrayList<String> findSpaceMajorList = new ArrayList<String>();
    private static ArrayList<String> findSpaceCollegeList = new ArrayList<String>();

    private static ArrayList<String[]> findSpaceLikesList = new ArrayList<String[]>();
    private static ArrayList<String[]> findSpaceDislikesList = new ArrayList<String[]>();
    private static ArrayList<String[]> findSpaceCoursesList = new ArrayList<String[]>();

    private final MutableLiveData<Integer> profilePic;
    private final MutableLiveData<String> nameText;
    private final MutableLiveData<String> majorText;
    private final MutableLiveData<String> collegeText;
    private final MutableLiveData<String> studyHabitsHeader;
    private final MutableLiveData<String> studyHabitsText;
    private final MutableLiveData<String> coursesHeader;
    private final MutableLiveData<String> coursesList;
    private SettingsObject userSettings;

    private static int index;
    public FindSpaceViewModel() {
        // Initial values for demo
        index = 0;

        userSettings = MainActivity.getSettings();
        profilePic = new MutableLiveData<>();
        profilePic.setValue(findSpaceProfilePicList.get(index));

        nameText = new MutableLiveData<>();
        nameText.setValue(findSpaceNameList.get(index));

        majorText = new MutableLiveData<>();
        majorText.setValue(findSpaceMajorList.get(index));

        collegeText = new MutableLiveData<>();
        collegeText.setValue(findSpaceCollegeList.get(index));

        studyHabitsHeader = new MutableLiveData<>();
        studyHabitsHeader.setValue("Study Habits (" + calculatePercentageMatch(index) + "% match)");

        studyHabitsText = new MutableLiveData<>();
        String[] likes = getFindSpaceLikesList().get(index);
        String[] dislikes = getFindSpaceDislikesList().get(index);
        String studyPreferences = "Likes:\n";
        for (String like : likes) {
            studyPreferences += "+ " + like + "\n";
        }
        studyPreferences += "\nDislikes:\n";
        for (String dislike : dislikes) {
            studyPreferences += "- " + dislike + "\n";
        }
        studyHabitsText.setValue(studyPreferences);

        coursesHeader = new MutableLiveData<>();
        int coursesShared = calculateCoursesShared(index);
        if(coursesShared == 1) {
            coursesHeader.setValue("Courses (1 course shared)");
        } else {
            coursesHeader.setValue("Courses (" + coursesShared +" courses shared)");
        }


        coursesList = new MutableLiveData<>();
        String[] courses = getFindSpaceCoursesList().get(index);
        String coursesString = "";
        for (int i = 0; i < courses.length; i++) {
            coursesString += courses[i];
            if (i + 1 <= courses.length) {
                coursesString += "\n";
            }
        }
        coursesList.setValue(coursesString);

    }

    public void updateUserData() {
        index = index + 1;
        if(index > findSpaceNameList.size() - 1) {
            index = 0;
        }
        userSettings = MainActivity.getSettings();
        profilePic.setValue(findSpaceProfilePicList.get(index));
        nameText.setValue(findSpaceNameList.get(index));
        majorText.setValue(findSpaceMajorList.get(index));
        collegeText.setValue(findSpaceCollegeList.get(index));
        studyHabitsHeader.setValue("Study Habits (" + calculatePercentageMatch(index) + "% match)");

        // Stolen from Isaac, thanks bro
        String[] likes = getFindSpaceLikesList().get(index);
        String[] dislikes = getFindSpaceDislikesList().get(index);
        String studyPreferences = "Likes:\n";
        for (String like : likes) {
            studyPreferences += "+ " + like + "\n";
        }
        studyPreferences += "\nDislikes:\n";
        for (String dislike : dislikes) {
            studyPreferences += "- " + dislike + "\n";
        }

        studyHabitsText.setValue(studyPreferences);
        int coursesShared = calculateCoursesShared(index);
        if(coursesShared == 1) {
            coursesHeader.setValue("Courses (1 course shared)");
        } else {
            coursesHeader.setValue("Courses (" + coursesShared +" courses shared)");
        }

        String[] courses = getFindSpaceCoursesList().get(index);
        String coursesString = "";
        for (int i = 0; i < courses.length; i++) {
            coursesString += courses[i];
            if (i + 1 <= courses.length) {
                coursesString += "\n";
            }
        }
        coursesList.setValue(coursesString);
    }

    // Text Getters
    public LiveData<String> getName() {
        return nameText;
    }

    public LiveData<String> getMajor() {
        return majorText;
    }

    public LiveData<String> getCollege() { return collegeText; }

    public LiveData<String> getStudyHabits() { return studyHabitsText; }

    public LiveData<String> getCourses() { return coursesList; }

    public LiveData<Integer> getProfilePic() { return profilePic; }

    public LiveData<String> getCoursesHeader() { return coursesHeader; }

    public LiveData<String> getStudyHabitsHeader() { return studyHabitsHeader; }

    public static int getIndex() { return index; }

    // List Getters
    public static ArrayList<Integer> getFindSpaceProfilePicList() { return findSpaceProfilePicList; }

    public static ArrayList<String> getFindSpaceCollegeList() {
        return findSpaceCollegeList;
    }

    public static ArrayList<String[]> getFindSpaceCoursesList() {
        return findSpaceCoursesList;
    }

    public static ArrayList<String[]> getFindSpaceLikesList() {
        return findSpaceLikesList;
    }

    public static ArrayList<String[]> getFindSpaceDislikesList() { return findSpaceDislikesList; }

    public static ArrayList<String> getFindSpaceMajorList() {
        return findSpaceMajorList;
    }

    public static ArrayList<String> getFindSpaceNameList() {
        return findSpaceNameList;
    }

    public int calculatePercentageMatch(int index) {
        int total = userSettings.getLikes().length + userSettings.getDislikes().length; // total number of likes/dislikes for the current user
        if(total == 0) {
            return 0; // covers for if the user hasn't listed any study habits
        }
        int match = 0;
        // Compares likes
        for(int i = 0; i < userSettings.getLikes().length; i++) {
            for(int j = 0; j < getFindSpaceLikesList().get(index).length; j++) {
                if (userSettings.getLikes()[i].equals(getFindSpaceLikesList().get(index)[j])) {
                    match = match + 1;
                }
            }
        }

        // Compares dislikes
        for(int i = 0; i < userSettings.getDislikes().length; i++) {
            for(int j = 0; j < getFindSpaceDislikesList().get(index).length; j++) {
                if (userSettings.getDislikes()[i].equals(getFindSpaceDislikesList().get(index)[j])) {
                    match = match + 1;
                }
            }
        }

        float percentage = 100 * ((float) match / total);
        return Math.min((int) percentage, 100);

    }

    public int calculateCoursesShared(int index) {
        int total = userSettings.getCourses().length;
        if(total == 0) {
            return 0; // covers for if the user hasn't listed any study habits
        }
        int match = 0;
        for(int i = 0; i < userSettings.getCourses().length; i++) {
            for(int j = 0; j < getFindSpaceCoursesList().get(index).length; j++) {
                if (userSettings.getCourses()[i].equals(getFindSpaceCoursesList().get(index)[j])) {
                    match = match + 1;
                }
            }
        }

        return match;
    }
}
