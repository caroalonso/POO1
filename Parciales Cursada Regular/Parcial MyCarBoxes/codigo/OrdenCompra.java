package ParcialMyCarBoxesCorregir;

public class OrdenCompra extends Orden {
    private final static double OCHO_POR_CIENTO = 0.08;
    private final static double QUINCE_POR_CIENTO = 0.15;

    public OrdenCompra(String patente) {
        super(patente);
    }

    @Override
    public double costo() {
        return this.mayorAvalor() ? this.totalRepuestos() * (1 + OCHO_POR_CIENTO) : this.totalRepuestos() * (1 + QUINCE_POR_CIENTO);
    }
}
