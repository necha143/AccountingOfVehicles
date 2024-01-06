package necha.AccountingOfVehicles.repositories;

import necha.AccountingOfVehicles.models.Pts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtsRepository extends JpaRepository<Pts, Integer> {
}
