package pe.edu.cibertec.Practica.Response;

import pe.edu.cibertec.Practica.Entity.Empleado;

public record EmpleadoFindResponse(String code, String error, Iterable<Empleado> empleados) {
}
