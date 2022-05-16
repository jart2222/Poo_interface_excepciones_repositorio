package org.aguzman.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T>camion){
        for (T a: camion) {
            if (a instanceof Animal){
                System.out.println(((Animal) a).getNombre()+ " tipo: "+((Animal) a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println( ((Automovil) a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }
    public static void main(String[] args) {
        Camion<Animal> trasporteCaballos =new Camion<>(5);
        trasporteCaballos.add(new Animal("Peregrino","Caballo"));
        trasporteCaballos.add(new Animal("grillo","Caballo"));
        trasporteCaballos.add(new Animal("Tunquen","Caballo"));
        trasporteCaballos.add(new Animal("Tococalma","Caballo"));
        trasporteCaballos.add(new Animal("Longotoma","Caballo"));

        imprimirCamion(trasporteCaballos);

        Camion<Maquinaria> transMaquinas =new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grua Morquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto=new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);

    }
}
