//Clase Mascota
import java.util.ArrayList;

// Sistema

public class Sistema {
    private ArrayList<Consulta> consultas;

    public Sistema (){
        this.consultas = new ArrayList<>();
    }

    public void registrarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void eliminarConsulta(Consulta consulta) {
        consultas.remove(consulta);
        consulta.borrarInformacion();
    }

    public void mostrarConsultas() {
        System.out.println("Cantidad de consultas registradas: " + consultas.size());
        System.out.println();
    }

}

public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private double peso;

    public Mascota(String nombre, String especie, int edad, double peso) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
    }

    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso > 0) {
            this.peso = nuevoPeso;
        } else {
            System.out.println("El peso debe ser mayor que 0.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso + " kg");
    }
}


//Clase Cliente


public class Cliente {

    private String nombre;
    private ArrayList<Mascota> mascotas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void consultarMascotas() {
        for (Mascota mascota : mascotas) {
            mascota.mostrarInformacion();
            System.out.println();
        }
    }
}


//Clase Veterinario

public class Veterinario {

    private String nombre;

    public Veterinario(String nombre) {
        this.nombre = nombre;
    }

    public void actualizarDatosMedicos(Consulta consulta, String nuevoDiagnostico, String nuevoTratamiento) {
        consulta.actualizarDatosMedicos(nuevoDiagnostico, nuevoTratamiento);
    }

}


//Clase Consulta

public class Consulta {

    private Mascota mascota;
    private String fecha;
    private String motivo;
    private String diagnostico;
    private String tratamiento;

    public Consulta(Mascota mascota, String fecha, String motivo,String diagnostico, String tratamiento) {
        this.mascota = mascota;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public void actualizarDatosMedicos(String nuevoDiagnostico, String nuevoTratamiento) {
    this.diagnostico = nuevoDiagnostico;
    this.tratamiento = nuevoTratamiento;
    }
    
    public void mostrarInformacion() {
        if (mascota == null) {
            System.out.println("La información de la consulta ha sido borrada.");
        }else{
            System.out.println("Mascota: ");
            mascota.mostrarInformacion();
            System.out.println("Fecha: " + fecha);
            System.out.println("Motivo: " + motivo);
            System.out.println("Diagnostico: " + diagnostico);
            System.out.println("Tratamiento: " + tratamiento);
            System.out.println();
        }
    }   
    public void borrarInformacion() {
        this.mascota = null;
        this.fecha = null;
        this.motivo = null;
        this.diagnostico = null;
        this.tratamiento = null;
    }
}


//Main

public class Clinica {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        Mascota mascota1 = new Mascota("Luna", "Perro", 3, 7.5);
        Mascota mascota2 = new Mascota("Michi", "Gato", 2, 4.5);

        Cliente cliente1 = new Cliente("Julieta");

        Veterinario veterinario1 = new Veterinario("Carlos");

        Consulta consulta1 = new Consulta(mascota1,"06/09/2026","Dolor de estomago","Gastritis","Medicamento y dieta especial");

        cliente1.agregarMascota(mascota1);
        cliente1.agregarMascota(mascota2);

        cliente1.consultarMascotas();

        mascota1.actualizarPeso(8.2);

        mascota1.mostrarInformacion();

        sistema.registrarConsulta(consulta1);

        sistema.mostrarConsultas();

        consulta1.mostrarInformacion();

        veterinario1.actualizarDatosMedicos(consulta1,"Gastritis leve","Dieta especial durante 5 dias");

        consulta1.mostrarInformacion();

        sistema.eliminarConsulta(consulta1);

        sistema.mostrarConsultas();

        cliente1.consultarMascotas();

        consulta1.mostrarInformacion();
    }
}
