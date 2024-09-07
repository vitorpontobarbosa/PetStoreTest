# Projeto de automação de testes de API (PetStore) 
- Tecnologias utilizadas: Java - Rest Assured - TestNG
- Padrão de projeto: Builder Pattern
A escolha desse padrão foi feita por sua praticidade em facilitar futuras evoluções no projeto. Ele simplifica a criação de novas requisições e endpoints, evitando a necessidade de passar muitos parâmetros nos construtores, tornando o código mais flexível, de facil manutenibilidade e reaproveitamento de código.



## Explicação da estrutura
* API: Toda a estrutura de criação de payloads e requests ficam aqui. 

     Builders: Estrutura responsável pela construção dos Payloads quando necessário. Futuramente irei implementar uma maneira onde ele consiga gerar um payload basico com os itens obrigatórios. 

     EndPoints: Esta pasta contém classes que representam os endpoints da API e suas devidas requests.
  
     Factory: Esta pasta contém itens úteis para todo o projeto.


- RequestFactory reponsavel por definir alguns parametros padrões para todas as requests.
- GeneratorUtils é um gerador de string aleatória, mas futuramente pode ser necessário a inclusão de novas maneiras de manipular variáveis, e é aqui que será feita.
- Enviroment aqui será possível encontrar variaveis utilizadas em todo o projeto.
* Tests: Responsável por manter todos os testes organizados, separados por entidades. A partir dessa classe, chamamos todas as outras para criar uma request, enviar-la e verificamos seu retorno.
#


*Lembrete: Após baixar o projeto, atualizar as referencias maven.









