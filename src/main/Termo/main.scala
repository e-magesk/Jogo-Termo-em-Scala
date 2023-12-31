package Termo

import scala.io.Source
import java.nio.file.Paths
import play.api.libs.json._
import scala.util.Random
import Termo.termoUmaPalavra
import Termo.termoDuasPalavras
import Termo.termoQuatroPalavras
import Termo.inicializacaoTermo
import Termo.opcoesJogarTermo

object main {

    def main(args: Array[String]): Unit = {
        
        // Caminho para o diretório atual
        val diretorioAtual = Paths.get(".").toAbsolutePath.toString

        // // Caminho para o arquivo de palavras em português
        val caminhoArquivo = diretorioAtual + "/src/files/palavras.txt"

        // // // Lê as linhas do arquivo
        val linhas = Source.fromFile(caminhoArquivo, "UTF-8").getLines().toList

        // // // Filtra as palavras com 5 letras
        val palavrasSemAcento = linhas.map(removerAcentos).filter(_.length == 5)

        // Crie uma instância de Random
        val random = new Random   
        val palavrasEscolhidas = random.shuffle(palavrasSemAcento).take(7)

        var opcoes : List[Int] = List(1, 2, 3)

        inicializacaoTermo()
        while (opcoes.isEmpty == false) {
            var opcaoEscolhida = opcoesJogarTermo(opcoes)

            opcaoEscolhida match {
            case 1 => {termoUmaPalavra(palavrasEscolhidas(0)); opcoes = opcoes.filter(_ != 1)}
            case 2 => {termoDuasPalavras(palavrasEscolhidas(1), palavrasEscolhidas(2)); opcoes = opcoes.filter(_ != 2)}
            case 3 => {termoQuatroPalavras(palavrasEscolhidas(3), palavrasEscolhidas(4), palavrasEscolhidas(5), palavrasEscolhidas(6)); opcoes = opcoes.filter(_ != 3)}
            case 4 => {println("\nObrigado por jogar! Até mais!\n"); return}
            }
        }

        Thread.sleep(2000)

        println("Suas partidas terminaram por hoje!")
        println("Obrigado por jogar! Até mais!\n")

    }

    // Função para remover acentos de uma palavra
    // *Faz um extra de substituir ç por c
    def removerAcentos(palavra: String): String = {
        val comAcentos = "áéíóúâêîôûãõç"
        val semAcentos = "aeiouaeiouaoc"

        // Substitui os caracteres acentuados pelos correspondentes sem acentos
        val novaPalavra = palavra.map ( c => {
            val index = comAcentos.indexOf(c)
            if (index != -1) semAcentos.charAt(index)
            else c
        }).mkString

        return novaPalavra
    }

}
// https://github.com/ThiagoNelsi/dicio-api
