package com.javanauta.bffagendadortarefas.infraestructure.client;

import com.javanauta.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bffagendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "tarefas", url = "${tarefas.url}")
public interface TarefasClient {

    @PostMapping("/tarefas")
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest tarefasDTORequest,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/tarefas/eventos")
    List<TarefasDTOResponse> buscaListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping("/tarefas")
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping("/tarefas")
    void deletaTarefaPorId(@RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PatchMapping("/tarefas")
    TarefasDTOResponse alteraStatusTarefa(@RequestParam("status") StatusNotificacaoEnum status,
                                          @RequestParam("id") String id,
                                          @RequestHeader("Authorization") String token);

    @PutMapping("/tarefas")
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest tarefasDTORequest,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);

}
