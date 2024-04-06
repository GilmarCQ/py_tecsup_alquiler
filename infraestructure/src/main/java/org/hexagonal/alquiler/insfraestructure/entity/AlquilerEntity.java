package org.hexagonal.alquiler.insfraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "alquiler")
public class AlquilerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Long id;

//    @Column(name = "nro_alquiler", nullable = false, length = 10)
//    private String nroAlquiler;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;

    @Column(name = "fecha_fin")
    private Timestamp fechaFin;

    @Column(name = "lugar_recojo", nullable = false, length = 250)
    private String lugarRecojo;

    @Column(name = "latitud_recojo")
    private Double latitudRecojo;

    @Column(name = "longitud_recojo")
    private Double longitudRecojo;

    @Column(name = "tipo", nullable = false, length = 1)
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private Float cantidad;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private VehiculoEntity vehiculo;
}
