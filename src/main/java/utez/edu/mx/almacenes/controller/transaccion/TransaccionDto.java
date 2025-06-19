package utez.edu.mx.almacenes.controller.transaccion;

import lombok.Data;

@Data
public class TransaccionDto {
    private String tipo;
    private double monto;
    private Integer almacenId;
    private Integer clienteId;
}
