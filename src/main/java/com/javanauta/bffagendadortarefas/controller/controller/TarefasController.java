package com.javanauta.bffagendadortarefas.controller.controller;

import com.javanauta.bffagendadortarefas.business.TarefasService;
import com.javanauta.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bffagendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import com.javanauta.bffagendadortarefas.infraestructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastro de tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

   private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Gravar tarefas de usuários", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest tarefasDTORequest,
                                                            @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(tarefasDTORequest, token));
    }


    @GetMapping("/eventos")
    @Operation(summary = "Buscar tarefas por período", description = "Buscar tarefas no período")
    @ApiResponse(responseCode = "200", description = "Busca de tarefa realizada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Buscar tarefas por email", description = "Buscar tarefas por email")
    @ApiResponse(responseCode = "200", description = "Busca de tarefa realizada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deletar tarefas por id", description = "Deletar tarefas por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token){
        tarefasService.deletarTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas por id", description = "Alterar status de tarefas por id")
    @ApiResponse(responseCode = "200", description = "Status de tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> alteraStatusTarefa(@RequestParam("status") StatusNotificacaoEnum status,
                                                                 @RequestParam("id") String id,
                                                                 @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Atualiza dados de tarefas por id", description = "Atualizar dados de tarefas por id")
    @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Tarefa não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest tarefasDTORequest,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.updateTarefas(tarefasDTORequest, id, token));
    }


}
