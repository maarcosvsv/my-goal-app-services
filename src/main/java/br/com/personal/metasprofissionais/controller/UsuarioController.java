package br.com.personal.metasprofissionais.controller;

import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.entity.Perfil;
import br.com.personal.metasprofissionais.entity.Setor;
import br.com.personal.metasprofissionais.entity.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @GetMapping(value = "/list")
    public List<Usuario> getUsuarios() {
        Perfil p = new Perfil();
        p.setId(125L);
        p.setNome("ADMINISTRADOR");

        Setor s = new Setor();
        s.setId(7L);
        s.setNome("Administrativo");

        Usuario usu = new Usuario();
        usu.setPerfil(p);
        usu.setSetor(s);
        usu.setNome("Marcos");

        List<Usuario> retorno = new ArrayList<>();
        retorno.add(usu);

        return retorno;

    }

}