
public class Objeto {

		public String nombre;
		public String localizacion; //la llave esta en maria
		int IDObj; 

		public Objeto(String nombre, String localizacion, int IDObj) {
			this.nombre = nombre;
			this.localizacion = localizacion;
			this.IDObj = IDObj;
		}
		
	
		public int getIDObj() {
			return IDObj;
		}


		public void setIDObj(int iDObj) {
			IDObj = iDObj;
		}


		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getLocalizacion() {
			return localizacion;
		}
		
		public void setLocalizacion(String localizacion) {
			this.localizacion = localizacion;
		}

		@Override
		public String toString() {
			return "Objeto [nombre=" + nombre + ", localizacion=" + localizacion + ", IDObj=" + IDObj + "]";
		}
		
}
