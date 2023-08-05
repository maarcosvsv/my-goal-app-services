package br.com.personal.metasprofissionais.controller;

import br.com.personal.metasprofissionais.entity.Setor;
import br.com.personal.metasprofissionais.service.SetorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

        @Resource
        SetorService setorService;

        @GetMapping(value = "/list")
        public List<Setor> getSetores() {
            return setorService.findAll();
        }

        @PostMapping(value = "/create")
        public void createEmployee(@RequestBody Setor setor) {
            setorService.insertSetor(setor);

        }
        @PutMapping(value = "/update")
        public void updateEmployee(@RequestBody Setor setor) {
            setorService.updateSetor(setor);

        }

        @DeleteMapping(value = "/deleteSetorById")
        public void deleteEmployee(@RequestBody Setor setor) {
            setorService.deleteSetor(setor);

        }

}
