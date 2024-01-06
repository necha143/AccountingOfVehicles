package necha.AccountingOfVehicles.services;

import necha.AccountingOfVehicles.models.Pts;
import necha.AccountingOfVehicles.repositories.PtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PtsService {
    private final PtsRepository repository;

    @Autowired
    public PtsService(PtsRepository repository) {
        this.repository = repository;
    }

    public List<Pts> findAll() {
        return repository.findAll();
    }

    public Pts findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Pts pts) {
        repository.save(pts);
    }

    @Transactional
    public void update(int id, Pts updatedPts) {
        updatedPts.setUin(id);
        repository.save(updatedPts);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
