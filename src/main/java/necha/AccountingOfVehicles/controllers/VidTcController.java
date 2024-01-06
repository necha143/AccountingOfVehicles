package necha.AccountingOfVehicles.controllers;

import necha.AccountingOfVehicles.models.VidTc;
import necha.AccountingOfVehicles.services.VidTcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vidtc")
public class VidTcController {
    private final VidTcService service;

    @Autowired
    public VidTcController(VidTcService service) {
        this.service = service;
    }

    @GetMapping
    public List<VidTc> getVidTcs() {
        return service.findAll().stream().collect(Collectors.toList());
    }
}
