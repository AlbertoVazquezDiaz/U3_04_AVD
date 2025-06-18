package utez.edu.mx.almacenes.controller.cede;

import lombok.Value;

import java.io.Serializable;


@Value
public class CedeDto implements Serializable {
    String claveCede;
    String estado;
    String municipio;
}