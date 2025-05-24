package gr.aueb.cf.teacherapp.repository;

import gr.aueb.cf.teacherapp.model.static_data.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository     // ΠΑΡΟΛΟ ΠΟΥ ΔΕΝ ΧΡΕΙΑΖΕΤΑΙ ΛΟΓΩ ΤΟΥ extends JpaRepository ΤΟ ΒΑΖΟΥΜΕ ΓΙΑ ΛΟΓΟΥΣ ΤΕΚΜΗΡΙΩΣΗΣ
public interface RegionRepository extends JpaRepository<Region, Long>, JpaSpecificationExecutor<Region> {
    // ΔΕΝ ΔΗΛΩΝΟΥΜΕ ΚΑΠΟΙΟ ΕΙΔΙΚΟ QUERY ΕΔΩ , ΘΑ ΠΑΡΟΥΜΕ ΜΟΝΟ ΤΑ ΒΑΣΙΚΑ ΠΟΥ ΜΑΣ ΔΙΝΟΥΝ ΑΥΤΑ ΠΟΥ ΚΑΝΟΥΜΕ EXTEND!
}
