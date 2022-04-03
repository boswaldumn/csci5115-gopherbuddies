package com.example.gopherbuddyapp.ui.myprofile;

public class SettingsObject {

    private String nameText;
    private String majorText;
    private String collegeText;
    private String[] likesArray;
    private String[] dislikesArray;
    private String[] coursesArray;

    public SettingsObject() {
        nameText = "Mac Intosh";
        majorText = "Computer Science Major";
        collegeText = "College of Science and Engineering";
        likesArray = new String[]{"Small groups (2-3 people)", "Libraries, coffee shops, and on-campus spaces"};
        dislikesArray = new String[]{"Online group work", "Noisy environments"};
        coursesArray = new String[]{"PE 1015: Weight Training", "BIOL 1009: General Biology", "CSCI 1133: Introduction to Computing", "PHYS 1301: Introductory Physics"};
    }

    public SettingsObject(String name, String major, String college, String[] likes, String[] dislikes) {
        nameText = name;
        majorText = major;
        collegeText = college;
        likesArray = likes;
        dislikesArray = dislikes;
        coursesArray = new String[]{"PE 1015: Weight Training", "BIOL 1009: General Biology", "CSCI 1133: Introduction to Computing", "PHYS 1301: Introductory Physics"};
    }

    public String getName() { return nameText; };
    public String getMajor() { return majorText; };
    public String getCollege() { return collegeText; };
    public String[] getLikes() { return likesArray; };
    public String[] getDislikes() { return dislikesArray; };
    public String[] getCourses() { return coursesArray; };

    public void setName(String name) {
        nameText = name;
    }

    public void setMajor(String major) {
        majorText = major;
    }

    public void setCollege(String college) {
        collegeText = college;
    }
}
