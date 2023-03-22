public class DescuentoPorcentajeConTope extends Descuento {
    @Override
    public double valorFinal(double valorOriginalASerDescontado) {

        if (getValorDesc() > 0 && getValorDesc() <= 60) {
            double resultadoDescuentoPorcentual = (this.getValorDesc() * valorOriginalASerDescontado) / 100;
            return valorOriginalASerDescontado - resultadoDescuentoPorcentual;
        }else {
            return -1;
        }
    }
}
