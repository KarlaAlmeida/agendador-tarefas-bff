package com.javanauta.bffagendadortarefas.infraestructure.exceptions;

public class UnauthorazedException extends RuntimeException {

    public UnauthorazedException(String mensagem){
        super(mensagem);
    }

    public UnauthorazedException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
