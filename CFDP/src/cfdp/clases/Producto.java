package cfdp.clases;

/**
 * Esta clase representa un Producto con sus características básicas.
 */
public class Producto {
    
    /**
     * Identificador único del Producto.
     */
    private int idProducto;
    /**
     * Nombre del Producto.
     */
    private String nombre;
    /**
     * Precio unitario del Producto.
     */
    private double precioUnidad;
    /**
     * Constructor por defecto.
     */
    public Producto() {
    }
    /**
     * Constructor que recibe como argumentos el id, nombre y precio del producto.
     *
     * @param idProducto El identificador del producto.
     * @param nombre El nombre del producto.
     * @param precioUnidad El precio unitario del producto.
     */
    public Producto(int idProducto, String nombre, double precioUnidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
    }
    /**
     * Obtiene el identificador del Producto.
     *
     * @return El identificador del Producto.
     */
    public int getIdProducto() {
        return idProducto;
    }
    /**
     * Establece el identificador del Producto.
     *
     * @param idProducto El nuevo identificador del Producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    /**
     * Obtiene el nombre del Producto.
     *
     * @return El nombre del Producto.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del Producto.
     *
     * @param nombre El nuevo nombre del Producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el precio unitario del Producto.
     *
     * @return El precio unitario del Producto.
     */
    public double getPrecioUnidad() {
        return precioUnidad;
    }
    /**
     * Establece el precio unitario del Producto.
     *
     * @param precioUnidad El nuevo precio unitario del Producto.
     */
    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precioUnidad=" + precioUnidad +
                '}';
    }
}