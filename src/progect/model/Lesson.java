package progect.model;

public class Lesson {
    private static long counter=1;
    private Long id;
    private String nameLesson;
    private String  description;

    public Lesson( String nameLesson, String description) {
        this.id = counter++;
        this.nameLesson = nameLesson;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", nameLesson='" + nameLesson + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
