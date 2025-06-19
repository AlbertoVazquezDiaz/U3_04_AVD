package utez.edu.mx.almacenes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utez.edu.mx.almacenes.config.ApiResponse;
import utez.edu.mx.almacenes.controller.transaccion.TransaccionDto;
import utez.edu.mx.almacenes.model.Almacen;
import utez.edu.mx.almacenes.model.Cliente;
import utez.edu.mx.almacenes.model.Transaccion;
import utez.edu.mx.almacenes.repository.AlmacenRepository;
import utez.edu.mx.almacenes.repository.ClienteRepository;
import utez.edu.mx.almacenes.repository.TransaccionRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private AlmacenRepository almacenRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<ApiResponse<Transaccion>> realizarTransaccion(TransaccionDto dto) {
        // Validar que existe el almacén
        Optional<Almacen> almacenOpt = almacenRepository.findById(dto.getAlmacenId());
        if (almacenOpt.isEmpty()) {
            return new ResponseEntity<>(
                new ApiResponse<>(null, "Almacén no encontrado", HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
            );
        }

        // Validar que existe el cliente
        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        if (clienteOpt.isEmpty()) {
            return new ResponseEntity<>(
                new ApiResponse<>(null, "Cliente no encontrado", HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
            );
        }

        // Crear y guardar la transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo(dto.getTipo());
        transaccion.setMonto(dto.getMonto());
        transaccion.setFecha(new Date());
        transaccion.setAlmacen(almacenOpt.get());
        transaccion.setCliente(clienteOpt.get());

        Transaccion saved = transaccionRepository.save(transaccion);

        return new ResponseEntity<>(
            new ApiResponse<>(saved, "Transacción realizada exitosamente", HttpStatus.OK),
            HttpStatus.OK
        );
    }

    public ResponseEntity<ApiResponse<List<Transaccion>>> obtenerTransacciones() {
        List<Transaccion> transacciones = transaccionRepository.findAll();
        return new ResponseEntity<>(
            new ApiResponse<>(transacciones, "Transacciones obtenidas exitosamente", HttpStatus.OK),
            HttpStatus.OK
        );
    }
}
