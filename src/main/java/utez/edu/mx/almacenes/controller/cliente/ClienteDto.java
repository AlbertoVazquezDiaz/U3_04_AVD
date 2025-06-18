package utez.edu.mx.almacenes.controller.cliente;

import lombok.Value;

import java.io.Serializable;


@Value
public class ClienteDto implements Serializable {
    String nombreCompleto;
    String numeroDeTelefono;
    String correoElectronico;
}