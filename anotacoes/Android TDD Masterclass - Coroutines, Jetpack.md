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

## [Ciclo de Vida do TDD](../canvas/Ciclo-de-Vida.canvas)

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

# Pré-Condições de testes 
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

## [Google Testing Pyramid](../canvas/Google-Testing-Pyramid.canvas)

-  **Unit**: Fácil de escrever, roda rápido e indica o erro exato 
- **E2E**: Mais difícil de escrever para aplicações *android*; roda lento (por precisar *buildar* e instalar toda a aplicação no dispositivo) e, como testa todo o cenário do usuário, quando falha, não há como dizer a razão do *bug* imediatamente (precisa debugar a aplicação ou o teste unitário revelar o erro)
	- É bom para testes de regressão

---

## Types of TDD

Os dois tipos concordam que o desenvolvimento baseadon em testes é uma ferramenta efetiva, mas o aplicam de formas diferentes

> [!IMPORTANT] Classicist (Escola de Chicago ou Detroit / Black Box Testing)
> (Uncle Bob)
> Tipo baseado em testes de dentro pra fora  
> Não faz o uso de [mocks](Glossario.md#mocks), mas incluem componentes que são instâncias de objetos reais
> Somente o uso de sistemas *Third Party* e possivelmente o banco de dados da aplicação estão autorizados a serem usados com *mocks*
> Os testes com essa técnica são desenhados para testar somente os resultados finais, e não as implementações
 >O design está emergindo: os testes começam no nível unitário e o design supostamente deve emergir dos testes  
 >Esse tipo de teste somente se importa com o resultado final, independentemente de qual método das classes colaboradoras está sendo chamado
 > 

>[!IMPORTANT] Outside In (Escola de Londres / White Box Testing)
> (Steve Freeman)
>Tipo baseado em interação entre as classes, além do resultado 
>Esse tipo faz uso vasto de objetos *mock*
>Praticamente em cada teste, temos somente uma instância de objeto real sob o teste e todas as outras classes e dependências estão sendo *mockadas*
>Verificamos se a classe sob teste está chamando corretamente os métodos das classes colaboradoras
>*Upfront design* no início do seu ciclo de desenvolvimento: pensamento sobre o design que deveria acomodar a implementação da *feature* de uma maneira *clean* (design pode ser refatorado depois)
>Esse tipo de teste se importa com os métodos que são chamados das classes colaboradoras
>

|             |                                Classicists                                |                                            ==Outside In==                                             |
| :---------: | :-----------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------: |
|  **Pros**   |                       - Refatoração mais rápida<br>                       | ==- É mais fácil rastrear os erros (3)<br>- Upfront design (4)<br>- Reforça o design de arquitetura== |
| **Contras** | - Pode ser difícil encontrar o problema (1)<br>- Cobertura redundante (2) |                                 ==- Pode produzir falsos positivos==                                  |

1. Já que não é feito o uso de *mocks*, testes particulares podem falar para *bugs* que estão escondidos dentro das dependências das classes e não na classe sob teste.  Pode ser difícil rastrear e corrigir os erros
2. Certas partes do código são testadas repetidamente
3. Os testes mais focados e isolados são normalmente produzidos fora da *entity*, então, na maioria dos casos, é bem óbvio o porquê do teste falhar e o que necessita ser corrigido
4. Um bom design não acontece por acidente e reservar um tempo para pensar nele desde o início e refatorá-lo depois pode ajudar muito

---
# [Lifecycle: Outside-In TDD](../canvas/outside-in-tdd-lifecycle.canvas)

O ciclo de vida sempre começa com uma falha no teste de aceitação, que simula um cenário de usuário final. Depois de escrever o primeiro teste de aceitação, inicia-se o ciclo de vida normal em um *loop* até o teste de aceitação virar "*green*".

O objetivo é fazer o teste passar o mais rápido possível. Para isso, pode ser necessário rodar o ciclo interno de TDD várias vezes.

O ciclo interno é rodado para cada componente (*view model*, *repository* e *services*)

Quando há novas implementações, é necessário verificar se o *job* foi finalizado rodando o teste de aceitação até o fim do ciclo interno.

---
# Coroutines

Simplifica o tratamento de código assíncrono aplicando lógicas de *callbacks* de forma a deixar parecido com código síncrono e sequencial, ou seja, a escrita do código será de forma sequencial, mas será executada automaticamente de uma forma *non-blocking*

>[!INFO] SUSPEND
>Pausa a execução da coroutine atual, salvando todas as variáveis locais.
>Por exemplo: se a função for definida com `suspend fun nome_funcao`, não irá bloquear a thread principal na chamada http

> [!INFO] RESUME
> Continua a suspended coroutine de lugar que ela pausou

Quando todas as coroutines na thread principal são *suspended*, ela está livre para fazer outra tarefa.

Mesmo se escrita de forma sequencial (parecendo que são uma requisição blocking), as coroutines vão rodar e impedir que a thread principal seja bloqueada

> [!WARNING] Por default, a coroutine roda na thread principal e `suspend` não significa `background`
> Se usamos `calbacks`, ele não irá bloquear a thread principal até algo chamá-lo, mas uma vez chamado, irá rodar nessa thread a menos que seja explicitado que rode na thread em background
> 

Uma função `suspend` não irá bloquear a main thread a menos que o `resume` seja chamado (que rodará na main e não em background).

É necessário definir o `Dispatcher` apropriado.

## Dispatchers

* Por default, uma `coroutine` usa o `Dispatches.main` e roda na thread principal.
* Se for algum tipo de `input-output` (requisição network ou leitura/escrita em um banco de dados ou arquivo), deve-se usar `Dispatches.IO`. A coroutine rodará em uma thread separada em background 
* Se forem cálculos que são intensivos para CPU, deve-se usar `Dispatcher.Default`

 Obs: `Room`, `Retrofit` e `Volley` lidam com suas próprias threads e não requerem segurança da main explicitamente se usados com Coroutines

> [!IMPORTANT] Main Thread
> ``` {kotlin}
> suspend fun function_name() {
> 	val variable_name = get ("...")
> 	
> 	/** Main Thread */
> 	do_something(variable_name)
> }
> ```

> [!IMPORTANT] Background Thread
> ``` {kotlin}
> suspend fun function_name() {
> 	val variable_name = get ("...")
> 	
> 	/** Se forem cálculos pesados, usar Dispatchers.Default */
> 	 withContext(Dispatchers.IO) {
> 		 /** Background Thread */
> 		 do_something(variable_name)
> 	 }
> }
> ```

## Structured Concurrency
É a combinação de linguagem, `features` e as melhores práticas, que, quando seguidas, ajuda a rastrear todas as tarefas rodando em coroutines.

É util para:

|      **Cancelar Tarefas**       |      **Manter o rastreio**      |     **Sinalizar Erros**     |
| :-----------------------------: | :-----------------------------: | :-------------------------: |
| Quando não são mais necessárias | Da tarefa enquanto está rodando | Quando uma coroutine falhar |

### Coroutine Scope
Kotlin não permite que rotinas técnicas iniciem sem usar um coroutine scope.

Mantém o rastreio das coroutines, mesmo quando são suspensas e pode cancelar todas as coroutines que se iniciaram nele.

* É onde a coroutine roda (Não necessariamente executa a coroutine), para garantir que não haja perda de rastreio.
* É capaz de limpar todas as tarefas que foram iniciadas em uma tela que não são mais relevantes (no caso de troca de tela)

> [!NOTE] Não é possível chamar uma função suspensa de qualquer lugar
> As mecânicas de `suspend` e `resume` necessitam da troca de funções normais para *coroutine functions*

|                                **launch**                                |                                        **async**                                         |
| :----------------------------------------------------------------------: | :--------------------------------------------------------------------------------------: |
| Inicia uma nova coroutine que não retorna um resultado para quem a chama | Inicia uma nova coroutine e permite o retorno do resultado com a função suspensa `await` |


Em quase todo caso, a maneira correta de iniciar uma coroutine de uma chamada de uma função regular é pelo `launch`.

## Kotlin Flow

Uma implementação de especificação de `Stream` reativo feito sob coroutines para Kotlin.

É um `cold stream` de dado (como Live Data ou Observable).

| **Emissor** (BD Room ou um serviço Retrofit) -> expõe um stream de dados (Flow) -> que quando a função for chamada irá emitir a resposta |
| :--------------------------------------------------------------------------------------------------------------------------------------- |

| **Coletor** (classe Repository) -> se inscreve para receber a informação que foi emitido dentro do stream -> processa os dados recebidos pelo emissor |
|:-|

### Vantagens

-> É uma API mais simples.

-> Usa concorrência estruturada: cancelar o scope, cancela a stream, evitando *memory leaks*.

-> Se um emissor emite informação mais rápido que o coletor consegue processar, então o *stream* está colocando emissões extras em uma *queue* a ser processada quando o coletor estiver apto a isso. Essa adição pode oferecer o backpressure, mas precisa usar o *flowable stream* e não um *observable*.

-> Como Flow é baseado em coroutines, sua execução é suspensa e não bloqueia a thread. Isso permite escrever operações customizadas usando *delay* ao invés de *thread.sleep*

-> Oferece o suporte de *nullability*: valores nulos podem ser passados sem a necessidade de adaptá-los






























