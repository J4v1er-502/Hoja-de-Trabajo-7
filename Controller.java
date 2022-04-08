import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Controller {

    // Utilidades
    Vista vista = new Vista();
    Scanner sc = new Scanner(System.in);
    Scanner scInt = new Scanner(System.in);

    // Archivo Diccionario
    // String src = "./diccionario.txt";
    // String src2 = "./texto.txt";
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fichero = null;
    PrintWriter pw = null;

    // Implementaciones de BinarySearchTree
    BinarySearchTree treeEN = new BinarySearchTree();
    BinarySearchTree treeES = new BinarySearchTree();
    BinarySearchTree treeFR = new BinarySearchTree();

    /**
     * Empieza con la ejecucion del programa
     */
    public void ejecutar() {

        Boolean activo = true;

        while (activo) {
            vista.print("\n :: Diccionario Ingles - Espanol - Frances ::");
            vista.print("1. Ver coleccion");
            vista.print("2. Traductor de texto");
            vista.print("3. Salir");

            Integer opcion = scInt.nextInt();

            if (opcion == 1) {
                mostrarColeccion();

            } else if (opcion == 2) {
                traducirTexto();

            } else if (opcion == 3) {
                activo = false;
            } else {
                vista.prinrErr("[!] Opcion no valida");
            }
        }

    }

    /*
     * Lee el arhivo con las palabras y sus traducciones para crear sus respecivos
     * arboles
     */
    public void leerArchivo() {

        vista.print("*Recuerde que el formato debe de ser 'ingles,espanol,frances'");
        vista.print("->Ingese la ruta del arhivo a leer");
        String src = sc.nextLine();

        // Leer el archivo de texto
        try {
            archivo = new File(src);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            vista.prinrErr("[!] No se encontro el archivo");
        }

        try {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] palabras = linea.toLowerCase().split(",");

                // Crear arbol para el ingles
                treeEN.insert(palabras[0], palabras);

                // Crear arbol para el espanol
                treeES.insert(palabras[1], palabras);

                // Crear arbol para el frances
                treeFR.insert(palabras[2], palabras);

            }

            vista.printSucc("Arhivo leido correctamente\n");

        } catch (Exception e) {
            vista.prinrErr("[!] Error al leer el archivo ListadoProductos");
        }

        pressAnyKeyToContinue();

    }


    /**
     * Imprime en consola la coleccion de palabras en el idioma inidicado
     */
    public void mostrarColeccion() {
        vista.print("\n :: MOSTRAR COLECCION DE PALABRAS :\n");

        vista.print("-> Ingresa el idioma principal");
        vista.print("1. Ingles");
        vista.print("2. Espanol");
        vista.print("3. Frances");

        int opcion = scInt.nextInt();

        if (opcion == 1) {
            vista.print("\n :: COLEECION EN INGLES :: \n");
            treeEN.getBST();
        } else if (opcion == 2) {
            vista.print("\n :: COLEECION EN ESPANOL :: \n");
            treeES.getBST();
        } else if (opcion == 3) {
            vista.print("\n :: COLEECION EN FRANCES :: \n");
            treeFR.getBST();
        } else {
            vista.prinrErr("[!] Idioma no valido");
        }

        pressAnyKeyToContinue();

    }

    /**
     * Lee el archivo indicado y lo traduce dependiendo de su idioma de entrada y salida
     */
    public void traducirTexto() {

        vista.print("\n :: TRADUCIR TEXTO ::");
        vista.print("-> Ingrese el lenguaje de entrada");
        vista.print("1. Ingles");
        vista.print("2. Espanol");
        vista.print("3. Frances");
        int entrada = scInt.nextInt();

        vista.print("-> Ingrese el lenguaje de salida");
        vista.print("1. Ingles");
        vista.print("2. Espanol");
        vista.print("3. Frances");
        int salida = scInt.nextInt();

        vista.print("\n->Ingese la ruta del arhivo a leer");
        String src2 = sc.nextLine();

        // Leer el archivo a traducir
        try {
            archivo = new File(src2);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // A nuevamente el arhivo
            fichero = new FileWriter(src2, true);
            pw = new PrintWriter(fichero);
            pw.println("\nTRADUCCION");

        } catch (Exception e) {
            vista.prinrErr("[!] No se encontro el archivo");
        }

        // Recorrer y traducir cada palabra del arcivo
        try {
            String linea;
            while ((linea = br.readLine()) != null) {

                String traduccion = "";
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {

                    // Busca la palabra en el diccionario dependiendo de el idioma de entrada
                    String[] diccionario = null;
                    if (entrada == 1) { // Ingles
                        diccionario = treeEN.getNode(palabras[i].toLowerCase());
                    } else if (entrada == 2) { // Español
                        diccionario = treeES.getNode(palabras[i].toLowerCase());
                    } else if (entrada == 3) { // Frances
                        diccionario = treeFR.getNode(palabras[i].toLowerCase());
                    }

                    // Mira si existe la traduccion
                    if (diccionario == null) {
                        traduccion += " *" + palabras[i] + "* ";

                    } else {
                        // Busca la traduccion y la agrega a la salido
                        traduccion += " " + diccionario[salida - 1] + " ";
                    }
                }

                pw.println(traduccion);

            }

            vista.printSucc("Archivo traducido correctamente");
            pressAnyKeyToContinue();

        } catch (Exception e) {
            System.out.println(e);
            // vista.prinrErr("[!] Error al leer el archivo a traducir");
        } finally {
            // Cerramos el fichero
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    /*
     * Espera a que el usuario presione una tecla para continuar la ejecución
     */
    public void pressAnyKeyToContinue() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        vista.printSucc("[] Presiona enter para continuar ...");
        try {
            seguir = teclado.nextLine();
        } catch (Exception e) {
        }
    }

}
