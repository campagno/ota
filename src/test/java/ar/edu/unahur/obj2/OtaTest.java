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
    private List<Proveedor> sabreProveedor;
    private List<Proveedor> amadeusProveedor;
    private List<Proveedor> worldspamProveedor;

    @BeforeTest
    public void setup() {
        Sabre sabre = new Sabre();
        Amadeus amadeus = new Amadeus();
        Worldspan worldspan = new Worldspan();
        sabreAdaptador = new SabreAdaptador(sabre);
        amadeusAdapador = new AmadeusAdapador(amadeus);
        worldspanAdaptador = new WorldspanAdaptador(worldspan);
        proveedores = Stream.of(sabreAdaptador,worldspanAdaptador,amadeusAdapador).collect(Collectors.toList());
        sabreProveedor = Stream.of(sabreAdaptador).collect(Collectors.toList());
        amadeusProveedor = Stream.of(amadeusAdapador).collect(Collectors.toList());
        worldspamProveedor = Stream.of(worldspanAdaptador).collect(Collectors.toList());




    }

    @org.testng.annotations.Test
    public void testBuscarVuelos() {
        distribuidorDeTrafico = new DistribuidorDeTrafico(proveedores);
        ota = new Ota(distribuidorDeTrafico);


        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        assertEquals(vuelos,ota.buscarVuelos(fecha, "BUE", "MIA"));



    }
    @org.testng.annotations.Test
    public void testBuscarVuelosSabre() {
        distribuidorDeTrafico = new DistribuidorDeTrafico(sabreProveedor);
        ota = new Ota(distribuidorDeTrafico);



        DateTime fecha = new DateTime("2019-12-14");


        List<Vuelo> vuelosOTA = ota.buscarVuelos(fecha, "BUE", "MIA");
        List<Vuelo> vuelosSabre = sabre.buscar(fecha, "BUE", "MIA");

        assertEquals(vuelosOTA,vuelosSabre);



    }

    @org.testng.annotations.Test
    public void testBuscarVuelosAmadeus() {
        distribuidorDeTrafico = new DistribuidorDeTrafico(amadeusProveedor);
        ota = new Ota(distribuidorDeTrafico);



        DateTime fecha = new DateTime("2019-12-14");


        List<Vuelo> vuelosOTA = ota.buscarVuelos(fecha, "BUE", "MIA");
        List<Vuelo> vuelosAmadeus = amadeus.executeSearch(fecha, "BUE", "MIA");

        assertEquals(vuelosOTA,vuelosAmadeus);



    }

    @org.testng.annotations.Test
    public void testBuscarVuelosWorldspan() {
        distribuidorDeTrafico = new DistribuidorDeTrafico(worldspamProveedor);
        ota = new Ota(distribuidorDeTrafico);



        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelosOTA = ota.buscarVuelos(fecha, "BUE", "MIA");
        List<Vuelo> vuelosWorldspan = worldspan.searchFlights(fecha.getDayOfMonth(),fecha.getMonthOfYear(),fecha.getYear(), "BUE", "MIA");

        assertEquals(vuelosOTA,vuelosWorldspan);



    }

    @org.testng.annotations.Test
    public void testReservar() {


        DateTime fecha1 = new DateTime("2019-12-13");


        List<Vuelo> vuelos1 = ota.buscarVuelos(fecha1, "BUE", "SAO");

        Vuelo elegido =  vuelos1.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}