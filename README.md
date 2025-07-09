# erp-minimim
### Desenvolvimento:
Tecnologias: 
- Java 23
- Framework: Spring
- Gerenciador de Dependências: Maven
- BD's: PostgreSQL, H2 Database
- Migração de Banco: Flyway DB
- Segurança: Spring Security, JWT
- Testes: JUnit, Mockito
- Documentaçao: Swagger
- Docker
- ProtoBuf

### Para execução do projeto:
Instalar o Java23, Maven e o Docker
Na raiz do projeto, executar no terminal o comando:
```
mvn clean install
```
Depois, para subir o projeto execute:
- Caso queira testar com H2 Database
```
sudo docker compose --profile h2 up
```
- Caso queira Para testar com o Postgres (mais demorado porque baixa uma img docker Postgres)
- Caso queira testar com H2 Database
```
sudo docker compose --profile pg up
```
### Para testes dos endpoints:
O app fora pensando para simular um BFF (Back-end for Front-end) com uma camada de segurança

Caso queira conferir os payloads a serem enviados aos endpoint, consulte pela doc:
```
http://localhost:8083/swagger-ui.html
```

Para agilizar, voce pode baixar o app Insomnia e, na raiz do projeto, importar o arquivo insomnia_endpoints.yaml
Ou pode via curl pelo terminal executar requisiçoes conforme a seguir.

Para gerar o token de usuario:
```
curl -X POST http://localhost:8083/auth/login -H "Content-Type: application/json" -d '{"username":"brunobatista","password":"brunobatista"}'
```
Pegue o token gerado e, no header das proximas requisiçoes, substitua a palavra <TOKEN> pelo codigo token que vc copiou.

Para gerar novos registros de pessoas:
```
curl -X POST http://localhost:8080/pessoa -H "Content-Type: application/json" -H "Authorization: Bearer <TOKEN>" -d '{
	"tipo": "J",
	"cnpj": "12345678900",
	"cpf": "12345678900",
	"nome": "João da Silva",
	"celular": "11988884444",
	"telefone": "1133543322",
	"email": "joao@email.com",
	"endereco": {
		"cep": "79833080",
		"logradouro": "Rua A",
		"numero": 100,
		"complemento": "Ap 201",
		"idCidade": 5003702,
		"cidade": "Dourados",
		"bairro": "Vila Oliveira",
		"idEstado": 35,
		"estado": "Mato"
	}
}'
```

Para listar pessoas:
```
curl http://localhost:8083/pessoa/list -H "Authorization: Bearer <TOKEN>"
```

Para listar pessoas UTILIZANDO PROTOBUF (e comparar desempenho):
```
curl http://localhost:8083/pessoa/listbyproto -H "Authorization: Bearer <TOKEN>"
```

Para apagar registros:
```
curl -X DELETE http://localhost:8083/pessoa/{id} -H "Authorization: Bearer <TOKEN>"
```

### POSSÍVEIS MELHORIAS:
- [ ] Considerar uso de pageable para listagens paginadas