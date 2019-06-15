package ar.edu.unahur.obj2.proveedores;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public interface Proveedor {

    List<Vuelo> buscarVuelo (DateTime fecha, String origen, String destino);

    Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros);
}
