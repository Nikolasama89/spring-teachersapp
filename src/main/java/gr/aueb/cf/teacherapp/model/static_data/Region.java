package gr.aueb.cf.teacherapp.model.static_data;

import gr.aueb.cf.teacherapp.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ΣΥΝΔΕΟΥΜΕ ΜΕ ΤΟΥΣ TEACHERS ME SET ΠΟΥ ΕΧΟΥΝ ΠΟΛΥ ΚΑΛΟΥΣ ΧΡΟΝΟΥΣ ΑΝΑΖΗΤΗΣΗΣ
    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "region") // ΕΔΩ ΠΑΙΡΝΕΙ ΤΟ ΟΝΟΜΑ ΑΠΟ ΤΟ ENTITY ΠΟΥ ΕΙΜΑΣΤΕ ΔΛΔ REGION
    private Set<Teacher> teachers = new HashSet<>();    // ΑΝ ΔΕΝ ΚΑΝΟΥΜΕ HASHSET TO HIBERNATE ΚΑΝΕΙ ΑΠΟ ΜΟΝΟ ΤΟΥ ΚΑΙ ΔΕΝ ΕΙΝΑΙ HASHSET

    public Set<Teacher> getAllTeachers() {
        if (teachers == null) teachers = new HashSet<>();
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setRegion(this);
    }

}
