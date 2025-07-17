package com.javanauta.bffagendadortarefas.infraestructure.client.config;

import com.javanauta.bffagendadortarefas.infraestructure.exceptions.BusinessException;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.ConflictExceptions;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.ResourceNotFoundException;
import com.javanauta.bffagendadortarefas.infraestructure.exceptions.UnauthorazedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictExceptions("Erro atributo já existente.");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado.");
            case 401:
                return new UnauthorazedException("Erro usuário não autorizado.");
            default:
                return new BusinessException("Erro de servidor.");
        }
    }
}
