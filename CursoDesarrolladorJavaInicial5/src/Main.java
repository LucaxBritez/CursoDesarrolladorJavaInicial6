import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("-----El contenido del archivo es el siguiente-----");
        Carrito txtCarrito = new Carrito();

        //Para comprobar a traves de los testeos, puede utilizar los archivos .txt de la carpeta Testeo
        //que esta en este mismo proyecto, solo debe reemplazar el contenido del string archivo por la direccion
        //de alguno de estos.
        String archivo = "C:\\Users\\alumno\\IdeaProjects\\CursoDesarrolladorJavaInicial5\\Testeo\\Testeo1.txt";


        //Este bucle for se utiliza para leer el archivo de la direccion almacenada en el string
        //archivo y en base a ello crear un producto, crear un itemCarrito en base a ello y asignarlo al
        //carrito txtCarrito.
        for (String linea : Files.readAllLines(Paths.get(archivo))) {

            //Con este segmento de codigo, se toma una linea del archivo .txt a utilizar
            //y gracias a el metodo split de la clase String la dividimos en Strings para poder
            //guardarlo en un array de su tipo, para luego operar sobre ellos.(En este caso el separador
            // utilizado en el metodo split es un ", ")
            String[] partes = linea.split(", ");
            Producto txtProducto = new Producto(partes[2]);
            txtProducto.setPrecio(Double.parseDouble(partes[1]));

            ItemCarrito txtItemCarrito = new ItemCarrito(Integer.parseInt(partes[0]), txtProducto);
            txtCarrito.agregarItem(txtItemCarrito);

//            System.out.println("Producto: " + txtProducto.getNombre());
//            System.out.println("ItemCarrito: " + txtItemCarrito.getCantidad());
//            System.out.println("Total carrito: " + txtCarrito.total());
//            System.out.println(" ");

        }

        if (txtCarrito.total() != 0) {
            //Segmento de codigo utilizado para consultar al usuario si desea aplicar un descuento al contenido
            //carrito, en caso afirmativo, se consulta el tipo de descuento y se invoca el metodo correspondiente.
            Scanner scan = new Scanner(System.in);
            System.out.println("¿Se aplicara un descuento al valor del contenido del carrito?");
            System.out.println("A-Si");
            System.out.println("B-No");


            //Utilizo las siguientes tres lineas de codigo para recibir el parametro que determina si se usa o no
            //el descuento.
            char respuestaSiNo = scan.next().charAt(0);
            respuestaSiNo = Character.toUpperCase(respuestaSiNo);
            System.out.println("Usted ingreso " + respuestaSiNo);

            if (respuestaSiNo == 'A') {
                System.out.println("¿Es un descuento descuento por porcentaje o fijo?");
                System.out.println("A-Fijo");
                System.out.println("B-Porcentaje");

                //Las siguientes tres lineas se usan para recibir el parametro que indica que tipo de
                //descuento se realizara.
                char respuestaFijoOPorcentaje = scan.next().charAt(0);
                respuestaFijoOPorcentaje = Character.toUpperCase(respuestaFijoOPorcentaje);
                System.out.println("Usted ingreso " + respuestaFijoOPorcentaje);

                if (respuestaFijoOPorcentaje == 'A') {

                    System.out.println("Descuento Fijo");
                    System.out.println("Por favor ingrese el monto fijo a descontar: ");
                    int descuentoFijo = scan.nextInt();

                    System.out.println("El descuento sera de " + descuentoFijo);

                    Descuento desc = new DescuentoFijo();
                    desc.setValorDesc(descuentoFijo);
                    double precioCarritoConDescuentoFijo = desc.valorFinal(txtCarrito.total());

                    if (precioCarritoConDescuentoFijo > 0) {
                        System.out.println("El monto a pagar luego del descuento es: " + precioCarritoConDescuentoFijo);
                    } else {
                        System.out.println("El monto fijo ingresado supera el valor del carrito.");
                    }


                } else if (respuestaFijoOPorcentaje == 'B') {

                    System.out.println("¿Desea realiza un descuento porcentual sin tope o con tope?");
                    System.out.println("El tope actual esta fijado en 60%.");
                    System.out.println("A-Sin tope");
                    System.out.println("B-Con tope");


                    char respuestaConTopeOSinTope = scan.next().charAt(0);
                    respuestaConTopeOSinTope = Character.toUpperCase(respuestaConTopeOSinTope);
                    System.out.println("Usted ingreso " + respuestaConTopeOSinTope);

                    if (respuestaConTopeOSinTope == 'A') {

                        System.out.println("Por favor ingrese el porcentaje a descontar: ");
                        double porcentualDescuento = scan.nextDouble();

                        if (porcentualDescuento > 0) {
                            Descuento desc = new DescuentoPorcentaje();
                            desc.setValorDesc(porcentualDescuento);
                            double precioCarritoDescuentoPorcentual = desc.valorFinal(txtCarrito.total());

                            System.out.println("El descuento sera de " + porcentualDescuento + "%.");

                            System.out.println("El monto a pagar por el contenido del carrito con el descuento aplicado es de " + precioCarritoDescuentoPorcentual);
                        } else {
                            System.out.println("El valor a dscontar no puede ser menor a cero.");
                        }
                    } else if (respuestaConTopeOSinTope == 'B') {
                        System.out.println("Por favor ingrese el porcentaje a descontar: ");
                        double porcentualDescuento = scan.nextDouble();

                        if (porcentualDescuento > 0) {
                            Descuento desc = new DescuentoPorcentajeConTope();
                            desc.setValorDesc(porcentualDescuento);
                            double precioCarritoDescuentoPorcentualConTope = desc.valorFinal(txtCarrito.total());

                            if (precioCarritoDescuentoPorcentualConTope == -1) {
                                System.out.println("El porcentaje ingresado no esta dentro de los parametros.");
                            } else {

                                System.out.println("El descuento sera de " + porcentualDescuento + "%.");

                                System.out.println("El monto a pagar por el contenido del carrito es de " + precioCarritoDescuentoPorcentualConTope);

                            }
                        } else {
                            System.out.println("El valor ingresado no es valido, este no puede ser menor que cero.");
                        }
                    }
                } else {
                    System.out.println("La opcion ingresada no es correcta");
                }

            } else if (respuestaSiNo == 'B') {
                System.out.println("No se realizara un descuento al total el carrito.");
                System.out.println(txtCarrito.total());
            } else {
                System.out.println("La opcion ingresada no es correcta.");
            }
            System.out.println(" ");

        }
    }
}