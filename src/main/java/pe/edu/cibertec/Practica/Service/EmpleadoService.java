package pe.edu.cibertec.Practica.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Practica.Entity.Empleado;
import pe.edu.cibertec.Practica.Repository.RepositoryInterface;
import pe.edu.cibertec.Practica.Response.EmpleadoAddResponse;
import pe.edu.cibertec.Practica.Response.EmpleadoDeleteResponse;
import pe.edu.cibertec.Practica.Response.EmpleadoFindResponse;
import pe.edu.cibertec.Practica.Response.EmpleadoUpdateResponse;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoService {


    @Autowired
    RepositoryInterface repositoryInterface;


    @PostMapping ("/add")

    public EmpleadoAddResponse empleadoadd(@RequestBody Empleado empleado){

        if (empleado.getIdEmpleado()!=null){
            return new EmpleadoAddResponse("99","Error Id no valido");
        }

        repositoryInterface.save(empleado);


        return new EmpleadoAddResponse("01","Agregado Correctamente");

    }

    @GetMapping("/find")
    public EmpleadoFindResponse findempleado(@RequestParam(value = "id",defaultValue = "0")Integer id){


        Iterable<Empleado> empleados=null;

        if (id>0){
           empleados= repositoryInterface.findAllById(List.of(id));
        }else {
            empleados= repositoryInterface.findAll();
        }



        return new EmpleadoFindResponse("01",null,empleados);
    }


    @PostMapping("/update")
    public EmpleadoUpdateResponse updateEmpleado(@RequestBody Empleado empleado){


        //Esta línea de código está verificando si un usuario con un
        // determinado ID existe en el repositorio
        if (!repositoryInterface.findById(empleado.getIdEmpleado()).isPresent()){
            return new EmpleadoUpdateResponse("99","Error usuario no existe");
        }

        repositoryInterface.save(empleado);

        return new EmpleadoUpdateResponse("01",null);
    }



    @PostMapping("/delete")
    public EmpleadoDeleteResponse empladodelete(@RequestBody Empleado empleado){

        if (!repositoryInterface.findById(empleado.getIdEmpleado()).isPresent()){
            return new EmpleadoDeleteResponse("99","Usuario no encontrado");
        }

        repositoryInterface.delete(empleado);

        return new EmpleadoDeleteResponse("01",null);
    }







}
