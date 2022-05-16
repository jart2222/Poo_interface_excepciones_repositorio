package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.BaseEntity;
import org.aguzman.poointerfaces.repositorio.exception.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }


    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id==null || id<=0){
            throw new LecturaAccesoDatoException("Id invalido debe ser <0");
        }

        T resultado = null;


        for(T cli: dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        if (resultado==null){
            throw new LecturaAccesoDatoException("No existe el registro con id: "+id);
        }

        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    public void editar(T cliente) throws LecturaAccesoDatoException {

    }


    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{
        this.dataSource.remove(this.porId(id));
    }



    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

    @Override
    public List<T> listar(String campo, Direccion dir) {
        return null;
    }
}
