package dio.web.api.controller.doc;

import dio.web.api.dto.UserCreateDTO;
import dio.web.api.dto.UserUpdateDTO;
import dio.web.api.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Usuários",
        description = "Endpoints responsáveis pelo gerenciamento de usuários"
)
public interface UserControllerDoc {

    @Operation(
            summary = "Criar usuário",
            description = "Cria um novo usuário no sistema e ",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Usuário criado com sucesso",
                            content = @Content(schema = @Schema(implementation = User.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Usuário já possui ID"
                    )
            }
    )
    User create(UserCreateDTO dtoUser);

    @Operation(
            summary = "Atualizar usuário",
            description = "Atualiza os dados de um usuário existente pelo ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Usuário atualizado com sucesso",
                            content = @Content(schema = @Schema(implementation = User.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Usuário não encontrado"
                    )
            }
    )
    User update(Long id, UserUpdateDTO dtoUser);

    @Operation(
            summary = "Excluir usuário",
            description = "Remove um usuário do sistema pelo ID",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Usuário removido com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Usuário não encontrado"
                    )
            }
    )
    void delete(Long id);

    @Operation(
            summary = "Listar usuários",
            description = "Retorna a lista de todos os usuários cadastrados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de usuários",
                            content = @Content(schema = @Schema(implementation = User.class))
                    )
            }
    )
    List<User> findAll();

    @Operation(
            summary = "Buscar usuário por ID",
            description = "Busca um usuário pelo seu ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Usuário encontrado",
                            content = @Content(schema = @Schema(implementation = User.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Usuário não encontrado"
                    )
            }
    )
    User findById(Long id);
}
