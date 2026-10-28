# Sistema Automotivo — API REST

Projeto acadêmico de backend para cadastro e gerenciamento de veículos, desenvolvido com Java e Spring Boot.

## Objetivo

Praticar organização de uma aplicação backend em camadas e implementar operações CRUD (criar, consultar, atualizar e excluir) para veículos.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Estrutura do código

- `controller/VeiculoController.java`: expõe os endpoints HTTP.
- `service/VeiculoService.java`: concentra a lógica de acesso e operações.
- `repository/VeiculoRepository.java`: acesso aos dados.
- `model/Veiculo.java`: entidade de veículo.
- `src/main/resources/application.properties`: configuração da aplicação e conexão com o banco.

## Endpoints implementados no controller

Base: `/api/veiculos`

| Método | Rota | Finalidade |
|---|---|---|
| GET | `/api/veiculos` | Listar veículos |
| POST | `/api/veiculos` | Cadastrar veículo |
| PUT | `/api/veiculos/{id}` | Atualizar veículo |
| DELETE | `/api/veiculos/{id}` | Excluir veículo |

O controller retorna `404 Not Found` quando tenta atualizar ou excluir um veículo que não existe. Para validar os endpoints, consulte também o arquivo `src/main/java/com/sistema/automotivo/testes.http`.

## Configuração do banco de dados

1. Instale e inicie o MySQL.
2. Crie um banco chamado `sistema_automotivo` ou permita que a configuração o crie.
3. Configure as variáveis de ambiente `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` para o seu ambiente.
4. Nunca publique senhas reais, tokens ou outros segredos no repositório.

A configuração utiliza variáveis de ambiente para evitar credenciais fixas no código.

## Estado atual e próximos passos

Este é um projeto de estudo em evolução. Antes de considerar a aplicação pronta para execução por outras pessoas, confira se o arquivo de build Maven (`pom.xml`) está presente na versão atual, valide a configuração local do MySQL e execute os testes.

Melhorias planejadas:
- Documentar exemplos de requisições e respostas.
- Adicionar validação dos dados recebidos.
- Ampliar os testes automatizados para os cenários de sucesso e erro.
- Documentar códigos HTTP e possíveis falhas de banco de dados.

## Finalidade

Projeto educacional para praticar Java, APIs REST, CRUD e persistência de dados. Não representa um sistema de produção.
