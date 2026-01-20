package Abstracao

// Classe selada para abstração com possibilidades limitadas
// sealed usamos quando queremos limitar as possibilidades de subclasses, não pode ser instanciada diretamente
sealed class ResultadoOperacao {
    data class Sucesso(val mensagem: String, val codigo: Int) : ResultadoOperacao()
    data class Erro(val mensagem: String, val excecao: Throwable?) : ResultadoOperacao()
    object Carregando : ResultadoOperacao()
}