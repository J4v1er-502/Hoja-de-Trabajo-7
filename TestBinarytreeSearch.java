//Test

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestBinarytreeSearch {

    /*
     * Test para verificar el funcionamiento de insert
     * 
     */
    @Test
    public void TestInsert() {
        BinarySearchTree tree = new BinarySearchTree();

        try {
            String[] arr = new String[3];
            arr[0] = "Valor 1";
            arr[1] = "Valor 2";
            arr[2] = "Valor 3";

            tree.insert("A", arr);
            tree.insert("B", arr);
            tree.insert("C", arr);
            tree.insert("D", arr);
            tree.insert("E", arr);

            assertEquals(true, true);

        } catch (Exception e) {
            assertEquals(true, e);
        }

    }


     /*
     * Test para verificar el funcionamiento de la busqueda en el arbol binario
     * 
     */
    @Test
    public void TestGetNode() {
        BinarySearchTree tree = new BinarySearchTree();

        try {
            String[] arr = new String[3];
            arr[0] = "Valor 1";
            arr[1] = "Valor 2";
            arr[2] = "Valor 3";

            tree.insert("A", arr);
            tree.insert("B", arr);
            tree.insert("C", arr);
            tree.insert("D", arr);
            tree.insert("E", arr);


            String[] tempArr = tree.getNode("A");

            if(tempArr == null){
                assertEquals(true,  null);
            }else{
                assertEquals(true, true);
            }



        } catch (Exception e) {
            assertEquals(true, e);
        }

    }

}