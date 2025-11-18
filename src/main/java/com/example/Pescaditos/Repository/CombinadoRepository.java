package com.example.Pescaditos.Repository;

import com.example.Pescaditos.Model.Combinado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CombinadoRepository extends JpaRepository<Combinado, Integer>{

}

