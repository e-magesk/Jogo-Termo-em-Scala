package Termo

object Termo {

    val GREEN = "\u001B[32m"
    val YELLOW = "\u001B[33m"
    val RESET = "\u001B[0m"

    def formataStringSaida(plv : String, rpt : String): String = {

        if(plv == ""){
            return ""
        }

        var stringFormatada = ""
        val resposta = rpt.toUpperCase()
        val palavra = plv.toUpperCase()

        for (i <- 0 to 4) {
            val caracter = palavra.charAt(i)

            if(caracter == resposta.charAt(i)){
                stringFormatada += GREEN + caracter + " " + RESET
            }
            else if(resposta.contains(caracter)){
                stringFormatada += YELLOW + caracter + " " + RESET
            }
            else{
                stringFormatada += caracter + " "
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


    def termoDuasPalavras(resposta1 : String, resposta2 : String): Unit = {

        var listaPalavras1 : List[String]= List();
        var listaPalavras2 : List[String]= List();
        var inputString = ""
        var palavrasAcertadas : Array[Boolean] = Array(false, false)

        for (i <- 1 to 5) {

            // Solicita ao usuário que insira uma string

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

            if(palavrasAcertadas(0) == false){
                listaPalavras1 = listaPalavras1 :+ inputString
            }
            else{
                listaPalavras1 = listaPalavras1 :+ ""
            }

            if(palavrasAcertadas(1) == false){
                listaPalavras2 = listaPalavras2 :+ inputString
            }
            else{
                listaPalavras2 = listaPalavras2 :+ ""
            }

            if(inputString == resposta1){
                palavrasAcertadas(0) = true
            }
            
            if(inputString == resposta2){
                palavrasAcertadas(1) = true
            }

            for (j <- 0 to listaPalavras1.length - 1) {
                val indice = j + 1
                println(indice + ")\t" + formataStringSaida(listaPalavras1(j), resposta1) + "\t" + formataStringSaida(listaPalavras2(j), resposta2))
            }

            // Imprime as linhas ainda nao preenchidas

            for (j <- i+1 to 5){
                println(j + ")\t")
            }

            if(palavrasAcertadas.count(_ == true) == 2){
                println("\n----------------------------------------------------")
                println("Parabéns! Você acertou todas as palavras!")
                println("----------------------------------------------------\n")
                return
            }
        }
        println("\n----------------------------------------------------")
        println("Você perdeu! As palavras eram: " + GREEN +  resposta1.toUpperCase() + RESET + " e " + GREEN + resposta2.toUpperCase() + RESET)
        println("----------------------------------------------------\n")
    }

    

}