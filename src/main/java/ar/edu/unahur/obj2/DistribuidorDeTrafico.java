package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Amadeus;
import ar.edu.unahur.obj2.proveedores.Proveedor;
import ar.edu.unahur.obj2.proveedores.Sabre;
import ar.edu.unahur.obj2.proveedores.Worldspan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedor>proveedores;

    public DistribuidorDeTrafico(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }


    public Proveedor proveedor() {

        return proveedores.get(random.nextInt(proveedores.size()));


    }
    public void agregarProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }


}
