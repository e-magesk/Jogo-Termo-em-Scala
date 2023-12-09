<h1 align="center">Jogo-Termo-em-Scala</h1>

## Sobre o jogo

Termo é um jogo de puzzle disponível em https://term.ooo/. Suas regras são simples: há uma palavra de 5 letras desconhecida e deve-se descobrí-la em até 6 tentativas. A cada tentativa, as cores de cada letra mostram o quão perto você está da solução:
* Se estiver verde, a letra pertence à palavra está na posição correta;
* Se estiver amarela, a letra pertence à palavra mas não está na posição correta;
* Se estiver preta, a letra não pertence à palavra.

## Sobre o projeto

Este projeto é fruto do último trabalho da disciplina de Paradigmas de Programação e tem como objetivo criar uma cópia simplificada do Termo aplicando conceitos de programação funcional discutidos ao longo da disciplina. Para isso, fizemos uso da linguagem de programação Scala e da sua ferramenta de desenvolvimento SBT.

## Como executar nosso Termo:

Primeiramente, obtenha o jogo. Para isso pode-se:
* Clonar o repositório em que ele se encontra com um dos comandos abaixo:
```sh
git clone https://github.com/e-magesk/Jogo-Termo-em-Scala.git
```
```sh
git clone git@github.com:e-magesk/Jogo-Termo-em-Scala.git
```
* Baixar o arquivo .zip a partir do conteúdo da branch main através do link https://github.com/e-magesk/Jogo-Termo-em-Scala e extrair o conteúdo do arquivo baixado.

Note que é necessário fazer apenas um dos dois: clonar o repositório ou baixar  o arquivo .zip


Após isso, para que se possa executar o nosso Termo devidamente, precisa-se certificar de que possui ao menos esses 3 pré-requisitos:
* Deve-se ter o Scala instalado. Este pode ser obtido seguindo-se as instruções de instalação em https://www.scala-lang.org/download/
* Deve-se ter o SBT instalado. Este pode ser obtido seguindo-se as instruções de instalação em https://www.scala-sbt.org/download.html
* Deve-se ter o Java instalado. Este pode ser obtido seguindo-se as instruções de instalação em https://www.java.com/pt-BR/

Após ter todos os pré-requistos atendidos, deve-se abrir o diretório raiz do jogo em seu terminal e executar os seguintes comandos:

O comando abaixo inicia o shell interativo do SBT (Scala Build Tool)
```sh
sbt
```
O comando abaixo compila (caso hajam alterações nos arquivos desde a última compilação) e executa o jogo
```sh
run
```

Note que algum dos comandos acima pode demorar um pouco quando executado pela primeira vez a depender da máquina e da velocidade da conexão à internet. Isso ocorre devido às instalações de dependências inerentes à execução do programa que são realizadas.

## Licença

Esse projeto está sob a licença MIT. Confira `LICENSE` para mais informações.

## Contato

Eduarda Pylro Magesk - eduarda.magesk@edu.ufes.br

Vinicius Nunes Pereira - vinicius.pereira.10@edu.ufes.br

Link do projeto: https://github.com/e-magesk/Jogo-Termo-em-Scala