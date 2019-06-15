package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {


    @org.testng.annotations.Test
    public void testBuscarVuelos() {

        Sabre sabre = new Sabre();
        SabreAdaptador sabreAdaptador = new SabreAdaptador(sabre);
        Worldspan worldspan = new Worldspan();
        WorldspanAdaptador worldspanAdaptador = new WorldspanAdaptador(worldspan);
        Amadeus amadeus = new Amadeus();
        AmadeusAdapador amadeusAdapador = new AmadeusAdapador(amadeus);
        List<Proveedor> proveedores = Stream.of(sabreAdaptador,worldspanAdaptador,amadeusAdapador).collect(Collectors.toList());
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(new ArrayList<Proveedor>(proveedores));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");



    }

    @org.testng.annotations.Test
    public void testReservar() {
        Sabre sabre = new Sabre();
        SabreAdaptador sabreAdaptador = new SabreAdaptador(sabre);
        Worldspan worldspan = new Worldspan();
        WorldspanAdaptador worldspanAdaptador = new WorldspanAdaptador(worldspan);
        Amadeus amadeus = new Amadeus();
        AmadeusAdapador amadeusAdapador = new AmadeusAdapador(amadeus);
        List<Proveedor> proveedores = Stream.of(sabreAdaptador,worldspanAdaptador,amadeusAdapador).collect(Collectors.toList());
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedores);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}