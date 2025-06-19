package utez.edu.mx.almacenes.controller.transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.almacenes.config.ApiResponse;
import utez.edu.mx.almacenes.model.Transaccion;
import utez.edu.mx.almacenes.service.TransaccionService;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Transaccion>>> obtenerTransacciones() {
        return transaccionService.obtenerTransacciones();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Transaccion>> realizarTransaccion(@RequestBody TransaccionDto dto) {
        return transaccionService.realizarTransaccion(dto);
    }
}
