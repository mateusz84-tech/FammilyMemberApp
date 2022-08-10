package pl.matkoc.GetFamily.model;
import java.util.Objects;
public class FamilyMember implements Comparable<FamilyMember>{

    private Integer id;
    private String name;
    private String familyName;
    private int age;

    public FamilyMember(String name, String familyName, int age) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }

    public FamilyMember() {
    }

    @Override
    public int compareTo(FamilyMember otherFamilyMembers) {
        int result = name.compareTo(otherFamilyMembers.getName());
        if(result == 0) result = familyName.compareToIgnoreCase(otherFamilyMembers.getName());
        if(result == 0) result = Integer.compare(age, otherFamilyMembers.getAge());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return age == that.age && name.equals(that.name) && familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyName, age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                '}';
    }
}
