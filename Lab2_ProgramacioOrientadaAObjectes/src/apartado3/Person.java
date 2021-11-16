package apartado3;

public class Person implements Comparable<Person> {
    protected final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Person o) {
        // com que String ja te implementat un compareTo, aprofitem per usarla per comparar-ho amb el name
        return name.compareToIgnoreCase(o.name);
    }
}
