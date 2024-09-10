package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contacto> listaDeContactos = new ArrayList<>();

        listaDeContactos.add(new Contacto("Juan", "123456789"));
        listaDeContactos.add(new Contacto("Ana", "987654321"));
        listaDeContactos.add(new Contacto("Pedro", "555666777"));
        listaDeContactos.add(new Contacto("Laura", "888999000"));

        System.out.println("Lista de contactos:");
        imprimirContactos(listaDeContactos);

        String nombreBuscado = "Ana";
        buscarContactoPorNombre(listaDeContactos, nombreBuscado);

        String nombreEliminar = "Pedro";
        eliminarContactoPorNombre(listaDeContactos, nombreEliminar);

        Collections.sort(listaDeContactos, Comparator.comparing(Contacto::getNombre));

        System.out.println("\nLista de contactos ordenada por nombre:");
        imprimirContactos(listaDeContactos);
    }

    public static void imprimirContactos(ArrayList<Contacto> contactos) {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public static void buscarContactoPorNombre(ArrayList<Contacto> contactos, String nombre) {
        boolean encontrado = false;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nContacto encontrado: " + contacto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("\nContacto con nombre " + nombre + " no encontrado.");
        }
    }

    public static void eliminarContactoPorNombre(ArrayList<Contacto> contactos, String nombre) {
        boolean eliminado = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nEliminando contacto: " + contactos.get(i));
                contactos.remove(i);
                eliminado = true;
                break;
            }
        }
        if (!eliminado) {
            System.out.println("\nContacto con nombre " + nombre + " no encontrado para eliminar.");
        }
    }
}
