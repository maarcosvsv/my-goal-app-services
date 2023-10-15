package br.com.personal.metasprofissionais.controller;

import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.service.MetaService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {

        @Resource
        MetaService metaService;

        @GetMapping(value = "/list")
        public List<Meta> getMetas() {
            return metaService.findAll();
        }

        @PostMapping(value = "/createMeta")
        public ResponseEntity<String> insertMeta(@RequestBody Meta meta) {
            try {
                // Lógica para inserir a meta no banco de dados usando o metaService
                metaService.insertMeta(meta);

                // Se a inserção for bem-sucedida, você pode responder com HttpStatus.CREATED (201)
                return new ResponseEntity<>("Meta criada com sucesso", HttpStatus.CREATED);
            } catch (Exception e) {
                // Em caso de falha, você pode responder com um status de erro, como HttpStatus.INTERNAL_SERVER_ERROR (500)
                return new ResponseEntity<>("Erro ao criar a meta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PutMapping(value = "/updateMeta")
        public void updateMeta(@RequestBody Meta meta) {
            metaService.updateMeta(meta);

        }
        @PutMapping(value = "/executeUpdateMeta")
        public void executeUpdateMata(@RequestBody Meta meta) {
            metaService.executeUpdateMeta(meta);

        }

        @DeleteMapping(value = "/deleteMetaById")
        public void deleteMetaById(@RequestBody Meta meta) {
            metaService.deleteMeta(meta);

        }

}
