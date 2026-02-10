public class Persona {
   int id;
   String nombre;
   boolean activa;

   public Persona(int id, String nombre) {
      this.id = id;
      this.nombre = nombre;
      this.activa = true;
   }

   // Getters y Setters
   public int getId() {
      return id;
   }
   public String getNombre() {
      return nombre;
   }
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   public boolean isActiva() {
      return activa;
   }
   public void setActiva(boolean activa) {
      this.activa = activa;
   }

   @Override
   public String toString() {
      return String.format("ID: %d | Nombre: %s | Activo", id, nombre);
   }
}