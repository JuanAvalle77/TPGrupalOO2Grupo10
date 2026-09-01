package test;

import datos.FoodTruck;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

/**
 * Caso de Uso ejemplo (Hito 1): FoodTrucks de un festival junto con la
 * cantidad de platos que ofrece cada uno.
 * Combina Herencia (FoodTruck extiende UnidadVenta) y Uno a Muchos
 * (UnidadVenta -> Plato).
 */
public class TestCasoDeUsoFoodTrucks {

	public static void main(String[] args) {

		long idFestival = 1; // ajustar segun el id que haya quedado al correr TestCargarDatosPrueba

		UnidadVentaABM abm = new UnidadVentaABM();

		System.out.printf("FoodTrucks del festival id=%d%n", idFestival);
		for (UnidadVenta u : abm.traerFoodTrucksDeFestival(idFestival)) {
			FoodTruck ft = (FoodTruck) u;
			System.out.printf("- %s (codigo=%s, patente=%s) -> %d platos%n", ft.getNombre(), ft.getCodigo(),
					ft.getPatente(), ft.getPlatos().size());
		}
	}
}
