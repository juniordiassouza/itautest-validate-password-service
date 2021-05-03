# Validador de senha de Senha &nbsp; v1

Serviço componente do [comunicador](http://localhost:8080/api/validador/v1/swagger-ui/index.html) responsável pelo processamento de templates de e-mail.

Outros dois serviços são responsáveis pelo processamento de e-mails:
1. [comunicador-email-attachments v2](http://localhost:8080/api/validador/v1/swagger-ui/index.html)
2. [comunicador-email-sender v2](http://localhost:8080/api/validador/v1/swagger-ui/index.html)

## Links úteis

|  |  |
| ------ | ------ |
| <img src="https://github.com/juniordiassouza/itautest-validate-password-service/tree/master/src/main/resources/images/openapi.png" width="32" height="32"> | [swagger](http://localhost:8080/api/validador/v1/swagger-ui/index.html) <br> [collection](http://localhost:8080/api/validador/v1/swagger-ui/index.html) |

## Como rodar local

Clone o projeto e utilize [estes valores]() como VM argumets  
**Atenção:** para não haver concorrência ao escutar filas, utilize uma fila que já não está sendo escutada 

## Recursos AWS <img src="https://gitlab.sharedservices.local/crm/comunicador/util/-/raw/master/images/terraform.png" width="32" height="32">
> Filas em UAT para validação de novas features do comunicador não impactar o ambiente estável de HML

|     |  |  |  |
| ------ | ------ | ------ | ------ |

# Desenho

<img src="">
