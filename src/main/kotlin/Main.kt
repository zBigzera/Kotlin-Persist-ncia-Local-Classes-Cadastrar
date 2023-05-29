//Desenvolvam uma aplicação em linha de comando que automatiza o cadastro de funcionários de uma empresa.
//
//Essa aplicação deve utilizar persistência local, de modo que, ao encerrá-la, os funcionários que foram cadastrados não sejam deletados.
//Essa aplicação deve possibilitar o cadastro de um funcionário, solicitando o nome, o cargo e o salário deste.
//Além disso, ela deve listar todos os funcionários, exibindo o nome, o cargo e o salário de cada um. Em acréscimo, ela também deve permitir a exclusão de funcionários específicos por meio de uma pesquisa por nome.
//
//Essa atividade é individual e o projeto tem que ser desenvolvido na ferramenta IntelliJ Community Edition.
//
//Após finalizar a codificação, vocês deverão converter a pasta do projeto em formato .zip e anexar nessa atividade.
//
//Sobre a forma de avaliação, a  nota será divida por funcionalidade:
//- (2 pontos) Cadastrar funcionário;
//- (2 pontos) Listar todos os funcionários;
//- (3 pontos) Deletar funcionário;
//- (1 ponto) Experiência do usuário;
//- (2 pontos) Persistência local;
//
//- Bônus (1 ponto): Uso de POO: Estruturas e abstrações.

fun main() {
    while(true){
        println("Selecione a opção desejada:")
        println("1 - Listar Funcionários")
        println("2 - Cadastrar Funcionário")
        println("3 - Deletar Funcionário")
        println("4 - Sair")

        val opcao = readLine()?.toIntOrNull() ?: continue //verifica se o usuário escreveu alguma coisa, se não tiver escrito o menu é chamado novamente

        when(opcao){
            1-> Funcionario().listar()
            2-> Funcionario().cadastrar()
            3-> Funcionario().deletar()
            4-> return
            else -> println("Opção inválida")
        }
    }
}

