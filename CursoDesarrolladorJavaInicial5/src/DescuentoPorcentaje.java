public class DescuentoPorcentaje  extends Descuento {
    @Override
    public double valorFinal(double valorOriginalASerDescontado){
//        return valorInicial - (valorInicial + this.getValorDesc());

        double resultadoDescuentoPorcentual = (this.getValorDesc() * valorOriginalASerDescontado)/100;
        return valorOriginalASerDescontado - resultadoDescuentoPorcentual;
    }
}
