package test;
import datos.UnidadVenta;

import java.time.LocalDate;

import datos.Festival;
import datos.Personal;
import datos.PuestoDesarmable;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;
import negocio.PlatoABM;

public class TestCasoDeUsoPuestosDesarmables {

	public static void main(String[] args) {
		long idFestival = 1;
		//Creación de puesto desarmable
		FestivalABM festivalAbm = new FestivalABM();
		PersonalABM personalAbm = new PersonalABM();
		PlatoABM platoAbm = new PlatoABM();
		UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
		//Este empleado es de ejemplo. Cambiar ID (tercer valor) si se quiere crear un nuevo empleado. 
		long idCajero = personalAbm.agregarCajero("Pedro", "Gomez", 29214300, LocalDate.of(1987, 3, 17), LocalDate.of(2025, 2, 10), 400000, "PedroGomez@gmail.com", "Noche", 30000);
		Festival festival = festivalAbm.traer(idFestival);
		Personal responsable = personalAbm.traer(idCajero);
		//Cambiar tercer valor si se quiere crear nuevo puesto. 
		long idPuestoDesarmable = unidadVentaAbm.agregarPuestoDesarmable("La carpa de Pedro", 8.5f, "FT21010102", festival, responsable, 2, 30);
		System.out.printf("Puesto Desarmable creado, id=%d%n", idPuestoDesarmable);
		
		//Agregar platos genéricos
		UnidadVenta Puesto = unidadVentaAbm.traer(idPuestoDesarmable);
		platoAbm.agregar("Milanesa", 4000, 2000, Puesto);
		platoAbm.agregar("Ensalada rusa", 3000, 400, Puesto);
		platoAbm.agregar("Ensalada de lechuga", 3000, 400, Puesto);
		//Todo lo previo excepto la primer variable tiene que ser comentado si solamente se quiere testear el print
		
		//Imprimir puestos desarmables
		UnidadVentaABM abm = new UnidadVentaABM();
		double superficieTotal = abm.superficieTotal(abm.traerPuestosDesarmablesDeFestival(idFestival));
		System.out.printf("Puestos Desarmables del festival id=%d%n", idFestival);
		for (UnidadVenta u : abm.traerPuestosDesarmablesDeFestival(idFestival)) {
			PuestoDesarmable pd = (PuestoDesarmable) u;
			System.out.printf("- %s (codigo=%s) -> %d platos, %d carpas, %d minutos de montaje, superficie %f%n",
				    pd.getNombre(),
				    pd.getCodigo(),
				    pd.getPlatos().size(),
				    pd.getCantidadCarpas(),
				    pd.getTiempoMontaje(),
					pd.getSuperficie());
			
		}
		System.out.printf("Superficie total: %f", superficieTotal);

	}
}
