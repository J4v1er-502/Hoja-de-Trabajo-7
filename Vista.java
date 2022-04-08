/*
*@author Javier Ramírez
*/

public class Vista {

    String red = "\033[31m";
    String green = "\033[32m";
    String reset = "\u001B[0m";

    /**
     * Imprime un mensaje resaltado en rojo
     * @param mensaje
     */
    public void prinrErr(String mensaje) {
        System.out.print(red + "\n" + mensaje + reset + "\n");
    }

    /**
     * Imprime un mensaje resaltado en verde
     * @param mensaje
     */
    public void printSucc(String mensaje) {
        System.out.print(green + "\n" + mensaje + reset + "\n");
    }

    /**
     * Imprime un mensaje en consola
     * @param mensaje
     */
    public void print(String mensaje) {
        System.out.print(mensaje + "\n");
    }

}