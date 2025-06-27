# 🎵 Groovy - App de Lista de Playlists

Groovy é um aplicativo Android desenvolvido como parte do curso Android TDD Masterclass. Ele apresenta uma lista de playlists consumida de uma API simulada, utilizando uma arquitetura moderna baseada em MVVM e testes automatizados.

---

## 🧱 Tecnologias Utilizadas

- **Kotlin** com Android SDK
- **MVVM** como padrão arquitetural
- **Hilt** para injeção de dependência
- **Retrofit** para consumo da API
- **Coroutines & Kotlin Flow** para programação assíncrona
- **LiveData / StateFlow** para atualização reativa da interface
- **ViewModel** para gerenciamento de estado e lógica de UI
- **Mockoon** como servidor local para simular a API de playlists
- **JUnit** e **Espresso** para testes unitários e de aceitação

---

## 🧪 Testes

Este projeto cobre:

- **Testes Unitários** para lógica de ViewModel e repositórios
- **Testes de Aceitação (E2E)** que verificam o comportamento da interface simulando a interação do usuário

---

## 🖼️ Design das Playlists

As imagens utilizadas como capa das playlists foram geradas com auxílio de ferramentas de **inteligência artificial** como **Gemini** e **ChatGPT**, conferindo um toque visual único à interface.

---

## 🚀 Execução

1. Clone o repositório
2. Inicie o servidor da API com o **Mockoon**
3. Execute o app no Android Studio

---

## 📂 Estrutura do Projeto

```
groovy/
├── data/
│   ├── api/
│   ├── mapper/
│   ├── repository/
│   └── service/
├── domain/
│   └── model/
├── playlist/
│   ├── module/
│   ├── presentation/
│   │   └── adapter/
├── test/
│   └── playlist/
└── androidTest/
```

---

## 📌 Observações

- Este projeto serve como laboratório de aprendizado para Clean Architecture, TDD e práticas modernas de desenvolvimento Android.
- A API de playlists está localizada no Mockoon, rodando localmente para simular o backend.

---

## ⚠️ Configuração Adicional

Para que o aplicativo funcione corretamente com a API local via Mockoon, é necessário adicionar o IP da máquina no arquivo `local.properties` do projeto Android Studio:

```
# local.properties
BASE_URL=SEU_IP_LOCAL
```

Substitua `SEU_IP_LOCAL` pelo IP da sua máquina (por exemplo, `192.168.0.101`).

Esse valor será usado para configurar dinamicamente a base URL da API no momento da build.
