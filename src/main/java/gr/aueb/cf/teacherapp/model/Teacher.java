package gr.aueb.cf.teacherapp.model;

import gr.aueb.cf.teacherapp.model.static_data.Region;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String vat;

    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @PrePersist     // ΚΑΘΕ ΦΟΡΑ ΠΟΥ ΘΑ ΠΑΕΙ ΝΑ ΚΑΝΕΙ SAVE ΘΑ ΕΛΕΓΧΕΙ ΤΟ UUID ΑΝ ΕΙΝΑΙ NULL. ΑΝ ΕΙΝΑΙ ΘΑ ΤΟΥ ΔΙΝΕΙ ΕΝΑ
    public void initializeUUID(){
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
