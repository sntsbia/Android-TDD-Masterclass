# TDD:  Test Driven Development 

## O que é?

1. Cada teste direciona o desenvolvimento da aplicação;
2. [[Glossário#[Testes]( testes)|Testes]] unitários são escritos antes do desenvolvimento do código a ser validado;
3. Define como o desenvolvimento será direcionado;
4. É uma metodologia/processo de desenvolvimento
---

## Vantagens

1. Melhor entendimento dos requisitos do produto;
2. Desenvolvimento mais rápido: tempo salvo em debuging;
3. Código com maior qualidade, com alta coesão e baixo [[Glossário#[Acoplamento]( acoplamento)|acoplamento]];
4. Menos defeitos;
5. Promove cultura de alta qualidade na organização;
6. Herança de conjunto de [[Glossário#[Testes de Regressão](testes-regressao)|testes de regressão]]
7. Escrita de documentação: descrição do que o sistema está fazendo e assegurando que ele funciona;

> Garantimos que a aplicação está cumprindo as condições para serem testados mais facilmente, além de ser mais fácil de ler e manter

> É um processo e independe da plataforma ou tecnologia: como o código é escrito e não tem relação com qual código está sendo escrito em qual domínio

---
## [[Ciclo de Vida.canvas|Ciclo de Vida do TDD]] 

### Red (Vermelho)
-  Escrever teste unitário na intenção de validar uma nova funcionalidade (Inicialmente vai falhar, pois não há código em produção que implemente essa funcionalidade)

### Green (Verde)
- Escrever uma solução mínima do software que faz o teste unitário passar (A ideia não é desenvolver a *feature* inteira, mas fazer o teste passar o mais rápido possível) 
- Focar somente num pedaço da funcionalidade pequeno

### Refactor (Refatoração)
- Elimina possíveis duplicações de código ou *code smells*. Todas as soluções ruins que foram implementadas na etapa anterior deve ser refatorada para corresponder perfeitamente a arquitetura do sistema.
- É um processo interno que pretende melhorar a leitura e manutenção do sistema, mas não deve modificar o funcionamento externo do programa
- Também é necessário refatorar o código de teste e não somente o *production code*


> [!NOTE] 3 Regras do TDD
> 1. Você não deve escrever o *production code* até que tenha escrito um teste unitário de falhas
> 2. Você não deve escrever mais testes unitários que o suficiente para falhar, e não compilar é uma falha 
> 3. Você não deve escrever mais *production code* que o suficiente para passar o teste de falha corrente

---
