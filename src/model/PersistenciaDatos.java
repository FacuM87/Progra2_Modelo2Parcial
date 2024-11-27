package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PersistenciaDatos {

    public static <T> void saveAll(String nombreArchivo, T datos) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo + ".bin"))) {
            oos.writeObject(datos);
            System.out.println("Datos guardados exitosamente en: " + nombreArchivo + ".bin");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static <T> T loadAll(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo + ".bin"))) {
            T datos = (T) ois.readObject();
            return datos;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
        return null;
    }

}
