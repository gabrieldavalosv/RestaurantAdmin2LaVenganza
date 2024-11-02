package modelo;

public class Menu {
    ProductoArreglo productoArreglo;
    int tamano = 20;

    public Menu() {
        productoArreglo = new ProductoArreglo(tamano);

        //COMIDAS
        Producto prod101, prod102, prod103, prod104, prod105, prod106, prod107, prod108, prod109, prod110;
        productoArreglo.agregarProducto(prod101 = new Producto(
                "101", "Hamburguesa Clasica", 13.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod109 = new Producto(
                "102", "Hamburguesa de Pollo", 13.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod102 = new Producto(
                "103", "Hamburguesa Parrillera", 15.50F, "Comida")
        );
        productoArreglo.agregarProducto(prod103 = new Producto(
                "104", "Hamburguesa a lo Pobre", 15.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod104 = new Producto(
                "105", "Hamburguesa Amazonica", 15.50F, "Comida")
        );
        productoArreglo.agregarProducto(prod105 = new Producto(
                "106", "Hamburguesa Vegana", 14.50F, "Comida")
        );
        productoArreglo.agregarProducto(prod106 = new Producto(
                "107", "Hamburguesa Tartara", 14.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod107 = new Producto(
                "108", "Hamburguesa Marina", 15.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod108 = new Producto(
                "109", "Hamburguesa Royal", 17.00F, "Comida")
        );
        productoArreglo.agregarProducto(prod110 = new Producto(
                "110", "Hamburguesa Trufada", 19.00F, "Comida")
        );

        //APERITIVOS
        Producto prod201, prod202, prod203, prod204, prod205, prod206, prod207, prod208, prod209, prod210;

        //BEBIDAS
        Producto prod301, prod302, prod303, prod304, prod305, prod306, prod307, prod308, prod309, prod310;

        //POSTRE
        Producto prod401, prod402, prod403, prod404, prod405, prod406, prod407, prod408, prod409, prod410;


    }

    public void mostrarMenu() {
        System.out.println("Modelo.Menu");
        System.out.println(" ID |          NOMBRE           |  PRECIO  | CATEGORIA");
        System.out.println(productoArreglo);
    }
}
