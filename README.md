# testePlayListJavaSpringboot
Tecnologias ultilizadas no projeto:
- [JDK 13: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3.6: Necessário para realizar o build do projeto Java](http://mirror.nbtelecom.com.br/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)
- [Banco h2 em memoria ](https://www.h2database.com/html/main.html)
- [SpringBoot 2.3.2](https://spring.io/projects/spring-boot)
## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/socrammol/testePlayListJavaSpringboot
```
### Iniciando
### Construção
#### Back
Para construir o projeto Back com o Maven, executar os comando abaixo:
Acesse a raiz do projeto 
```shell
mvn clean install
```
Apos isso rode um java - jar mais o arquivo gerado 
ou
```shell
mvn spring-boot:run
```
ou pela sua ide de preferencia 
#### Foi gerado um json do postam que se encontra na raiz do projeto
#### para acessar a documentação  
##### Foi ultilizado o OpenApi 1.3.9 , mas existe uma arquivo de configuração para o swagger puro caso queira futuramente efetuar a troca
1. Verssão grafica do swagger [swagger](http://localhost:8080/swagger).
2. Para acessar o json com os dados [json](http://localhost:8080/api-docs).
3. Caso queira baixar o json foramtado em yml [yml](http://localhost:8080/api-docs.yaml).
###### Observaçoes
1. Primeiro tem que se criar um usuario
2. Depois adiciona as musicas
3. Entao Cria as play Lists
Apos esses passos pode-se adicionar musica a playLista remover e buscalas

