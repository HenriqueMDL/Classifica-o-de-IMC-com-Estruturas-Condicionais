void main() {
    IO.println("SISTEMA DE IMC");
    String menu = """
            MENU
            1 - Calcular IMC.
            0 - Sair.
            """;
// Usei a base do seu exemplo de SwitchCase, professor.
    IO.println(menu);
    String opcaoStr = IO.readln("Digite uma opção: ");
    int opcao = Integer.parseInt(opcaoStr);
// Uso de Switch para opções do menu.
    switch (opcao) {
        case 1:
            IO.println("\nCálculo de IMC.");
// Entrada dos dados.
            String nome = IO.readln("Digite seu nome: ");
            String generoStr = IO.readln("Digite seu gênero (M/F/N): ");
// Failsave para Empty.
            if (generoStr.isEmpty()) {
                IO.println("Gênero inválido!");
                return;
            }
// "O gênero deve ser armazenado em variável do tipo char."
            char genero = generoStr.charAt(0);
// Failsave para valores inválidos.
            genero = Character.toUpperCase(genero);
            if (genero != 'M' && genero != 'F' && genero != 'N') {
                IO.println("Gênero inválido!");
                return;
            }
            double altura = Double.parseDouble(IO.readln("Digite sua altura (ex: 1.75): "));
            double peso = Double.parseDouble(IO.readln("Digite seu peso (kg): "));
// Failsave para altura negativa.
            if (altura <= 0) {
                IO.println("Altura inválida!");
                return;
            }
// Failsave para peso negativo.
            if (peso <= 0) {
                IO.println("Peso inválido!");
                return;
            }
// Cálculo.
            double imc = peso / (altura * altura);
            String classificacao;
            switch (genero) {
// Ifs para classificação masculina.
                case 'M':
                    if (imc < 20) {
                        classificacao = "Abaixo do peso";
                    } else if (imc <= 25) {
                        classificacao = "Peso normal";
                    } else if (imc <= 30) {
                        classificacao = "Sobrepeso";
                    } else if (imc <= 40) {
                        classificacao = "Obesidade";
                    } else {
                        classificacao = "Obesidade grave";
                    }
                    break;
// Ifs para classificação feminina e não explicita.
                case 'F':
                case 'N':
                    if (imc < 19) {
                        classificacao = "Abaixo do peso";
                    } else if (imc <= 24) {
                        classificacao = "Peso normal";
                    } else if (imc <= 29) {
                        classificacao = "Sobrepeso";
                    } else if (imc <= 39) {
                        classificacao = "Obesidade";
                    } else {
                        classificacao = "Obesidade grave";
                    }
                    break;
// Failsave de garantia.
                default:
                    IO.println("Gênero inválido!");
                    return;
            }
// Resultado.
            IO.println("\nResultado:");
            IO.println("Nome: " + nome);
            IO.println("IMC: " + String.format("%.2f", imc));
            IO.println("Classificação: " + classificacao);
            break;
// Saída.
        case 0:
            IO.println("Saindo do sistema.");
            break;
        default:
            IO.println("Opção inválida!");
            break;
// "Imprima no final "Atitus Educação - O lado certo da força!!!" Não vô naum.
    }
}