package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {

    private Amadeus amadeus;
    private Sabre sabre;
    private Worldspan worldspan;
    private SabreAdaptador sabreAdaptador;
    private AmadeusAdapador amadeusAdapador;
    private WorldspanAdaptador worldspanAdaptador;
    private DistribuidorDeTrafico distribuidorDeTrafico;
    private Ota ota;
    private List<Proveedor> proveedores;

    @BeforeTest
    public void setup() {
        Sabre sabre = new Sabre();
        Amadeus amadeus = new Amadeus();
        Worldspan worldspan = new Worldspan();
        sabreAdaptador = new SabreAdaptador(sabre);
        amadeusAdapador = new AmadeusAdapador(amadeus);
        worldspanAdaptador = new WorldspanAdaptador(worldspan);
        proveedores = Stream.of(sabreAdaptador,worldspanAdaptador,amadeusAdapador).collect(Collectors.toList());

        distribuidorDeTrafico = new DistribuidorDeTrafico(proveedores);
        ota = new Ota(distribuidorDeTrafico);


    }

    @org.testng.annotations.Test
    public void testBuscarVuelos() {


        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");






    }

    @org.testng.annotations.Test
    public void testReservar() {


        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}