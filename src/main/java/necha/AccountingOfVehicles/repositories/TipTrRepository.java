package necha.AccountingOfVehicles.repositories;

import necha.AccountingOfVehicles.models.TipTr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipTrRepository extends JpaRepository<TipTr, Integer> {
}
