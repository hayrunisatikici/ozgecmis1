package org.example;

import java.util.ArrayList;
import java.util.List;

public class Resume {
    private PersonalDetails personalDetails;
    private List<Experience> experiences;
    private List<String> skills;

    public Resume(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
        this.experiences = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public PersonalDetails getPersonalDetails() { return personalDetails; }
    public void setPersonalDetails(PersonalDetails personalDetails) { this.personalDetails = personalDetails; }

    public List<Experience> getExperiences() { return experiences; }
    public List<String> getSkills() { return skills; }
}
