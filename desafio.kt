// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario, nivelMinimo: Nivel = Nivel.BASICO) {
    if (conteudos.any { it.nivel >= nivelMinimo }) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    } else {
        println("Não há conteúdos com nível mínimo $nivelMinimo nesta formação.")
        }
    }

}

fun main() {
    val usuario1 = Usuario()
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", nivel = Nivel.INTERMEDIARIO)

    val formacao1 = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))

    formacao1.matricular(usuario1) // Deve imprimir a mensagem de matrícula bem-sucedida
    formacao1.matricular(usuario1) // Deve imprimir a mensagem de usuário já matriculado

    val usuario2 = Usuario()
    formacao1.matricular(usuario2, nivelMinimo = Nivel.INTERMEDIARIO) // Deve imprimir a mensagem de matrícula bem-sucedida

    val formacao2 = Formacao("Formação Avançada", listOf(ConteudoEducacional("Tópicos Avançados", nivel = Nivel.DIFICIL)))
    formacao2.matricular(usuario1, nivelMinimo = Nivel.DIFICIL) // Deve imprimir que não há conteúdos com nível mínimo DIFÍCIL nesta formação
}
