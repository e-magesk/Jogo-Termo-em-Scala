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

        // Caminho para o arquivo de palavras em português
        val caminhoArquivo = diretorioAtual + "/src/files/br-sem-acentos.txt"

        // Lê as linhas do arquivo
        val linhas = Source.fromFile(caminhoArquivo, "ASCII").getLines().toList

        // Filtra as palavras com 5 letras
        val palavrasCom5Letras = linhas.filter(palavra => palavra.length == 5)

        // Quantidade de palavras com 5 letras
        val qntdPalavrasCom5Letras = palavrasCom5Letras.length
        
        val random = new Random

        // Soma 1 porque o valor retornato por nextInt é entre 0 e x-1
        val escolhePalavras = (x : Int) => palavrasCom5Letras.apply(random.nextInt(x+1))
        
        // Lista de palavras escolhidas para serem usadas no jogo
        var listaPalavras : List[String] = List()

        // O operador :: gera uma nova lista com o elemento à esquerda do operador adicionado na lista antiga e atribui essa nova lista à variável à esquerda do =.
        for (i <- 0 to 6) {
            listaPalavras = escolhePalavras(qntdPalavrasCom5Letras) :: listaPalavras
        }
        
        println(listaPalavras)

        inicializacaoTermo()

        var opcoes : List[Int] = List(1, 2, 3)

        while (opcoes.isEmpty == false) {
            var opcaoEscolhida = opcoesJogarTermo(opcoes)

            opcaoEscolhida match {
            case 1 => {termoUmaPalavra(listaPalavras.apply(0)); opcoes = opcoes.filter(_ != 1)}
            case 2 => {termoDuasPalavras(listaPalavras.apply(1), listaPalavras.apply(2)); opcoes = opcoes.filter(_ != 2)}
            case 3 => {termoQuatroPalavras(listaPalavras.apply(3), listaPalavras.apply(4), listaPalavras.apply(5), listaPalavras.apply(6)); opcoes = opcoes.filter(_ != 3)}
            case 4 => {println("\nObrigado por jogar! Até mais!\n"); return}
            }
        }

        Thread.sleep(2000)

        println("Suas partidas terminaram por hoje!")
        println("Obrigado por jogar! Até mais!\n")

    }
}
// https://github.com/ThiagoNelsi/dicio-api
