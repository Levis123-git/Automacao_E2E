# Automação E2E

## 📋 Descrição do Projeto

Este projeto implementa uma automação de testes End-to-End (E2E) para validar fluxos críticos da aplicação Home Broker uma aplicação de compra e venda de ações, incluindo login e validações na Boleta de compra e venda. A automação vai além das funcionalidades básicas, explorando diversos cenários e comportamentos da aplicação conforme a documentação.

## 🚀 Funcionalidades

- **Validação de Login**: Testes automatizados para diferentes cenários de login
- **Fluxo de Compra**: Automação completa do processo de compra de produtos
- **Fluxo de Venda**: Automação do processo de venda, incluindo vendas fracionadas
- **Validação de Saldo**: Verificação automática de saldos após transações
- **Validação de Alertas**: Captura e verificação de mensagens de alerta do sistema

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal
- **Selenium WebDriver**: Framework para automação de navegadores
- **JUnit**: Framework para execução e validação de testes
- **Maven**: Gerenciamento de dependências e build
- **GitHub Actions**: CI/CD para execução automatizada dos testes

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão de design **Page Objects** e princípios de **Orientação a Objetos**, proporcionando:

- **Manutenibilidade**: Fácil atualização quando a interface muda
- **Reutilização de código**: Métodos comuns encapsulados em classes base
- **Legibilidade**: Separação clara entre lógica de teste e interação com a interface
- **Escalabilidade**: Facilidade para adicionar novos testes e funcionalidades

## 📁 Estrutura do Projeto

```
Automacao_E2E/
├── .github/
│   └── workflows/               # Configurações do GitHub Actions
├── .settings/                   # Configurações do projeto
├── src/
│   └── test/
│       └── java/
│           └── automacaoE2E/
│               ├── Drivers/     # Drivers dos navegadores
│               ├── ElementosWeb/ # Mapeamento de elementos da interface
│               ├── Metodos/     # Métodos reutilizáveis para interação
│               ├── Pages/       # Classes Page Objects
│               ├── Runner/      # Configuração de execução dos testes
│               └── Testes/      # Classes de teste
├── target/                      # Arquivos compilados e relatórios
├── .classpath                   # Configuração de classpath
├── .project                     # Configuração do projeto
└── pom.xml                      # Configuração Maven
```

## ⚙️ Configuração e Execução

### Pré-requisitos

- Java JDK 17 ou superior
- Maven 3.6 ou superior
- Navegadores: Chrome e/ou Firefox
- WebDrivers correspondentes aos navegadores

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/Levis123-git/Automacao_E2E.git
   cd Automacao_E2E
   ```

2. Instale as dependências:
   ```bash
   mvn clean install
   ```

### Execução dos Testes

Para executar todos os testes:
```bash
mvn clean test
```

Para executar uma classe de teste específica:
```bash
mvn clean test -Dtest=NomeDaClasseDeTest
```

Para executar um método de teste específico:
```bash
mvn clean test -Dtest=NomeDaClasseDeTest#nomeDoMetodo
```

## 📊 Relatórios de Teste

Os relatórios de teste são gerados usando o Allure Report e podem ser acessados após a execução dos testes:

```bash
mvn allure:serve
```

Os relatórios também são publicados automaticamente pelo GitHub Actions após cada execução da pipeline.

## 👨‍💻 Contribuidor

- **QA Levi Alves** - Desenvolvimento e manutenção da automação E2E

---

⭐️ Desenvolvido por Levi Alves ⭐️
