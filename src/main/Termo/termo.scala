package Termo

object Termo {

    val GREEN = "\u001B[32m"
    val YELLOW = "\u001B[33m"
    val RESET = "\u001B[0m"

    def formataStringSaida(plv : String, rpt : String): String = {

        if(plv == ""){
            return "         "
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

        val chances = 6

        var listaPalavras : List[String]= List();
        var inputString = ""

        for (i <- 1 to chances) {

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

            for (j <- i+1 to chances){
                println(j + ")\t")
            }

            if(inputString == resposta){
                println("\n----------------------------------------------------")
                println("Parabéns! Você acertou a palavra!")
                println("----------------------------------------------------\n")
                Thread.sleep(2000)
                return
            }
        }
        println("\n----------------------------------------------------")
        println("Você perdeu! A palavra era: " + GREEN +  resposta.toUpperCase() + RESET)
        println("----------------------------------------------------\n")
        Thread.sleep(2000)
    }


    def termoDuasPalavras(resposta1 : String, resposta2 : String): Unit = {

        val chances = 7

        var listaPalavras1 : List[String]= List();
        var listaPalavras2 : List[String]= List();
        var inputString = ""
        var palavrasAcertadas : Array[Boolean] = Array(false, false)

        for (i <- 1 to chances) {

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

            for (j <- i+1 to chances){
                println(j + ")\t")
            }

            if(palavrasAcertadas.count(_ == true) == 2){
                println("\n----------------------------------------------------")
                println("Parabéns! Você acertou todas as palavras!")
                println("----------------------------------------------------\n")
                Thread.sleep(2000)
                return
            }
        }
        println("\n----------------------------------------------------")
        println("Você perdeu! As palavras eram: " + GREEN +  resposta1.toUpperCase() + RESET + " e " + GREEN + resposta2.toUpperCase() + RESET)
        println("----------------------------------------------------\n")
        Thread.sleep(2000)
    }

    def termoQuatroPalavras(resposta1 : String, resposta2 : String, resposta3 : String, resposta4 : String): Unit = {

        val chances = 9

        var listaPalavras1 : List[String]= List();
        var listaPalavras2 : List[String]= List();
        var listaPalavras3 : List[String]= List();
        var listaPalavras4 : List[String]= List();
        var inputString = ""
        var palavrasAcertadas : Array[Boolean] = Array(false, false, false, false)

        for (i <- 1 to chances) {

            // Solicita ao usuário que insira uma string

            var palavraValida = false
            while (palavraValida == false) { 
                // Solicita ao usuário que insira uma string
                println("\n----------------------------------------------------------------------")
                print("Qual a palavra? ")
                
                // Lê a string do terminal
                inputString = scala.io.StdIn.readLine()
                println("----------------------------------------------------------------------\n")
    
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

            if(palavrasAcertadas(2) == false){
                listaPalavras3 = listaPalavras3 :+ inputString
            }
            else{
                listaPalavras3 = listaPalavras3 :+ ""
            }

            if(palavrasAcertadas(3) == false){
                listaPalavras4 = listaPalavras4 :+ inputString
            }
            else{
                listaPalavras4 = listaPalavras4 :+ ""
            }

            if(inputString == resposta1){
                palavrasAcertadas(0) = true
            }
            
            if(inputString == resposta2){
                palavrasAcertadas(1) = true
            }

            if(inputString == resposta3){
                palavrasAcertadas(2) = true
            }

            if(inputString == resposta4){
                palavrasAcertadas(3) = true
            }

            for (j <- 0 to listaPalavras1.length - 1) {
                val indice = j + 1
                println(indice + ")\t" + formataStringSaida(listaPalavras1(j), resposta1) + 
                        "\t" + formataStringSaida(listaPalavras2(j), resposta2) + 
                        "\t" + formataStringSaida(listaPalavras3(j), resposta3) +
                        "\t" + formataStringSaida(listaPalavras4(j), resposta4))
            }

            // Imprime as linhas ainda nao preenchidas

            for (j <- i+1 to chances){
                println(j + ")\t")
            }

            if(palavrasAcertadas.count(_ == true) == 4){
                println("\n----------------------------------------------------------------------")
                println("Parabéns! Você acertou todas as palavras!")
                println("----------------------------------------------------------------------\n")
                Thread.sleep(2000)
                return
            }
        }
        println("\n----------------------------------------------------------------------")
        println("Você perdeu! As palavras eram: " + GREEN +  resposta1.toUpperCase() + RESET + ", " +
                GREEN + resposta2.toUpperCase() + RESET + ", " + 
                GREEN + resposta3.toUpperCase() + RESET + " e " +
                GREEN + resposta4.toUpperCase() + RESET)
        println("----------------------------------------------------------------------\n")

        Thread.sleep(2000)
    }


    def inicializacaoTermo() : Unit = {

        println("--------------------------------------------------------")
        println("              Bem vindo ao jogo TERMO!                  ")
        println("--------------------------------------------------------\n")

        println("Descubra as palavras certas. Depois de cada tentativa, as peças mostram o quão perto você está da solução. Por exemplo:\n")
        println(GREEN + "T" + RESET + " " + YELLOW + "E" + RESET + " " + "R" + " " + "M" + " " + "O\n")
        println("A letra \"T\" está na posição correta. A letra \"E\" está na palavra, mas na posição errada. As letras \"R\", \"M\" e \"O\" não estão na palavra.\n")
        println("Para começar a jogar, escolha com quantas palavras deseja começar. Lembre-se, cada modalidade só pode ser jogada uma vez por dia!\n")
    }

    def opcoesJogarTermo(opcoes : List[Int]) : Int = {
        
        var opcaoValida = false
        var opcao = 0

        while (opcaoValida == false) {
            println("----------------------------------------------------")
            println("Escolha uma opção:")
            if(opcoes.contains(1)){
                println("1) Termo com uma palavra")
            }
            else{
                println("1) Termo com uma palavra (Já jogado)")
            }
            if(opcoes.contains(2)){
                println("2) Termo com duas palavras")
            }
            else{
                println("2) Termo com duas palavras (Já jogado)")
            }
            if(opcoes.contains(3)){
                println("3) Termo com três palavras")
            }
            else{
                println("3) Termo com três palavras (Já jogado)")
            }
            println("4) Sair")
            println("----------------------------------------------------")
            print("Opção: ")

            opcao = scala.io.StdIn.readInt()

            if (opcoes.contains(opcao) || opcao == 4) {
                opcaoValida = true
            }
            else{
                println("Opção inválida! Tente novamente.\n")
            }
        }

        return opcao
    }

}