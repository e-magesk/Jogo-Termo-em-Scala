package Termo

import scala.io.Source
import java.nio.file.Paths
import play.api.libs.json._
import scala.util.Random
import Termo.termoUmaPalavra

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

        termoUmaPalavra("cuspe")
    }
}

// https://github.com/ThiagoNelsi/dicio-api
