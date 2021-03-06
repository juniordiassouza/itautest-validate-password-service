# Validador de senha &nbsp; v1

Serviço responsável por [validar uma senha](http://localhost:8080/api/validator/v1/password).

## Tecnologia

API Rest com framework Spring Boot/JAVA

## Links úteis

|  |  |
| ------ | ------ |
| <img src="https://github.com/juniordiassouza/itautest-validate-password-service/blob/master/src/main/resources/images/openapi%20.png" width="32" height="32"> | [swagger](http://localhost:8080/api/validator/v1/swagger-ui/index.html) <br> [collection](http://localhost:8080/api/validator/v1/v2/api-docs) |

## Como rodar local

Clone o projeto utilizando uma plataforma de desenvolvimento (IDE), como por exemplo IntelliJ.

Link Clone: https://github.com/juniordiassouza/itautest-validate-password-service.git

Para startar clique em "Run Application" ou "Debug".

<img src="https://github.com/juniordiassouza/itautest-validate-password-service/blob/master/src/main/resources/images/tela.png">

Para testes starte a aplicação e utilize links úteis (Swagger) disposto neste documento.

## Projeto

Disposição de diretórios: respeitando a estrutura do projeto Spring Boot.

Função: (br.com.itautest.services.utils.ValidatePasswordUtils) Utilizamos Regex para validação de cada um dos padrões de senha exigidos na descrição do projeto e também uma função do JAVA (stream) que é responsável por passar por todas validações Regex, verificando todas as premissas de validação da senha.  
No caso da validação de caracteres repetidos, utilizamos uma função do próprio JAVA para tratamento de Strings.

Testes: Conforme determinado na especificação do projeto, foram testadas todas as classes(MockitoJUnitRunner) e também o projeto como um todo(SpringRunner).

# Diagrama

<img src="https://github.com/juniordiassouza/itautest-validate-password-service/blob/master/src/main/resources/images/diagrama.png">
