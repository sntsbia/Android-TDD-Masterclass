# 🎵 Groovy - App de Lista de Playlists

Groovy é um aplicativo Android desenvolvido como parte do curso Android TDD Masterclass. Ele apresenta uma lista de playlists consumida de uma API, utilizando uma arquitetura moderna baseada em MVVM e testes automatizados.

---

## ☁️ API

A API de playlists utilizada por este aplicativo está hospedada no Google Cloud e foi criada a partir de uma imagem Docker. O código-fonte da API está disponível em um repositório separado no GitHub:

- **Repositório da API:** [sntsbia/playlists-imersao](https://github.com/sntsbia/playlists-imersao)

Isso elimina a necessidade de configurar um servidor local para executar o aplicativo.

---

## 🧱 Tecnologias Utilizadas

- **Kotlin** com Android SDK
- **MVVM** como padrão arquitetural
- **Hilt** para injeção de dependência
- **Retrofit** para consumo da API
- **Coroutines & Kotlin Flow** para programação assíncrona
- **LiveData / StateFlow** para atualização reativa da interface
- **ViewModel** para gerenciamento de estado e lógica de UI
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

A maneira mais simples de testar o aplicativo é instalando o APK diretamente no seu dispositivo Android.

1.  Navegue até a pasta `apks/` neste repositório.
2.  Baixe o arquivo `.apk` mais recente.
3.  Instale o APK no seu dispositivo.

Como alternativa, você pode clonar o repositório e compilar o projeto no Android Studio.

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
- A API de playlists é consumida de um serviço remoto, não sendo necessário rodar um backend local.
