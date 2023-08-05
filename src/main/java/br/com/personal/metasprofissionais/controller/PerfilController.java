package br.com.personal.metasprofissionais.controller;

import br.com.personal.metasprofissionais.entity.Perfil;
import br.com.personal.metasprofissionais.service.PerfilService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Resource
    PerfilService perfilService;

    @GetMapping(value = "/list")
    public List<Perfil> getPerfis() {
        return perfilService.findAll();
    }

    @PostMapping(value = "/create")
    public void createPerfil(@RequestBody Perfil perfil) {
        perfilService.insertPerfil(perfil);
    }
    @PutMapping(value = "/update")
    public void updatePerfil(@RequestBody Perfil perfil) {
        perfilService.updatePerfil(perfil);
    }

    @DeleteMapping(value = "/deletePerfilById")
    public void deletePerfil(@RequestBody Perfil perfil) {
        perfilService.deletePerfil(perfil);
    }

}
