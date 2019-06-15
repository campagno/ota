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
    private List<Proveedor>proveedores = new ArrayList<>();

    public DistribuidorDeTrafico(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }


    public Proveedor proveedor() {

        return proveedores.get(random.nextInt(proveedores.size()));

       // switch (random.nextInt(9)) {
       //     case 0:
       //     case 1:
       //     case 2: return "amadeus";
       //     case 3:
       //     case 4:
       //     case 5: return "sabre";
       //     case 6:
       //     case 7:
       //     case 8: return "worldspan";
       //     default: return "amadeus";
       // }

    }
    public void agregarProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }


}
