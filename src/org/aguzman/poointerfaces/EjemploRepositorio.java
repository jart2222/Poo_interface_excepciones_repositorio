package org.aguzman.poointerfaces;
import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;
import org.aguzman.poointerfaces.repositorio.exception.AcessoDatoException;
import org.aguzman.poointerfaces.repositorio.exception.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.rmi.AccessException;
import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {

            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Luci", "Martínez"));
            repo.crear(new Cliente("Andres", "Guzman"));

            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("===== paginable =====");
            List<Cliente> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("===== ordenar =====");
            List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);
            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("===== editar =====");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(2);
            System.out.println(bea);
            System.out.println(" ============= ");
            repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
            System.out.println("===== eliminar ======");
            repo.eliminar(50);
            repo.listar().forEach(System.out::println);
            System.out.println("===== total ===== ");
            System.out.println("Total registros: " + repo.total());
        }catch (LecturaAccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch (AcessoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
