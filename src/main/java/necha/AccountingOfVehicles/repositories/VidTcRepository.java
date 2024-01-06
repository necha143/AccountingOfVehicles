package necha.AccountingOfVehicles.repositories;

import necha.AccountingOfVehicles.models.VidTc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidTcRepository extends JpaRepository<VidTc, Integer> {
}
