package com.example.demo.repository;

import com.example.demo.entities.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert,Long> {
    @Query("select count(t.referenceTransfert) from Transfert t where t.referenceTransfert like %?1")
    Integer GetReference(String ReferenceT);

    @Query("select t from Transfert t where t.cinC like %?1")
    List<Transfert> getTransfertByCoursier(String username);
}
