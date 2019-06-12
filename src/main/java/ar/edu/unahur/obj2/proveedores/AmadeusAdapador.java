package ar.edu.unahur.obj2.proveedores;

import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;

import java.util.List;

public class AmadeusAdapador implements Proveedor {

    private Amadeus amadeus;

    @Override
    public List<Vuelo> buscarVuelo(DateTime fecha, String origen, String destino) {

    return amadeus.executeSearch(fecha,origen,destino);
    }
}

