package test;

import java.time.LocalDate;

import datos.Festival;
import datos.Personal;
import datos.UnidadVenta;
import negocio.DetallesPedidoABM;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonalABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestCargarDatosPrueba {

	public static void main(String[] args) {

		FestivalABM festivalAbm = new FestivalABM();
		PersonalABM personalAbm = new PersonalABM();
		UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
		PlatoABM platoAbm = new PlatoABM();
		PedidoABM pedidoAbm = new PedidoABM();
		DetallesPedidoABM detallesAbm = new DetallesPedidoABM();

		long idFestival = festivalAbm.agregar("Fiesta del Choripán", "Otoño",
				LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 5));
		System.out.printf("Festival creado, id=%d%n", idFestival);

		long idCocinero = personalAbm.agregarCocinero("Juan", "Perez", 30111222, LocalDate.of(1990, 5, 10),
				LocalDate.of(2024, 1, 15), 500000, "juan@mail.com", "Parrilla", 50000);
		System.out.printf("Cocinero creado, id=%d%n", idCocinero);

		Festival festival = festivalAbm.traer(idFestival);
		Personal responsable = personalAbm.traer(idCocinero);

		long idFoodTruck = unidadVentaAbm.agregarFoodTruck("El Fueguito", 15.5f, "FT00000001", festival, responsable,
				true, "AA123BB");
		System.out.printf("FoodTruck creado, id=%d%n", idFoodTruck);
		
		
		UnidadVenta foodTruck = unidadVentaAbm.traer(idFoodTruck);

		long idChoripan = platoAbm.agregar("Choripán", 3500, 1500, foodTruck);
		long idPapas = platoAbm.agregar("Papas Fritas", 2500, 800, foodTruck);
		System.out.printf("Platos creados, ids=%d,%d%n", idChoripan, idPapas);

		long idPedido = pedidoAbm.agregar(LocalDate.of(2026, 9, 1), festival, foodTruck);
		System.out.printf("Pedido creado, id=%d%n", idPedido);

		detallesAbm.agregar(3, platoAbm.traer(idChoripan), pedidoAbm.traer(idPedido));
		detallesAbm.agregar(2, platoAbm.traer(idPapas), pedidoAbm.traer(idPedido));
		System.out.println("Detalles de pedido cargados.");
	}
}
