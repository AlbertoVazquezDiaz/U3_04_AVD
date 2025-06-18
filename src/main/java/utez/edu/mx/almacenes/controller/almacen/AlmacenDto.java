package utez.edu.mx.almacenes.controller.almacen;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;


@Value
public class AlmacenDto implements Serializable {
    String claveAlmacen;
    Date fechaDeRegostro;
    double precioDeVenta;
    char tamano;
    Integer cedeId;
}