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
        
        val diretorioAtual = Paths.get(".").toAbsolutePath.toString

        // // Caminho para o arquivo de palavras em português
        val caminhoArquivo = diretorioAtual + "/src/files/br-sem-acentos.txt"

        // // // Lê as linhas do arquivo
        val linhas = Source.fromFile(caminhoArquivo, "ASCII").getLines().toList

        // // // Filtra as palavras com 5 letras
        val palavrasCom5Letras = linhas.filter(palavra => palavra.length == 5)

        // Crie uma instância de Random
        val random = new Random   
        val palavrasEscolhidas = palavrasCom5Letras(random.nextInt(palavrasCom5Letras.length))

        var opcoes : List[Int] = List(1, 2, 3)

// ------------------------------------------- Pega palavra aleatoria
        var listaIndices : List[Int] = List(random.nextInt(palavrasCom5Letras.length),
                                            random.nextInt(palavrasCom5Letras.length),
                                            random.nextInt(palavrasCom5Letras.length),
                                            random.nextInt(palavrasCom5Letras.length))
        var listaPalavras : List[String] = List(palavrasCom5Letras.apply(listaIndices.apply(0)),
                                                palavrasCom5Letras.apply(listaIndices.apply(1)),
                                                palavrasCom5Letras.apply(listaIndices.apply(2)),
                                                palavrasCom5Letras.apply(listaIndices.apply(3)))
        
        println(listaPalavras)

// ------------------------------------------- Pega palavra aleatoria

        inicializacaoTermo()

        while (opcoes.isEmpty == false) {
            var opcaoEscolhida = opcoesJogarTermo(opcoes)

            opcaoEscolhida match {
            case 1 => {termoUmaPalavra(listaPalavras.apply(0)); opcoes = opcoes.filter(_ != 1)}
            case 2 => {termoDuasPalavras(listaPalavras.apply(0), listaPalavras.apply(1)); opcoes = opcoes.filter(_ != 2)}
            case 3 => {termoQuatroPalavras(listaPalavras.apply(0), listaPalavras.apply(1), listaPalavras.apply(2), listaPalavras.apply(3)); opcoes = opcoes.filter(_ != 3)}
            case 4 => {println("\nObrigado por jogar! Até mais!\n"); return}
            }
        }

        Thread.sleep(2000) 

        println("Suas partidas terminaram por hoje!")
        println("Obrigado por jogar! Até mais!\n")

    }
}
// https://github.com/ThiagoNelsi/dicio-api
