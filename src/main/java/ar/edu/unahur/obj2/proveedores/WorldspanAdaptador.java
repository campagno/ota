package ar.edu.unahur.obj2.proveedores;

import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;

import java.util.List;

public class WorldspanAdaptador implements Proveedor {

    private  Worldspan worldspan;

    @Override
    public List<Vuelo> buscarVuelo(DateTime fecha, String origen, String destino) {
        return worldspan.searchFlights(fecha.dayOfMonth(),fecha.monthOfYear(),fecha.year(),origen,destino);
    }
}
