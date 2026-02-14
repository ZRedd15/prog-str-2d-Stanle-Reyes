import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Herencia
        Perro dogo = new Perro("Dogo");
        Gato gato1 = new Gato("Rawrl");
        dogo.comer();
        dogo.hacerSonido();
        gato1.comer();
        gato1.hacerSonido();
        System.out.println("\n");
        Animal[] animals = new Animal[3];
        animals[0] = new Perro("Ramonchis");
        animals[1] = new Gato("Salem");
        animals[2] = new Perro("Firulais");
        for (Animal animal : animals){
            animal.hacerSonido();
        }
        System.out.println("\n");
        Animal miercoles = new Perro("Miercoles");
        if (miercoles instanceof Perro){
            Perro miercoles1 = (Perro) miercoles;
            miercoles1.marcarTerritorio();
        }
    }
}
