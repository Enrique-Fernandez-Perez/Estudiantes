package com.example.appBack.lineaFact.repositorio;

import com.example.appBack.cabeceraFact.clase.CabeceraFact;
import com.example.appBack.cliente.clase.Cliente;
import com.example.appBack.lineaFact.clase.LineaFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineaFactRepository extends JpaRepository<LineaFact,Integer> {
    /*@Query("SELECT L.ID_LIN_FACT , L.CANTIDAD, L.PRECIO , L.ID_CAB_FACT , L.ID_PRODUCTO   FROM LINEA_FACT as L INNER JOIN CABECERA_FACT" +
            " ON CABECERA_FACT.ID_CAB_FACT =L.ID_CAB_FACT WHERE CABECERA_FACT.ID_CLIENTE = :id")
    List<LineaFact> lineaFactPorIdCliente(@Param("id") int id);*/
    List<LineaFact> findByCabFact(CabeceraFact cabFact);
}
