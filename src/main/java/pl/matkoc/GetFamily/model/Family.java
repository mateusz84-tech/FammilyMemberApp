package pl.matkoc.GetFamily.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
// implementuje interfejs Comparable<T> dla napisania metody compareTo
public class Family implements Comparable<Family>{

    private Integer id;
    private String familyName;
    private Integer nrOfAdults;
    private Integer nrOfChildren;
    private Integer nrOfInfants;

    // dodanie atrubutu fetchType.EAGER dla pobierania natychmiastowego encji powiązanej
    // domyślnie relacja @OneToMany otrzymuje wartość LAZY - leniwe pobieranie wartości- na żądanie w zapytaniu
    private List<FamilyMember> familyMembers = new ArrayList<>();

    public Family(String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants) {

        if(familyName == null) throw new NullPointerException("Nazwa nie może być null.");
        else this.familyName = familyName;

        if(nrOfAdults < 0) throw new IllegalArgumentException("Wartość musi być > 0");
        else if(nrOfAdults == null) throw new NullPointerException("Wartosć nie może być null");
        else this.nrOfAdults = nrOfAdults;

        if(nrOfChildren < 0) throw new IllegalArgumentException("Wartość musi być > 0.");
        else if(nrOfChildren == null) throw new NullPointerException("Wartosć nie może być null");
        else this.nrOfChildren = nrOfChildren;

        if(nrOfInfants < 0) throw new IllegalArgumentException("Wartość musi być > 0.");
        else if(nrOfInfants == null) throw new NullPointerException("Wartosć nie może być null");
        else this.nrOfInfants = nrOfInfants;
    }

    public Family() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return familyName.equals(family.familyName) && nrOfAdults.equals(family.nrOfAdults)
                && nrOfChildren.equals(family.nrOfChildren) && nrOfInfants.equals(family.nrOfInfants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, nrOfAdults, nrOfChildren, nrOfInfants);
    }
    // nadpisanie metody compareTo() dla uporządkowania obiektów w kolekcjach wg nazwy, ilosći dorosłych, dzieci i niemowląt
    @Override
    public int compareTo(Family otherFamily) {

        int result = this.familyName.compareToIgnoreCase(otherFamily.getFamilyName());
        if(result == 0)
            result = this.nrOfAdults.compareTo(otherFamily.getNrOfAdults());
        if(result == 0)
            result = this.nrOfChildren.compareTo(otherFamily.getNrOfChildren());
        if(result == 0)
            result = this.nrOfInfants.compareTo(otherFamily.getNrOfInfants());

        return result;
    }

    public Integer getId() {
        return id;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(Integer nrOfAdults) {
        if(nrOfAdults <=0){
            throw new IllegalArgumentException("Wymagana wartosć > 0.");
        }
        this.nrOfAdults = nrOfAdults;
    }

    public Integer getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(Integer nrOfChildren) {
        if(nrOfChildren < 0){
            throw new IllegalArgumentException("Wymagana wartość >= 0.");
        }
        this.nrOfChildren = nrOfChildren;
    }
    public Integer getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(Integer nrOfInfants) {
        if(nrOfInfants < 0) throw new IllegalArgumentException("Wymagana wartość >= 0.");
        this.nrOfInfants = nrOfInfants;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", nrOfAdults=" + nrOfAdults +
                ", nrOfChildren=" + nrOfChildren +
                ", nrOfInfants=" + nrOfInfants +
                '}';
    }
}
