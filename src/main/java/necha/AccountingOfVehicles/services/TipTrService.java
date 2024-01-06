package necha.AccountingOfVehicles.services;

import necha.AccountingOfVehicles.models.TipTr;
import necha.AccountingOfVehicles.repositories.TipTrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TipTrService {
    private final TipTrRepository repository;

    @Autowired
    public TipTrService(TipTrRepository repository) {
        this.repository = repository;
    }

    public List<TipTr> findAll() {
        return repository.findAll();
    }

    public TipTr findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(TipTr tipTr) {
        repository.save(tipTr);
    }

    @Transactional
    public void update(int id, TipTr updatedTipTr) {
        updatedTipTr.setTId(id);
        repository.save(updatedTipTr);
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
