package necha.AccountingOfVehicles.services;

import necha.AccountingOfVehicles.models.VFirm;
import necha.AccountingOfVehicles.repositories.VFirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VFirmService {
    private final VFirmRepository repository;

    @Autowired
    public VFirmService(VFirmRepository repository) {
        this.repository = repository;
    }

    public List<VFirm> findAll() {
        return repository.findAll();
    }

    public VFirm findOne(int id) {
        return repository.findAllByFirmId(id);
    }

    @Transactional
    public void save(VFirm vFirm) {
        repository.save(vFirm);
    }

    @Transactional
    public void update(int id, VFirm updatedVFirm) {
        updatedVFirm.setFirmId(id);
        repository.save(updatedVFirm);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
