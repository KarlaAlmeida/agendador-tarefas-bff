package com.javanauta.bffagendadortarefas.infraestructure.client.config;

import com.javanauta.bffagendadortarefas.infraestructure.exceptions.BusinessException;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.ConflictExceptions;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.ResourceNotFoundException;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.UnauthorazedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        String mensagem = mensagemErro(response);

        switch (response.status()){
            case 409:
                return new ConflictExceptions("Erro: " + mensagem);
            case 403:
                return new ResourceNotFoundException("Erro: " + mensagem);
            case 401:
                return new UnauthorazedException("Erro: " + mensagem);
            case 400:
                return new UnauthorazedException("Erro: " + mensagem);
            default:
                return new BusinessException("Erro: " + mensagem);
        }
    }

    public String mensagemErro(Response response){

        if(Objects.isNull(response.body())){
            return "";
        }
        try {
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
