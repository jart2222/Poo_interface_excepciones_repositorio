package org.aguzman.generics;
import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.modelo.ClientePremium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemplosGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes=new ArrayList<>();
        clientes.add(new Cliente("Andres","Guzman"));

        Cliente andres=clientes.iterator().next();

        Cliente[] clientesArreglo={new Cliente("Luci","Martinez")
        ,new Cliente("Andres","Guzman")};

        Integer[] enterosArreglo={1,2,3};

        List<Cliente> clientesLista=fromArrayToList(clientesArreglo);
        List<Integer> enterosLista=fromArrayToList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres =fromArrayToList(new String[]{"Andres","Pepe",
                "Luci","Bea","John"},enterosArreglo);

        List<ClientePremium> clientePremiumList=fromArrayToList(new ClientePremium[]{ new ClientePremium("Paco","Fernandez")
        });

        inprimirClientes(clientes);
        inprimirClientes(clientesLista);
        inprimirClientes(clientePremiumList);

        System.out.println("Maximo de 1,9 y 4 es: "+maximo(1,9,4));
        System.out.println("Maximo de 3.9,11.6,7.78 es: "+maximo(3.9,11.6,7.78));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: "+maximo("zanahoria","arandano","manzana"));

    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Number > List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T> > List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T,G> List<T> fromArrayToList(T[] c,G[] x){
        for (G elemento:x) {
            System.out.println(elemento);;
        }

        return Arrays.asList(c);
    }

    public static void inprimirClientes(List<?extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b,T c){
        T max=a;
        if (b.compareTo(max)>0){
            max=b;
        }
        if(c.compareTo(max)>0){
            max=c;
        }

        return max;
    }

}
