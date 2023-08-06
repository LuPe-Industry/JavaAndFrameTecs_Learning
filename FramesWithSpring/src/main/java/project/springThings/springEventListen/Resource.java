package project.springThings.springEventListen;

public class Resource {
    private String id;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Resource(String id, String age) {
        this.id = id;
        this.age = age;
    }

    public Resource() {
    }
}
