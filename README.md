# Projeto Impressora Elgin

## Sobre o projeto

Este projeto foi feito em Java para um trabalho de Programação Orientada a Objetos. O objetivo é criar um sistema que permita cadastrar e fazer login de usuários, além de utilizar algumas funções de uma impressora Elgin.

## Tecnologias utilizadas

- Java
- Biblioteca JNA 5.15.0
- Visual Studio Code
- Git e GitHub

## Organização dos arquivos

- `Main.java`: inicia o programa.
- `Menu.java`: mostra as opções do sistema.
- `Cadastro.java`: realiza o cadastro de usuários.
- `Usuario.java`: controla o login.
- `Impressora.java`: contém as funções da impressora.
- `ImpressoraDLL.java`: faz a ligação entre o Java e a DLL da impressora.

## Como executar

Para executar o projeto, é necessário ter o Java JDK instalado e a biblioteca JNA 5.15.0 na pasta do projeto.

No terminal, dentro da pasta do projeto, execute:

```bash
javac -cp ".:libs Java/jna-5.15.0.jar" *.java
```

Depois, execute:

```bash
java -cp ".:libs Java/jna-5.15.0.jar" Main
```

**Observação:** a DLL fornecida é para Windows. Para utilizar a impressora física, é necessário executar o projeto em um ambiente compatível com ela.

## Como utilizar

1. Ao iniciar, o programa mostra o menu principal.
2. Primeiro, escolha a opção de cadastro.
3. Crie um usuário e uma senha.
4. Depois, faça o login com os dados cadastrados.
5. Após entrar, será possível acessar as opções da impressora.

O sistema permite até três tentativas de login.

## Funções disponíveis

- Configurar conexão com a impressora.
- Abrir e fechar conexão.
- Imprimir textos.
- Imprimir QR Codes.
- Imprimir códigos de barras.
- Imprimir XML SAT.
- Imprimir XML de cancelamento SAT.
- Abrir gaveta.
- Emitir sinal sonoro.
- Avançar papel.
- Consultar o status da impressora.

## Tratamento de erros

O programa também verifica algumas situações, como opções inválidas, login incorreto, arquivos XML não encontrados e tentativas de utilizar a impressora sem abrir a conexão.

## Integrantes

- NIcolas Gomes
- Gustavo Brito
