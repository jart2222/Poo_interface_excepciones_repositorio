package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.repositorio.exception.AcessoDatoException;
import org.aguzman.poointerfaces.repositorio.exception.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AcessoDatoException;
    void crear(T t);
    void editar(T t) throws LecturaAccesoDatoException;
    void eliminar(Integer id) throws AcessoDatoException;
}
