insert into endereco (id,cep,logradouro,numero,complemento,bairro,id_cidade,cidade,id_estado,estado) 
values (default,'79833080','Rua A',100,'Ap 201','Vila Boa',5003702,'Dourados',35,'MS');

insert into pessoa (id,tipo,cpf,nome,celular,telefone,email,endereco_id)
values (default,'F','12345678900','João da Silva','47989180000','11988884444','joao@email.com',1);