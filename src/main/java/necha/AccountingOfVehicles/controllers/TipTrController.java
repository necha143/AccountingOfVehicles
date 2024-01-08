package necha.AccountingOfVehicles.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import necha.AccountingOfVehicles.models.TipTr;
import necha.AccountingOfVehicles.services.TipTrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tips")
@Tag(name = "tip_tr_controller_methods")
public class TipTrController {
    private final TipTrService service;

    @Autowired
    public TipTrController(TipTrService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipTr> getTipes() {
        return service.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TipTr getFirm(@PathVariable("id") int id) {
        return service.findOne(id);
    }
}
