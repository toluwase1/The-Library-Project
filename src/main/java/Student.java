public class Student extends Person {

        private String level;


    public Student(String name, String level) {
        super(name, level.equalsIgnoreCase("junior")?3:2);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

}
