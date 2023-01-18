package es.iesjandula.statsbomb.events_stats.reference;

public class ResultReference
{
	// VARIABLES
		String equipo;
		String nombre;
		int pases;
		// CONSTRUCTOR
		public ResultReference(String equipo, String nombre, int pases) 
		{
			this.equipo = equipo;
			this.nombre = nombre;
			this.pases = pases;
		}
		// GETTERS AND SETTERS
		public String getEquipo()
		{
			return equipo;
		}
		public void setEquipo(String equipo)
		{
			this.equipo = equipo;
		}
		public String getNombre() 
		{
			return nombre;
		}
		public void setNombre(String nombre)
		{
			this.nombre = nombre;
		}
		public int getPases()
		{
			return pases;
		}
		public void setPases(int pases)
		{
			this.pases = pases;
		}
		// TO STRING
		@Override
		public String toString() 
		{
			return "Referencia [equipo=" + equipo + ", nombre=" + nombre + ", pases=" + pases + "]";
		}	
}
