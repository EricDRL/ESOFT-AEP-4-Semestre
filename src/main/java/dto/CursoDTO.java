package dto;

public record CursoDTO(
        String nome,
        String descricao,
        Integer cargaHoraria,
        Long professorId
) {
}
