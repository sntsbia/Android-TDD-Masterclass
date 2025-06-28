# 📚 Android-TDD-Masterclass

Repositório com **projetos práticos** e **anotações** do curso
["Master Android App Development (Kotlin) with Clean Architecture, TDD, HILT, Espresso & Unit Testing"](https://www.udemy.com/share/103Mhq3@5GTl7c99XZc2NNFIC9XM97I2l-gqh18oPkxRrk8mepJpuali4Sx3F3FaN299wW98Hw==/)

---

## 🚗 Projeto 1: Carro e Motor com TDD e Coroutines

📁 [`projetos/MyFirstUnitTest`](projetos/MyFirstUnitTest/README.md)

Este projeto introduz os fundamentos do **TDD** no Android utilizando Kotlin, aplicando:

- Criação de testes antes do código de produção
- Testes unitários e de aceitação (E2E)
- Coroutines e fluxo assíncrono com Kotlin Flow
- Arquitetura baseada em princípios do Clean Architecture
- Injeção de dependência com Hilt

---

## 🎵 Projeto 2: Groovy - Lista de Playlists com MVVM

📁 [`projetos/Groovy`](projetos/Groovy/README.md)

App Android de lista de **playlists**, utilizando:

- Arquitetura **MVVM**
- Injeção de dependência com **Hilt**
- Comunicação com API REST usando **Retrofit**
- ViewModels com **observers** para atualizar a UI dinamicamente
- Testes **unitários** e **E2E** para garantir a qualidade do código

A API está sendo simulada com o **Mockoon**, e as imagens das playlists foram geradas por IA (Gemini e ChatGPT).

---

## 🧠 Anotações Técnicas

📄 [`anotacoes/Android TDD Masterclass - Coroutines, Jetpack.md`](anotacoes/Android%20TDD%20Masterclass%20-%20Coroutines,%20Jetpack.md)

Resumo dos principais conceitos abordados no curso:

### ✅ TDD (Test Driven Development)

- Red → Green → Refactor: ciclo fundamental do TDD
- Regras do TDD: sem código de produção sem teste, e sem testes além do necessário para falhar
- Benefícios: maior qualidade de código, documentação viva, testes de regressão e menor acoplamento

### 🔍 Tipos de Testes

- **Unitários**: isolam pequenas partes da lógica
- **Integração**: verificam colaboração entre módulos
- **End-to-End (E2E)**: testam cenários completos de uso

📌 Baseado na [Pirâmide de Testes do Google](../canvas/Google-Testing-Pyramid.canvas)

### 🧪 Abordagens de TDD

- **Classicist (Chicago)**: foco no resultado final, sem mocks
- **Outside-In (London)**: foco na colaboração entre classes com uso intensivo de mocks

📈 Seguindo o [ciclo de Outside-In TDD](../canvas/outside-in-tdd-lifecycle.canvas)

---

## ⚙️ Coroutines & Kotlin Flow

- Tratamento de chamadas assíncronas com `suspend`, `launch`, `async` e `Dispatchers`
- Structured concurrency com `CoroutineScope`
- Emissão e coleta de dados reativos com Kotlin Flow

---

## 🧭 Navigation Component

- Facilita a implementação de navegação entre telas/fragments no Android
- Permite a definição visual do fluxo de navegação através do Navigation Graph
- Suporte a argumentos seguros entre destinos (Safe Args)
- Integração com o ciclo de vida dos fragments e back stack de forma automática
- Melhora a escalabilidade e manutenção de apps com múltiplas telas

---

## 🚀 Práticas Ágeis e S.O.L.I.D

- Iterações curtas com foco claro (Clear Focus)
- Sem overengineering (**YAGNI**)
- Design preparado para mudanças (S.O.L.I.D.)

| Princípio | Descrição |
|----------|-----------|
| **S**ingle Responsibility | Uma classe deve ter apenas uma razão para mudar |
| **O**pen/Closed | Aberta para extensão, fechada para modificação |
| **L**iskov Substitution | Subclasses devem substituir superclasses sem efeitos colaterais |
| **I**nterface Segregation | Preferência por interfaces pequenas e específicas |
| **D**ependency Inversion | Módulos de alto nível dependem de abstrações, não implementações |

---

## 🧩 Injeção de Dependência com Hilt

- Reduz acoplamento e facilita testes
- Baseada em Dagger, com suporte completo no Android Studio
- Escopos de ciclo de vida automatizados

---

## 📌 Créditos

Curso por [Petros Efthymiou](https://www.udemy.com/user/petros-efthymiou-2/) na Udemy  
Link do curso: [Acesse aqui](https://www.udemy.com/share/103Mhq3@5GTl7c99XZc2NNFIC9XM97I2l-gqh18oPkxRrk8mepJpuali4Sx3F3FaN299wW98Hw==/)
