package necha.AccountingOfVehicles.controllers;

import jakarta.validation.Valid;
import necha.AccountingOfVehicles.dto.PtsDTO;
import necha.AccountingOfVehicles.models.Pts;
import necha.AccountingOfVehicles.services.PtsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pts")
public class PtsController {
    private final PtsService service;
    private final ModelMapper modelMapper;

    @Autowired
    public PtsController(PtsService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<PtsDTO> getTipes() {
        return service.findAll().stream().map(this::convertToPtsDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PtsDTO getFirm(@PathVariable("id") int id) {
        return convertToPtsDTO(service.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid PtsDTO ptsDTO, @PathVariable("id") int id) {
        Pts pts = convertToPts(ptsDTO);
        service.update(id, pts);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PtsDTO ptsDTO) {
        Pts pts = convertToPts(ptsDTO);
        service.save(pts);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private PtsDTO convertToPtsDTO(Pts pts) {
        return modelMapper.map(pts, PtsDTO.class);
    }

    private Pts convertToPts(PtsDTO ptsDTO) {
        return modelMapper.map(ptsDTO, Pts.class);
    }
}
