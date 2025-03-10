public class CSCI211MenuItem {
    private String objectName;
    private String packageName;
    private String methodName;
    private String displayTitle;
    private String team;
    private String author;
    private String notes;

    // Constructor
    public CSCI211MenuItem(String objectName,
                           String packageName,
                           String methodName,
                           String displayTitle,
                           String team,
                           String author,
                           String notes) {
        this.objectName = objectName;
        this.packageName = packageName;
        this.methodName = methodName;
        this.displayTitle = displayTitle;
        this.team = team;
        this.author = author;
        this.notes = notes;
    }

    // Getters
    public String getObjectName() { return objectName; }
    public String getPackageName() { return packageName; }
    public String getMethodName() { return methodName; }
    public String getDisplayTitle() { return displayTitle; }
    public String getTeam() { return team; }
    public String getAuthor() { return author; }
    public String getNotes() { return notes; }
}