// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var descricao: String = "Sem descrição") {
    val inscritos = mutableListOf<Usuario>()
    val duracao = conteudos.sumOf { it.duracao }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {

    val hmtl  = ConteudoEducacional(nome = "HTML", duracao = 30, nivel = Nivel.BASICO)
    val css = ConteudoEducacional(nome= "CSS", duracao = 30, nivel = Nivel.BASICO)
    val kotlin = ConteudoEducacional(nome = "Kotlin", duracao = 120, nivel = Nivel.INTERMEDIARIO)
    val kubernetes = ConteudoEducacional(nome = "Kubernetes", duracao = 120, nivel = Nivel.DIFICIL)

    val fullstack =  Formacao(nome = "Fullstack Developer", conteudos = listOf(hmtl, css, kotlin, kubernetes))
    fullstack.descricao = "Esse é um curso voltado para desenvolvedores que pretendem ser fullstack "

    val primeiroAluno = Usuario(nome = "David")
    val segundoAluno = Usuario(nome = "Felipe")

    fullstack.matricular(usuario = primeiroAluno)
    fullstack.matricular(usuario = segundoAluno)


    println("${fullstack.inscritos.size} foram matriculado no curso de ${fullstack.nome}" )
    print("descrição: ${fullstack.descricao}, duração: ${fullstack.duracao} minutos")
}
