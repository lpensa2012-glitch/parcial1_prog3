package unlar.edu.ar.TP_4.controller;

import unlar.edu.ar.TP_4.dto.SolicitudDto;
import unlar.edu.ar.TP_4.service.AlquilerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alquiler")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @PostMapping("/desbloquear")
    public String desbloquear(@RequestBody SolicitudDto dto) {

        return alquilerService.desbloquear(dto);
    }
}