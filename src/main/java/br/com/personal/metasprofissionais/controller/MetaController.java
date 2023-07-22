package br.com.personal.metasprofissionais.controller;

import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.service.MetaService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

        @Resource
        MetaService metaService;

        @GetMapping(value = "/list")
        public List<Meta> getEmployees() {
            return metaService.findAll();
        }

        @PostMapping(value = "/createMeta")
        public void createEmployee(@RequestBody Meta meta) {
            metaService.insertMeta(meta);

        }
        @PutMapping(value = "/updateMeta")
        public void updateEmployee(@RequestBody Meta meta) {
            metaService.updateMeta(meta);

        }
        @PutMapping(value = "/executeUpdateMeta")
        public void executeUpdateEmployee(@RequestBody Meta meta) {
            metaService.executeUpdateMeta(meta);

        }

        @DeleteMapping(value = "/deleteMetaById")
        public void deleteEmployee(@RequestBody Meta meta) {
            metaService.deleteMeta(meta);

        }

}
