public class DescuentoFijo extends Descuento {
    @Override
    public double valorFinal(double valorOriginalASerDescontado){
        return valorOriginalASerDescontado - this.getValorDesc();
    }

}
