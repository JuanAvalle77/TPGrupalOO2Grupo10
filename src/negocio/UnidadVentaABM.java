package negocio;

import java.util.List;

import dao.UnidadVentaDao;
import datos.Festival;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {

	UnidadVentaDao dao = new UnidadVentaDao();

	public int agregarFoodTruck(String nombre, float superficie, String codigo, Festival festival,
			Personal responsable, boolean requiereElectricidad, String patente) {
		FoodTruck ft = new FoodTruck(nombre, superficie, codigo, festival, responsable, requiereElectricidad, patente);
		return dao.agregar(ft);
	}

	public int agregarPuestoDesarmable(String nombre, float superficie, String codigo, Festival festival,
			Personal responsable, int cantidadCarpas, int tiempoMontaje) {
		PuestoDesarmable pd = new PuestoDesarmable(nombre, superficie, codigo, festival, responsable, cantidadCarpas,
				tiempoMontaje);
		return dao.agregar(pd);
	}

	public UnidadVenta traer(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}
}
