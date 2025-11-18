package com.example.Pescaditos.Service;

import com.example.Pescaditos.Model.Combinado;
import com.example.Pescaditos.Repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class CombinadoService {
        private final  CombinadoRepository combinadoRepository;

        public CombinadoService(CombinadoRepository combinadoRepository){
            this.combinadoRepository = combinadoRepository;
        }
        //1. lista de todos los combinados
        public List<Combinado> listarTodas(){
            return combinadoRepository.findAll();
        }
        //2. buscar combinado por id
        public Optional<Combinado> buscarPorID(Integer id){
            return combinadoRepository.findById(id);
        }
        //3. crear combinado
        public Combinado crearCombinado(Combinado combinado){
            return  combinadoRepository.save(combinado);
        }
        //4. actualizar combinado
        public Combinado actualizarCombinado(Integer id, Combinado combinado){
            combinado.setId(id);
            return combinadoRepository.save(combinado);
        }
        //5. eliminar combinado
        public void eliminarCombinado(Integer id){
            combinadoRepository.deleteById(id);
        }
    }
