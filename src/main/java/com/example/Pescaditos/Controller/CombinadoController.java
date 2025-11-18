package com.example.Pescaditos.Controller;


import com.example.Pescaditos.Model.Combinado;
import com.example.Pescaditos.Service.CombinadoService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

import java.util.List;
@RestController
@RequestMapping("/api/combinado")
public class CombinadoController {
    private final CombinadoService combinadoService;

    public CombinadoController(CombinadoService combinadoService){
        this.combinadoService = combinadoService;
    }

    @GetMapping
    public List<Combinado> obtenerCombinados(){
        return combinadoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combinado>
    obtenerCombinadoPorId(@PathVariable Integer id){
        return combinadoService.buscarPorID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<?> crearCombinado(@RequestBody Combinado combinado){
        if(combinado.getNombre()== null || combinado.getNombre().trim().isEmpty()){
            return ResponseEntity.badRequest().body("el nombre es obligatorio");
        }

        if(combinado.getPrecio()== null ){
            return ResponseEntity.badRequest().body("el precio es obligatorio");
        }

        if (!combinado.isDisponible()) {
            return ResponseEntity.badRequest().body("la disponibilidad es obligatoria");
        }

        if(combinado.getCategoria() == null){
            return ResponseEntity.badRequest().body("la categoria es obligatoria");
        }
        return ResponseEntity.ok(combinadoService.crearCombinado(combinado));

    }

}

