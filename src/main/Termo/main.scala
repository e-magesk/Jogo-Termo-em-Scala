package Termo

import scala.io.Source
import java.nio.file.Paths
import play.api.libs.json._
import scala.util.Random

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

        println(palavrasEscolhidas)

        loopComReturn()
    }

    def loopComReturn(): Unit = {
        val palavra = "viver"
        val RESET = "\u001B[0m"
        val RED = "\u001B[31m"
        val GREEN = "\u001B[32m"
        val YELLOW = "\u001B[33m"
        val BLUE = "\u001B[34m"

        for (i <- 1 to 5) {

            // Solicita ao usuário que insira uma string
            println("Digite uma string: ")

            // Lê a string do terminal
            val inputString = scala.io.StdIn.readLine()

            if (inputString == "xx" || inputString.length > 5) {
                return // Isso encerrará a função, saindo do loop for
            }

            for (i <- 0 to 5) {
                val caracter = inputString.charAt(i)

                if(caracter == palavra.charAt(i)){
                    print(GREEN + inputString.charAt(i) + " " + RESET)
                }
                else if(palavra.contains(caracter)){
                    print(YELLOW + inputString.charAt(i) + " " + RESET)
                }
                else{
                    print(inputString.charAt(i) + " ")
                }
            }
            println()
            // Resto do código dentro do loop
        }
    }
}

// https://github.com/ThiagoNelsi/dicio-api
