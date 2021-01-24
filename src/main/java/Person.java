public abstract class Person implements Comparable<Person> {
    private String name;
    private int id;


    public Person(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if(id > o.id)return 1;
        else if(id < o.id)return -1;
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
