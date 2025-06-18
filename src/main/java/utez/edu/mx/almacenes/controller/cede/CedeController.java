package utez.edu.mx.almacenes.controller.cede;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.almacenes.config.ApiResponse;
import utez.edu.mx.almacenes.model.Cede;
import utez.edu.mx.almacenes.service.CedeService;

import java.util.List;

@RestController
@RequestMapping("/api/cede")
@CrossOrigin(origins = "*")
public class CedeController {

    private final CedeService cedeService;

    public CedeController(CedeService cedeService) {
        this.cedeService = cedeService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Cede>>> getAll() {
        return cedeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Cede>> getById(@PathVariable Integer id) {
        return cedeService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Cede>> save(@RequestBody CedeDto dto) {
        return cedeService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Cede>> update(@PathVariable Integer id, @RequestBody CedeDto dto) {
        return cedeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return cedeService.deleteById(id);
    }


}
