# 🚗 Projeto Android: Carro & Motor com TDD e Coroutines

Este projeto foi desenvolvido com o objetivo de praticar **TDD (Test Driven Development)** em um contexto Android, utilizando classes básicas de domínio como `Carro` e `Motor`. A arquitetura inclui **testes unitários**, **testes de aceitação (E2E)** e a utilização de **coroutines com Kotlin Flow**.

---

## ✳️ Principais Conceitos Aplicados

### 🧪 Test Driven Development (TDD)

> Técnica de desenvolvimento onde os testes são escritos **antes** da implementação.

- Ciclo RED → GREEN → REFACTOR.
- Maior entendimento dos requisitos e menor tempo de debug.
- Promove código de alta qualidade, coeso e com baixo acoplamento.
- Possui dois estilos:
  - **Classicista (Chicago)**: foca no resultado final, sem mocks.
  - **Outside-In (Londres)**: foca na interação entre objetos com uso de mocks.

### 🧪 Tipos de Testes Automatizados

| Tipo           | Descrição                                                                 |
|----------------|--------------------------------------------------------------------------|
| Unitário       | Testa métodos isolados. Rápido e confiável.                             |
| Integração     | Testa conjuntos de componentes. Requer dispositivo/emulador.            |
| Aceitação (E2E)| Simula o uso real da aplicação. Mais lento, mas cobre o fluxo completo. |

---

### 🌀 Kotlin Coroutines

> Permite escrever código assíncrono de forma sequencial e não bloqueante.

- `suspend`: pausa a execução sem travar a thread principal.
- `withContext(Dispatchers.IO)`: troca de contexto para tarefas pesadas ou de I/O.
- Usa **Structured Concurrency** para controle e rastreio das tarefas assíncronas.
- `launch` para tarefas que não retornam valor; `async` para obter resultados com `await`.

---

### 🌊 Kotlin Flow

> Stream reativo baseado em coroutines — semelhante ao LiveData ou Observable.

- **Cold Stream**: só emite dados quando é coletado.
- Fluxo: Emissor (ex: banco ou API) → Flow → Coletor (ex: ViewModel/Repository).
- Suporta **backpressure**, **concorrência estruturada** e **valores nulos**.
- Ideal para lidar com streams contínuos de dados (como temperatura do motor, por exemplo).

---

## ✅ O que foi implementado

- Modelos simples de `Engine` (Motor) e `Car` (Carro).
- Testes unitários e de aceitação seguindo Outside-In TDD.
- Implementação de coroutines com `delay` e `Flow` simulando aquecimento do motor.
- Testes de fluxo com Kotlin Flow e coroutines usando `runTest`.

---

## 📂 Estrutura Básica

```
├── model/
│   ├── Engine.kt
│   └── Car.kt
├── test/
│   ├── acceptanceTests/
│   │   └── CarFeature.kt
│   ├── unitTests/
│   │   ├── CarShould.kt
│   │   └── EngineShould.kt
│   └── utils/
│   │   └── MainCoroutineScopeRule.kt
```
