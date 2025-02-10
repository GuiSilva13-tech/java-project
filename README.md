# Java Employee Management System

## Overview
Este projeto é um aplicativo Java desenvolvido para gerenciar registros de funcionários. Permite a inserção, remoção e gerenciamento de dados de funcionários, incluindo reajustes salariais e agrupamento por função. A aplicação é estruturada utilizando princípios orientados a objetos, com classes representando pessoas em geral e funcionários específicos.

## Features
1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3 – Deve conter uma classe Principal para executar as seguintes ações:
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
3.2 – Remover o funcionário “João” da lista.
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
• informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
3.6 – Imprimir os funcionários, agrupados por função.
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
3.10 – Imprimir a lista de funcionários por ordem alfabética.
3.11 – Imprimir o total dos salários dos funcionários.
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.