package ua.org.ubts.applicationssystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ua.org.ubts.applicationssystem.serialize.MaritalDataSerializer;

import javax.persistence.*;
import java.io.Serializable;

@JsonSerialize(using = MaritalDataSerializer.class)
@Entity
@Table(name = "marital_data")
public class MaritalData implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status")
    private MaritalStatus status;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "marriage_date", length = 12)
    private String marriageDate;

    @Column(name = "is_spouse_church_member")
    private Boolean spouseChurchMember;

    @Column(name = "spouse_church_ministry", columnDefinition="TEXT")
    private String spouseChurchMinistry;

    @Column(name = "children_number")
    private Integer childrenNumber;

    @Column(name = "is_spouse_approve_seminary")
    private Boolean spouseApproveSeminary;

    @JsonIgnore
    @OneToOne(mappedBy = "maritalData")
    private Student student;

    public MaritalData() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MaritalStatus getStatus() {
        return status;
    }

    public void setStatus(MaritalStatus status) {
        this.status = status;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(String marriageDate) {
        this.marriageDate = marriageDate;
    }

    @JsonProperty(value = "isSpouseChurchMember")
    public Boolean isSpouseChurchMember() {
        return spouseChurchMember;
    }

    @JsonProperty(value = "isSpouseChurchMember")
    public void setSpouseChurchMember(Boolean spouseChurchMember) {
        this.spouseChurchMember = spouseChurchMember;
    }

    public String getSpouseChurchMinistry() { return spouseChurchMinistry; }

    public void setSpouseChurchMinistry(String spouseChurchMinistry) {
        this.spouseChurchMinistry = spouseChurchMinistry;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(Integer childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    @JsonProperty(value = "isSpouseApproveSeminary")
    public Boolean isSpouseApproveSeminary() {
        return spouseApproveSeminary;
    }

    @JsonProperty(value = "isSpouseApproveSeminary")
    public void setSpouseApproveSeminary(Boolean spouseApproveSeminary) {
        this.spouseApproveSeminary = spouseApproveSeminary;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "MaritalData{" +
                "id=" + id +
                ", status=" + status +
                ", spouseName='" + spouseName + '\'' +
                ", marriageDate='" + marriageDate + '\'' +
                ", spouseChurchMember=" + spouseChurchMember +
                ", spouseChurchMinistry='" + spouseChurchMinistry + '\'' +
                ", childrenNumber=" + childrenNumber +
                ", spouseApproveSeminary=" + spouseApproveSeminary +
                '}';
    }

}
