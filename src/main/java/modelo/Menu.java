package modelo;

import javax.swing.DefaultListModel;

public class Menu {
    ProductoArreglo productoArreglo;
    int tamano = 40;

    public Menu() {
        productoArreglo = new ProductoArreglo(tamano);

        //COMIDAS
        productoArreglo.agregarProducto(new Producto("101", "Hamburguesa Clasica", 13.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("102", "Hamburguesa de Pollo", 13.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("103", "Hamburguesa Parrillera", 15.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("104", "Hamburguesa a lo Pobre", 15.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("105", "Hamburguesa Amazonica", 15.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("106", "Hamburguesa Vegana", 14.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("107", "Hamburguesa Tartara", 14.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("108", "Hamburguesa de Mariscos", 15.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("109", "Hamburguesa Royal", 17.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("110", "Hamburguesa Trufada", 19.00F, "Comida"));

        //APERITIVOS
        productoArreglo.agregarProducto(new Producto("201", "Papas Fritas Regulares", 5.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("202", "Papas Fritas Medianas", 6.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("203", "Papas Fritas Grandes", 7.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("204", "Camotes Fritos Regulares", 5.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("205", "Camotes Fritos Medianas", 6.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("206", "Camotes Fritos Grandes", 7.00F, "Aperitivo"));

        //BEBIDAS
        productoArreglo.agregarProducto(new Producto("301", "Inca Kola Regular", 7.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("302", "Inca Kola Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("303", "Inca Kola Grande", 9.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("304", "Coca Cola Regular", 7.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("305", "Coca Cola Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("306", "Coca Cola Grande", 9.00F, "Bebida"));

        //POSTRE
        productoArreglo.agregarProducto(new Producto("401", "Helado de Vainilla", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("402", "Helado de Fresa", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("403", "Helado de Chocolate", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("404", "Pie de Manzana", 7.00F, "Postre"));

    }

    public ProductoArreglo getProductoArreglo() {
        return productoArreglo;
    }
    
    public int getTamano() {
        return tamano;
    }
    
    public void mostrarMenu() {
        System.out.println("Menu");
        System.out.println(" ID |          NOMBRE           |  PRECIO  |  CATEGORIA");
        System.out.println(productoArreglo);
    }
}
