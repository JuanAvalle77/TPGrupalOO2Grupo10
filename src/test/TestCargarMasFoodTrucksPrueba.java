package test;

import datos.Festival;
import datos.Personal;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestCargarMasFoodTrucksPrueba {

	public static void main(String[] args) {

		long idFestival = 1;

		FestivalABM festivalAbm = new FestivalABM();
		PersonalABM personalAbm = new PersonalABM();
		UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
		PlatoABM platoAbm = new PlatoABM();

		Festival festival = festivalAbm.traer(idFestival);
		Personal responsable = personalAbm.traer(1); // reutiliza el Cocinero ya cargado como responsable

		// FoodTruck 2: empanadas
		long idEmpanadas = unidadVentaAbm.agregarFoodTruck("La Empanada Andante", 12.0f, "FT00000002", festival,
				responsable, false, "AB456CD");
		System.out.printf("FoodTruck creado, id=%d%n", idEmpanadas);
		UnidadVenta empanadas = unidadVentaAbm.traer(idEmpanadas);
		platoAbm.agregar("Empanada de Carne", 800, 300, empanadas);
		platoAbm.agregar("Empanada de Pollo", 800, 300, empanadas);
		platoAbm.agregar("Empanada de Verdura", 750, 280, empanadas);

		// FoodTruck 3: sushi
		long idSushi = unidadVentaAbm.agregarFoodTruck("Sushi On Wheels", 18.0f, "FT00000003", festival, responsable,
				true, "AC789EF");
		System.out.printf("FoodTruck creado, id=%d%n", idSushi);
		UnidadVenta sushi = unidadVentaAbm.traer(idSushi);
		platoAbm.agregar("Combo California x10", 6000, 2500, sushi);
		platoAbm.agregar("Combo Philadelphia x10", 6500, 2800, sushi);

		System.out.println("Platos de ambos FoodTrucks creados.");
	}
}
