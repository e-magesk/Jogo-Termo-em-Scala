package Termo

import scala.io.Source
import java.nio.file.Paths
import play.api.libs.json._

object main {

    def main(args: Array[String]): Unit = {

        // val diretorioAtual = Paths.get(".").toAbsolutePath.toString

        // // Caminho para o arquivo de palavras em português
        // val caminhoArquivo = diretorioAtual + "/src/files/br-sem-acentos.txt"

        // // // Lê as linhas do arquivo
        // val linhas = Source.fromFile(caminhoArquivo, "ASCII").getLines().toList

        // // // Filtra as palavras com 5 letras
        // val palavrasCom5Letras = linhas.filter(palavra => palavra.length == 5)

        // // // Imprime a lista de palavras com 5 letras
        // palavrasCom5Letras.foreach(println)

        // URL da API pública que você deseja consultar
        val apiUrl = "https://api.dicionario-aberto.net/near/caralho"

        // Realiza a chamada HTTP e obtém a resposta como uma String
        val response = Source.fromURL(apiUrl).mkString

        // Converte a String de resposta para um objeto Json
        // val jsonResponse = Json.parse(response)

        println(s"Resposta da API: $response")
        // Manipula o objeto Json conforme necessário
        // val value = (jsonResponse \ "key").as[String]
        // println(s"Valor da chave 'key': $value")
    }
}

// https://github.com/ThiagoNelsi/dicio-api
