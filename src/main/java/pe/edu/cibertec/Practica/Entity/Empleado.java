package pe.edu.cibertec.Practica.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "empleado")
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    private  String nombre;

    private String apellido;

    private String direccion;

    //@Column(name = "fecha_nac")
    private Date fechaNac;

    private String profesion;


}
