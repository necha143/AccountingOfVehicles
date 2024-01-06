package necha.AccountingOfVehicles.repositories;

import necha.AccountingOfVehicles.models.VFirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VFirmRepository extends JpaRepository<VFirm, Integer> {
    VFirm findAllByFirmId(int id);
}
