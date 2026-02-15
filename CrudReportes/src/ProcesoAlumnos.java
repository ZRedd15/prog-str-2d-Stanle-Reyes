import java.util.Scanner;
public class ProcesoAlumnos {
    Scanner sc = new Scanner(System.in);
    ValidarDatos validarDatos = new ValidarDatos();
    private boolean idEncontrado = false;
    private boolean alumnosRegistrados = false;
    void altaAlumno(Alumno[] alumnos){
        boolean duplicado = false;
        do {
            duplicado = false;
            int id = validarDatos.comprobarId(sc, "Ingresa el id que quieras ingresar: ");
            for (int i = 0; i < alumnos.length; i++) {
                if (alumnos[i] != null && alumnos[i].getId() == id) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("El id que ingresaste ya existe");
            } else {
                String nombre = validarDatos.comprobarNombre(sc, "Ingresa el nombre: ");
                double promedio = validarDatos.comprobarPromedio(sc, "Ingresa el promedio del alumno: ");
                alumnos[id] = new Alumno(id, nombre, promedio);
                System.out.println("El alumno fue registrado correctamente");
            }
        }while(duplicado);
    }
    void buscarId(Alumno[] alumnos){
        int id = validarDatos.comprobarId(sc, "Ingresa el ID que quieras buscar: ");
        for (int i = 0; i <= alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id){
                System.out.println(alumnos[i]);
                idEncontrado = true;
                break;
            }
        }
        if (idEncontrado){
            System.out.println("No se encontro el alumno");
        }
    }
    void actualizarPromedio(Alumno[] alumno){
        int id = validarDatos.comprobarId(sc, "Ingresa el id del alumno que quieres actualizar: ");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].getId() == id){
                double promedio = validarDatos.comprobarPromedio(sc, "Ingresa el nuevo promedio: ");
                alumno[i].setPromedio(promedio);
                System.out.println("Promedio actualizado correctamente!");
                idEncontrado = true;
                return;
            }
        }
        if (!idEncontrado){
            System.out.println("No se encontro al alumno");
        }
    }
    void darDebajaAAlumno(Alumno[] alumno){
        int id = validarDatos.comprobarId(sc, "Ingresa el id a dar de baja: ");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].getId() == id){
                alumno[i].setActivo(false);
                System.out.println("Baja exitosa!");
                idEncontrado = true;
                return;
            }
        }
        if (!idEncontrado){
            System.out.println("El id no fue encontrado");
        }
    }

    void listaActivos(Alumno[] alumno){
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].isActivo()){
                System.out.println(alumno[i]);
                alumnosRegistrados = true;
            }
        }
        if (!alumnosRegistrados){
            System.out.println("No existen registros");
        }
    }

    void reporte(Alumno[] alumno){
        double promedioGeneral = 0;
        int cantidadAlumnos = 0;
        double promedioMasAlto = 0;
        double promedioMasBajo = 10;
        int alumnosConPromedioAlto = 0;
        Alumno mayorPromedio = null;
        Alumno nemorPromedio = null;
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].isActivo()){
                promedioGeneral += alumno[i].getPromedio();
                cantidadAlumnos++;
                if (promedioMasAlto < alumno[i].getPromedio()){
                    promedioMasAlto = alumno[i].getPromedio();
                    mayorPromedio=alumno[i];
                }
                if(promedioMasBajo > alumno[i].getPromedio()){
                    promedioMasBajo = alumno[i].getPromedio();
                    nemorPromedio = alumno[i];
                }
                if (alumno[i].getPromedio() >= 8){
                    alumnosConPromedioAlto++;
                }
                alumnosRegistrados = true;
            }
        }
        if (alumnosRegistrados){
            double promedioFinal = (promedioGeneral/cantidadAlumnos);
            System.out.println("Promedio general: "+promedioFinal);
            System.out.println("Alumnos con promedio mayor o igual a ocho: "+alumnosConPromedioAlto);
            System.out.println("El promedio mas alto fue de : "+mayorPromedio);
            System.out.println("El promedio mas bajo fue de : "+ nemorPromedio);
        }else {
            System.out.println("No hay alumnos registrados/activos");
        }
    }
}
