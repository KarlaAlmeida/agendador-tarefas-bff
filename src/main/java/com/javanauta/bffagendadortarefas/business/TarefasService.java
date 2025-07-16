package com.javanauta.bffagendadortarefas.business;

import com.javanauta.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bffagendadortarefas.infraestructure.client.TarefasClient;
import com.javanauta.bffagendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient client;

    public TarefasDTOResponse gravarTarefa(TarefasDTORequest tarefasDTORequest, String token){
        return client.gravarTarefas(tarefasDTORequest, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(
            LocalDateTime dataInicial, LocalDateTime dataFinal, String token){
        return client.buscaListaTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token){
        return client.buscaTarefasPorEmail(token);
    }

    public void deletarTarefaPorId(String id, String token){
        client.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token){
        return client.alteraStatusTarefa(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest tarefasDTORequest, String id, String token){
        return client.updateTarefas(tarefasDTORequest, id, token);
    }

}
