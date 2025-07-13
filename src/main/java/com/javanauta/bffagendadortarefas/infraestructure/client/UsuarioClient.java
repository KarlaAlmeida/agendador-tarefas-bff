package com.javanauta.bffagendadortarefas.infraestructure.client;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping("/usuario")
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest);

    @PostMapping("/usuario/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);

    @DeleteMapping("/usuario/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/usuario")
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest,
                                    @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                 @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/endereco")
    EnderecoDTOResponse cadastroEndereco(@RequestBody EnderecoDTORequest enderecoDTORequest,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/telefone")
    TelefoneDTOResponse cadastroTelefone(@RequestBody TelefoneDTORequest telefoneDTORequest,
                                 @RequestHeader("Authorization") String token);
}
