import java.io.File
import java.io.FileReader
import java.io.FileWriter

class Funcionario {
    private val arquivo = File("Funcionários.csv")

    init {
        if (!arquivo.exists()) {
            val cabecalho = FileWriter(arquivo)
            cabecalho.write("Nome | Cargo | Salário\n")

            cabecalho.close()
            println("Uma nova tabela foi criada porque não existia uma.")
        }
    }

    fun cadastrar() {
        println("Digite o nome do funcionário")
        val nome = readLine() ?: return
        println("Digite o cargo do funcionário")
        val cargo = readLine() ?: return
        println("Digite o salário do funcionário")
        val sal = readLine()
        val salario = sal?.toDoubleOrNull() ?: return

        val inserir = "$nome,$cargo,$salario"

        val ler = FileWriter(arquivo, true) // A FALTA DESSE TRUE REMOVIA TODOS DADOS :(

        ler.write("$inserir\n")
        ler.close()

        println("Usuário inserido com sucesso.")
    }

    fun listar() {

        val reader = FileReader(arquivo)

        val linhas = reader.readLines()
        reader.close()

        if (linhas.isEmpty()) {
            println("Nenhum funcionário foi inserido.")
            return
        }
        println("Nome\t| Cargo\t| Salário")
        for (line in linhas) {
            val campos = line.split(',')
            if (campos.size ==3) {
                val nome = campos[0]
                val cargo = campos[1]
                val salario = campos[2]
                println("$nome\t| $cargo\t| $salario")
            }
        }
    }

    fun deletar() {
        println("Digite o nome do funcionário que deseja deletar: ")
        val nome = readLine() ?: return

        val reader = FileReader(arquivo)

        val linhas = reader.readLines().toMutableList()
        reader.close()

        var index = -1

        for((i, dado) in linhas.withIndex() ){
            val campo = dado.split(',')
            if(campo[0] == nome){
                index = i
                break
            }
        }
        if(index == -1 ){
            println("Funcionário não localizado")
            return
        }

        linhas.removeAt(index)
        val ler = FileWriter(arquivo)

        ler.write(linhas.joinToString("\n"))
        ler.close()
    }
}