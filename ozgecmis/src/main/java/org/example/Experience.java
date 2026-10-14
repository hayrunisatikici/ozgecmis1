package org.example;

public class Experience {
    private String companyName;
    private String role;
    private String duration;
    private String description;

    public Experience(String companyName, String role, String duration, String description) {
        this.companyName = companyName;
        this.role = role;
        this.duration = duration;
        this.description = description;
    }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
