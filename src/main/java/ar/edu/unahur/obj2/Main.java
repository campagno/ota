package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Sabre sabre = new Sabre();
        SabreAdaptador sabreAdaptador = new SabreAdaptador(sabre);
        Amadeus amadeus = new Amadeus();
        AmadeusAdapador amadeusAdapador = new AmadeusAdapador(amadeus);
        Worldspan worldspan = new Worldspan();
        WorldspanAdaptador worldspanAdaptador = new WorldspanAdaptador(worldspan);

        List<Proveedor> proveedores = Stream.of(sabreAdaptador,worldspanAdaptador,amadeusAdapador).collect(Collectors.toList());
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedores);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        ota.buscarVuelos(fecha,"BUE","COR");
    }
}
