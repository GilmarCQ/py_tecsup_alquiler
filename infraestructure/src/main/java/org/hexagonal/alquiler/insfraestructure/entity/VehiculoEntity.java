package org.hexagonal.alquiler.insfraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

//    @Column(name = "codigo", nullable = false, length = 3)
//    private String codigo;

    @Column(name = "placa", nullable = false, length = 7)
    private String placa;

    @Column(name = "asientos", nullable = false)
    private Long asientos;

    @Column(name = "anioFabricacion", nullable = false, length = 4)
    private String anioFabricacion;

    @Column(name = "color", length = 100)
    private String color;

    @Column(name = "transmision", length = 1)
    private String transmision;

    @Column(name = "costo_hora_alquiler")
    private Float costoHoraAlquiler;

    @Column(name = "costo_dia_alquiler")
    private Float costoDiaAlquiler;

    @Column(name = "descripcion", nullable = false, length = 30)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_combustible", referencedColumnName = "id_tipo_combustible")
    private TipoCombustibleEntity tipoCombustible;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_vehiculo")
    private TipoVehiculoEntity tipoVehiculo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    private MarcaEntity marca;

}
