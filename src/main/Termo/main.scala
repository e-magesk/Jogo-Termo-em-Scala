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

        inicializacaoTermo()
        
        while (opcoes.isEmpty == false) {
            var opcaoEscolhida = opcoesJogarTermo(opcoes)
            
            if(opcaoEscolhida == 1){
                termoUmaPalavra("freio")
                opcoes = opcoes.filter(_ != 1)
            }else if(opcaoEscolhida == 2){
                termoDuasPalavras("mente", "areia")
                opcoes = opcoes.filter(_ != 2)
            }else if(opcaoEscolhida == 3){
                termoQuatroPalavras("mente", "areia", "aviao", "monte")
                opcoes = opcoes.filter(_ != 3)
            } else if(opcaoEscolhida == 4){
                println("\nObrigado por jogar! Até mais!\n")
                return
            }
        }

        Thread.sleep(2000) 

        println("Suas partidas terminaram por hoje!")
        println("Obrigado por jogar! Até mais!\n")

    }
}

// https://github.com/ThiagoNelsi/dicio-api
