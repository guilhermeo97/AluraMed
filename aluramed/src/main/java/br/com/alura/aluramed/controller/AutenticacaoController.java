package br.com.alura.aluramed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.aluramed.domain.usuario.DadosAutenticacao;
import br.com.alura.aluramed.domain.usuario.Usuario;
import br.com.alura.aluramed.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }



    // @PostMapping("/login/new")
    // public ResponseEntity cadastrar(@RequestBody @Valid DadosAutenticacao dados){
    //     var senhaBCrypt = encoder.encode(dados.senha());
    //     var usuario = new Usuario(new DadosAutenticacao(dados.login(), senhaBCrypt));
    //     repository.save(usuario);
    //     return ResponseEntity.ok().build();
    // }

    @PostMapping("login")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAutenticacao dados){
        var usuario = new Usuario(new DadosAutenticacao(dados.login(), dados.senha()));
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
