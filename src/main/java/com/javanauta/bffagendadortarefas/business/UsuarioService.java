package com.javanauta.bffagendadortarefas.business;

import com.javanauta.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javanauta.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bffagendadortarefas.infraestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO loginRequestDTO){
        return client.login(loginRequestDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(UsuarioDTORequest usuarioDTORequest, String token){
        return client.atualizaDadosUsuario(usuarioDTORequest, token);
    }

    public EnderecoDTOResponse atualizaEndereco(EnderecoDTORequest enderecoDTORequest, Long id, String token){
        return client.atualizaEndereco(enderecoDTORequest, id, token);
    }

    public TelefoneDTOResponse atualizaTelefone(TelefoneDTORequest telefoneDTORequest, Long id, String token){
        return client.atualizaTelefone(telefoneDTORequest, id, token);
    }

    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest enderecoDTORequest){
        return client.cadastroEndereco(enderecoDTORequest, token);
    }

    public TelefoneDTOResponse cadastroTelefone(String token, TelefoneDTORequest telefoneDTORequest){
        return client.cadastroTelefone(telefoneDTORequest, token);
    }

}
