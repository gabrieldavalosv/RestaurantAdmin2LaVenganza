package modelo;

import modelo.excepciones.ArregloLLenoException;

import javax.swing.DefaultListModel;

public class Menu {
    private ProductoArreglo productoArreglo;
    private int tamano = 70;

    public Menu(){
        productoArreglo = new ProductoArreglo(tamano);

        //COMIDAS
        productoArreglo.agregarProducto(new Producto("101", "Hamburguesa Clasica", 13.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("102", "Hamburguesa de Pollo", 13.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("103", "Hamburguesa Parrillera", 15.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("104", "Hamburguesa a lo Pobre", 15.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("105", "Hamburguesa Amazonica", 15.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("106", "Hamburguesa Vegana", 14.50F, "Comida"));
        productoArreglo.agregarProducto(new Producto("107", "Hamburguesa Tartara", 14.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("108", "Hamburguesa de Pescado", 15.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("109", "Hamburguesa Royal", 17.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("110", "Hamburguesa Trufada", 19.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("111", "Hamburguesa Doble Clasica", 17.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("112", "Hamburguesa Doble de Pollo", 17.00F, "Comida"));
        productoArreglo.agregarProducto(new Producto("113", "Hamburguesa Estilo Sabogal", 16.50F, "Comida"));

        //APERITIVOS
        productoArreglo.agregarProducto(new Producto("201", "Papas Fritas Regulares", 5.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("202", "Papas Fritas Medianas", 6.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("203", "Papas Fritas Grandes", 7.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("204", "Camotes Fritos Regulares", 5.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("205", "Camotes Fritos Medianas", 6.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("206", "Camotes Fritos Grandes", 7.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("207", "Yuquitas Fritas Regulares", 6.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("208", "Yuquitas Fritas Medianas", 7.00F, "Aperitivo"));
        productoArreglo.agregarProducto(new Producto("209", "Yuquitas Fritas Grandes", 8.00F, "Aperitivo"));

        //BEBIDAS
        productoArreglo.agregarProducto(new Producto("301", "Inca Kola Regular", 6.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("302", "Inca Kola Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("303", "Inca Kola Grande", 9.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("304", "Coca Cola Regular", 7.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("305", "Coca Cola Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("306", "Coca Cola Grande", 9.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("307", "Chicha Morada Regular", 7.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("308", "Chicha Morada Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("309", "Chicha Morada Grande", 9.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("310", "Maracuya Regular", 7.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("311", "Maracuya Mediana", 8.00F, "Bebida"));
        productoArreglo.agregarProducto(new Producto("312", "Maracuya Grande", 9.00F, "Bebida"));

        //POSTRES
        productoArreglo.agregarProducto(new Producto("401", "Helado de Vainilla", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("402", "Helado de Fresa", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("403", "Helado de Chocolate", 6.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("404", "Helado de Lucuma", 7.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("405", "Helado de Menta", 7.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("406", "Helado de Arandano", 7.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("407", "Pie de Manzana", 8.00F, "Postre"));
        productoArreglo.agregarProducto(new Producto("408", "Pie de Limón", 8.00F, "Postre"));

        //COMBOS
        productoArreglo.agregarProducto(new Producto("501", "Combo Duo", 46.50F, "Combo"));
        productoArreglo.agregarProducto(new Producto("502", "Combo Familiar", 69.50F, "Combo"));
        productoArreglo.agregarProducto(new Producto("503", "Combo Kids", 21.50F, "Combo"));

    }

    public ProductoArreglo getProductoArreglo() {
        return productoArreglo;
    }

    @Override
    public String toString() {
        String resultado =" ID |          NOMBRE           |  PRECIO  |  CATEGORIA\n";
        resultado += productoArreglo;
        return resultado;
    }
}
