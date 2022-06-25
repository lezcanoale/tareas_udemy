package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx { //regresa una coleccion tipo Lista <Pelicula>
        var archivo = new File(nombreRecurso);//se crea el archivo
        List<Pelicula> peliculas = new ArrayList< >();//se crea la coleccion tipo Lista Pelicula para luego agregar las Peliculas leidas en el txt.
        try {//si no hay ningun error con el archivo
            var entrada = new BufferedReader(new FileReader(archivo));//instancio mi variable entrada con el BufferedReader
            String linea = null;//creo una variable linea para ir guardando las lineas/peliculas
            linea = entrada.readLine();//leo la primera linea 
            while (linea != null) {//si esa linea no es null
                var pelicula = new Pelicula(linea);//creo un objeto tipo pelicula y guardo esa linea en la variable pelicula
                peliculas.add(pelicula);//agrego a mi List tipo <Pelicula>
                linea = entrada.readLine();//leo la sgte linea
            }
            entrada.close();//cierro mi archivo
        } catch (FileNotFoundException ex) {//si hay algun error
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas:" + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas:" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula:" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula:" + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo:" + ex.getMessage());

        }
    }

    @Override
    public void borrar(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }

}
