package utez.edu.mx.almacenes.controller.almacen;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.almacenes.config.ApiResponse;
import utez.edu.mx.almacenes.model.Almacen;
import utez.edu.mx.almacenes.service.AlmacenService;

import java.util.List;

@RestController
@RequestMapping("/api/almacen")
@CrossOrigin(origins = "*")
public class AlmacenController {

    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Almacen>>> getAll() {
        return almacenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Almacen>> getById(@PathVariable Integer id) {
        return almacenService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Almacen>> save(@RequestBody AlmacenDto dto) {
        return almacenService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Almacen>> update(@PathVariable Integer id, @RequestBody AlmacenDto dto) {
        return almacenService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return almacenService.deleteById(id);
    }

}
