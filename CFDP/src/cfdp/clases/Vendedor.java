package cfdp.clases;

/**
 * Esta clase representa un Vendedor con sus características básicas.
 */
public class Vendedor {

    /**
     * Tipo de documento del Vendedor.
     */
    private String tipoDocumento;

    /**
     * Número de documento del Vendedor.
     */
    private int numeroDocumento;

    /**
     * Nombres del Vendedor.
     */
    private String nombres;

    /**
     * Apellidos del Vendedor.
     */
    private String apellidos;

    // Constructor vacío y constructor con argumentos
    public Vendedor() {
    }

    public Vendedor(String tipoDocumento, int numeroDocumento, String nombresVendedor, String apellidosVendedor) {
        this.tipoDocumento = tipoDocumento.toUpperCase();
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombresVendedor;
        this.apellidos = apellidosVendedor;
    }

    /**
     * Obtiene el tipo de documento del Vendedor.
     *
     * @return El tipo de documento.
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Establece el tipo de documento del Vendedor.
     *
     * @param tipoDocumento El nuevo tipo de documento.
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Obtiene el número de documento del Vendedor.
     *
     * @return El número de documento.
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Establece el número de documento del Vendedor.
     *
     * @param numeroDocumento El nuevo número de documento.
     */
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * Obtiene los nombres del Vendedor.
     *
     * @return Los nombres del Vendedor.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del Vendedor.
     *
     * @param nombresVendedor Los nuevos nombres del Vendedor.
     */
    public void setNombres(String nombresVendedor) {
        this.nombres = nombresVendedor;
    }

    /**
     * Obtiene los apellidos del Vendedor.
     *
     * @return Los apellidos del Vendedor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del Vendedor.
     *
     * @param apellidosVendedor Los nuevos apellidos del Vendedor.
     */
    public void setApellidos(String apellidosVendedor) {
        this.apellidos = apellidosVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "tipoDocumento=" + tipoDocumento +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombresVendedor='" + nombres + '\'' +
                ", apellidosVendedor='" + apellidos + '\'' +
                '}';
    }
}
