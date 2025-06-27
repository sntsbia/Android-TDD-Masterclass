# 🚗 Projeto Android: Carro & Motor com TDD e Coroutines

Este projeto foi desenvolvido com o objetivo de praticar **TDD (Test Driven Development)** em um contexto Android, utilizando classes básicas de domínio como `Carro` e `Motor`. A arquitetura inclui **testes unitários**, **testes de aceitação (E2E)** e a utilização de **coroutines com Kotlin Flow**.

---

## 🧱 Tecnologias Utilizadas

- **Kotlin** com Android SDK
- **MVVM** como padrão arquitetural
- **Hilt** para injeção de dependência
- **Retrofit** para consumo da API
- **Coroutines & Kotlin Flow** para programação assíncrona
- **LiveData / StateFlow** para atualização reativa da interface
- **ViewModel** para gerenciamento de estado e lógica de UI
- **JUnit** e **CoroutineTest** para testes unitários e de aceitação

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
