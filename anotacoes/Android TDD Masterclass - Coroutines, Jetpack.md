# TDD:  Test Driven Development 

## O que é?

1. Cada teste direciona o desenvolvimento da aplicação;
2. [Testes](Glossario.md#testes) unitários são escritos antes do desenvolvimento do código a ser validado;
3. Define como o desenvolvimento será direcionado;
4. É uma metodologia/processo de desenvolvimento

---

## Vantagens

1. Melhor entendimento dos requisitos do produto;
2. Desenvolvimento mais rápido: tempo salvo em debuging;
3. Código com maior qualidade, com alta coesão e baixo [acoplamento](Glossario.md#acoplamento);
4. Menos defeitos;
5. Promove cultura de alta qualidade na organização;
6. Herança de conjunto de testes de [Regressão](Glossario.md#regressão)
7. Escrita de documentação: descrição do que o sistema está fazendo e assegurando que ele funciona;

> Garantimos que a aplicação está cumprindo as condições para serem testados mais facilmente, além de ser mais fácil de ler e manter

> É um processo e independe da plataforma ou tecnologia: como o código é escrito e não tem relação com qual código está sendo escrito em qual domínio

---

## [Ciclo de Vida do TDD](Ciclo-de-Vida.canvas)

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

## Pré-Condições de testes 
1. Teste deve ser rápido, para ser executado frequentemente
2. Não deve depender de outro, mas sim, ser independente um do outro (Não afetar outros testes)
3. Deve ser "repetível" e reproduzível em qualquer ambiente
4. Deve ter um resultado binário (sucesso ou falha). Não deve haver nenhuma ambiguidade se retornou sucesso ou erro
5. Deve ser escrito no tempo apropriado, ou seja, antes do *production code* que será validado

---

# Tipos de testes automatizados

> [!IMPORTANT] Unit (Unitário)
> Testa um pequeno bloco de código, geralmente em um método;
> Manda certo *input* ao método e espera certo *output*;
> Se o código de teste precisa de mais de 5 ou 6 linhas, é uma dica para refatorar o código. Nesse caso, é provável que está testando muitas coisas ou o código foi desenvolvido sem utilização das melhores práticas de engenharia de software 


> [!IMPORTANT] Integration (Integração) (ou *Instrumentation Tests* para Android)
> Módulos do software são combinados e testados como um grupo;
> Testa se todo um componente da aplicação está cumprindo certos requisitos funcionais;
> Não há limite da quantidade de classes que um teste de integração valida; 
> Precisa de um dispositivo real ou um emulador para ser rodado;

> [!IMPORTANT] End To End (Funcional/de Aceitação) (*E2E testing*)
> Testa o ciclo da aplicação do começo ao fim, simulando o usuário;
> Verifica se a aplicação atende a todos os requisitos funcionais;
> Precisa de um dispositivo real ou um emulador para ser rodado;
> Simula interações do usuários, como clicks em botões ou navegação em menus e verifica se os componentes de interface (*UI*) que estão sendo renderizados são os corretos;


---

## [Google Testing Pyramid](Google-Testing-Pyramid.canvas)

-  **Unit**: Fácil de escrever, roda rápido e indica o erro exato 
- **E2E**: Mais difícil de escrever para aplicações *android*; roda lento (por precisar *buildar* e instalar toda a aplicação no dispositivo) e, como testa todo o cenário do usuário, quando falha, não há como dizer a razão do *bug* imediatamente (precisa debugar a aplicação ou o teste unitário revelar o erro)
	- É bom para testes de regressão


---

