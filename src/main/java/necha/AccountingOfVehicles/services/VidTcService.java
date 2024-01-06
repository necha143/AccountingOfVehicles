package necha.AccountingOfVehicles.services;

import necha.AccountingOfVehicles.models.VidTc;
import necha.AccountingOfVehicles.repositories.VidTcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VidTcService {
    private final VidTcRepository repository;

    @Autowired
    public VidTcService(VidTcRepository repository) {
        this.repository = repository;
    }

    public List<VidTc> findAll() {
        return repository.findAll();
    }

    public VidTc findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(VidTc vidTc) {
        repository.save(vidTc);
    }

    @Transactional
    public void update(int id, VidTc updatedVidTc) {
        updatedVidTc.setVidT(id);
        repository.save(updatedVidTc);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}