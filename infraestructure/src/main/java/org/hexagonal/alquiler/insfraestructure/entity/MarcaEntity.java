package org.hexagonal.alquiler.insfraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "marca")
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @Column(name = "codigo", nullable = false, length = 10)
//    private String codigo;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "usua_create", nullable = false, length = 20)
    private String usuaCreate;

    @Column(name = "date_create", nullable = false)
    private Timestamp dateCreate;

    @Column(name = "usua_modif", length = 20)
    private String usuaModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    @Column(name = "usua_delet", length = 20)
    private String usuaDelet;

    @Column(name = "date_delet")
    private Timestamp dateDelet;
}
