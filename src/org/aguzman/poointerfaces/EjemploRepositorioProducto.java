package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.modelo.Producto;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.aguzman.poointerfaces.repositorio.exception.AcessoDatoException;
import org.aguzman.poointerfaces.repositorio.exception.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.aguzman.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.rmi.AccessException;
import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {


            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.52));
            repo.crear(new Producto("Silla", 18));
            repo.crear(new Producto("Lampara", 15.5));
            repo.crear(new Producto("Notebook", 400.89));

            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);
            System.out.println("===== paginable =====");
            List<Producto> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("===== ordenar =====");
            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
            for (Producto c : productosOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("===== editar =====");
            Producto lamparaActualizar = new Producto("Lampara escritorio", 23);
            lamparaActualizar.setId(3);
            repo.editar(lamparaActualizar);
            Producto lampara = repo.porId(2);
            System.out.println(lampara);
            System.out.println(" ============= ");
            repo.listar("precio", Direccion.ASC).forEach(System.out::println);
            System.out.println("===== eliminar ======");
            repo.eliminar(0);
            repo.listar().forEach(System.out::println);
            System.out.println("===== total ===== ");
            System.out.println("Total registros: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AcessoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
