import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

public class AddressBook {

    static HashMap<String, String> agenda = new HashMap<>();

    public static void list(HashMap<String, String> agenda) {
        Iterator<String> recorrer = agenda.keySet().iterator();
        System.out.println("Contactos:");
        while (recorrer.hasNext()) {
            String indice = recorrer.next();
            System.out.println(indice + " : " + agenda.get(indice));
        }
        System.out.println();
    }

    public static void create(HashMap<String, String> agenda) {
        String nombre, telefono;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingresa el nombre del contacto: ");
        nombre = entrada.nextLine();
        System.out.print("Ingresa el telefono del contacto: ");
        telefono = entrada.nextLine();
        agenda.put(telefono, nombre);
        System.out.println("Se agrego el contacto de: " + nombre);
        System.out.println();
    }

    public static void delete(HashMap<String, String> agenda) {
        String telefono;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingresa el telefono del contacto a eliminar: ");
        telefono = entrada.nextLine();
        System.out.println("Se elimino con exito el contacto con numero: " + telefono);
        agenda.remove(telefono);
        System.out.println();
    }

    public static void load(HashMap<String, String> agenda) {
        String archivo = "C:\\Users\\111466\\Documents\\QUINTO SEMESTRE\\COMPUTACIÓN EN JAVA\\ACTIVIDAD-12\\src" +
                "\\AgendaContactos.csv";
        String[] contactos;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                contactos = line.split(",");
                agenda.put(contactos[0],contactos[1]);
            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public static void save(HashMap<String, String> agenda) {
        Iterator<String> recorrer = agenda.keySet().iterator();
        String archivo = "C:\\Users\\111466\\Documents\\QUINTO SEMESTRE\\COMPUTACIÓN EN JAVA\\ACTIVIDAD-12\\src" +
                "\\AgendaContactos.csv";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(archivo));
            while(recorrer.hasNext())
            {
                String indice = recorrer.next();
                bufferedWriter.write(indice + "," + agenda.get(indice) + "\n");
            }
        }
        catch(IOException e) {
            System.out.println("IOException catched while writing: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
}