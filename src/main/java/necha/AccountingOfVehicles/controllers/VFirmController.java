package necha.AccountingOfVehicles.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import necha.AccountingOfVehicles.models.VFirm;
import necha.AccountingOfVehicles.services.VFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vfirms")
@Tag(name = "vfrim_controller_methods")
public class VFirmController {
    private final VFirmService service;

    @Autowired
    public VFirmController(VFirmService service) {
        this.service = service;
    }

    @GetMapping
    public List<VFirm> getVFirms() {
        return service.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VFirm getFirm(@PathVariable("id") int id) {
        return service.findOne(id);
    }
}
