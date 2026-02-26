# 📋 Task Manager - ESIG Software

Sistema Web para gerenciamento de tarefas, desenvolvido como parte de um desafio técnico para demonstrar proficiência no ecossistema Java.

## 🛠 Tecnologias e Ferramentas
* **Front-end:** JSF 2.3 & PrimeFaces 12 
* **Back-end:** Java 8 (Java EE / Jakarta EE), CDI (Injeção de Dependência)
* **Persistência:** Hibernate & JPA (PostgreSQL)
* **Testes:** JUnit 5
* **Servidor:** Apache Tomcat 9
* **Build & Infra:** Maven & Docker

  
## ⚙️ Funcionalidades
### Gestão de Tarefas
- [x] CRUD completo (Criar, Listar, Editar e Excluir)
- [x] Filtragem de tarefas
- [x] Atribuição de responsáveis

### Gestão de Responsáveis
- [x] Cadastro e listagem de novos responsáveis
- [x] Exclusão com validação de dependências



### Segurança
- [x] Tela de Login com autenticação de usuário
    - Usuário: admin
    - Senha: 123456

## Como executar o projeto Localmente
### Pré requisitos
- Java 8
- Maven
- Docker e Docker-compose(para subir container do PostgresSQL)
- Apache tomcat 9
- Git

### Passo a Passo
1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/Lucaasshq/task-manager-esig-software.git
- Abri Projeto no eclipse
- Na raiz do projeto onde está o docker-compose.yml digite:
  ```docker-compose up -d``` para subir o banco
- adicione o apache tomcat 9 como servidor, ele está no projeto ```apache-tomcat-9.0.115``` e adicione o projeto dentro do tomcat
  
Inicie o projeto em ```http://localhost:8080/task-esig/login.xhtml```
- obs fiz o deploy mas por eu estar usando tomcat não consegui conectar ao banco atráves das váriaveis de ambiente

Credencias para teste
- Usuario: admin
- Senha: 123456

### 🧪 Testes
Para rodar a suíte de testes unitários:
```mvn test```

## Diagrama de classes do Projeto
![diagrama](https://github.com/Lucaasshq/task-manager-esig-software/blob/24ebf05eacf0dd2ac0d1ec995b2cd08433ff0bdd/diagrama/package.png)
