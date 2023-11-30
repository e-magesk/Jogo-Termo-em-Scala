package Termo

object Termo {

    val GREEN = "\u001B[32m"
    val YELLOW = "\u001B[33m"
    val RESET = "\u001B[0m"

    def formataStringSaida(plv : String, rpt : String): String = {

        var stringFormatada = ""
        val palavra = plv.toUpperCase()
        val resposta = rpt.toUpperCase()

        for (i <- 0 to 4) {
            val caracter = palavra.charAt(i)

            if(caracter == resposta.charAt(i)){
                stringFormatada += GREEN + caracter + " " + RESET
                // print(GREEN + palavra.charAt(i) + " " + RESET)
            }
            else if(resposta.contains(caracter)){
                stringFormatada += YELLOW + caracter + " " + RESET
                // print(YELLOW + palavra.charAt(i) + " " + RESET)
            }
            else{
                stringFormatada += caracter + " "
                // print(palavra.charAt(i) + " ")
            }
        }

        return stringFormatada
    }

    def termoUmaPalavra(resposta : String): Unit = {

        var listaPalavras : List[String]= List();
        var inputString = ""

        for (i <- 1 to 5) {

            var palavraValida = false

            while (palavraValida == false) {
                
                // Solicita ao usuário que insira uma string
                println("\n----------------------------------------------------")
                print("Qual a palavra? ")
                
                // Lê a string do terminal
                inputString = scala.io.StdIn.readLine()
                println("----------------------------------------------------\n")
    
                if (inputString.length != 5 ) {
                    println("A palavra deve ter 5 letras! Tente novamente.\n")
                }
                else{
                    palavraValida = true
                }

            }

            listaPalavras = listaPalavras :+ inputString

            for (j <- 0 to listaPalavras.length - 1) {
                val indice = j + 1
                println(indice + ")\t" + formataStringSaida(listaPalavras(j), resposta))
            }

            // Imprime as linhas ainda nao preenchidas

            for (j <- i+1 to 5){
                println(j + ")\t")
            }

            if(inputString == resposta){
                println("\n----------------------------------------------------")
                println("Parabéns! Você acertou a palavra!")
                println("----------------------------------------------------\n")
                return
            }
        }
        println("\n----------------------------------------------------")
        println("Você perdeu! A palavra era: " + GREEN +  resposta.toUpperCase() + RESET)
        println("----------------------------------------------------\n")
    }
}