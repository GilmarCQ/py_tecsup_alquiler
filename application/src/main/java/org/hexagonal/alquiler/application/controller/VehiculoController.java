package org.hexagonal.alquiler.application.controller;

import lombok.RequiredArgsConstructor;
import org.hexagonal.alquiler.domain.aggregates.request.RequestAgregarVehiculo;
import org.hexagonal.alquiler.domain.aggregates.response.HttpResMessage;
import org.hexagonal.alquiler.domain.ports.in.VehiculoServiceIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoServiceIn vehiculoServiceIn;

    @PostMapping("/")
    public ResponseEntity<Object> agregarVehiculo(@RequestBody RequestAgregarVehiculo vehiculo) {
        try {
            return ResponseEntity.status(200).body(vehiculoServiceIn.agregarIn(vehiculo));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(HttpResMessage.builder().message(ex.getMessage()).build());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarVehiculoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(200).body(vehiculoServiceIn.buscarVehiculo(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(HttpResMessage.builder().message(ex.getMessage()).build());
        }
    }
    @GetMapping("/list")
    public ResponseEntity<Object> listarVehiculos() {
        try {
            return ResponseEntity.status(200).body(vehiculoServiceIn.listarTodosIn());
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(HttpResMessage.builder().message(ex.getMessage()).build());
        }
    }

}
