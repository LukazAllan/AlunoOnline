# AlunoOnline

## Explicação do Projeto

O **AlunoOnline** é uma aplicação web desenvolvida em Java utilizando o framework Spring Boot. O objetivo principal é fornecer uma API REST para gerenciamento de alunos e professores em um sistema de educação online. A aplicação permite operações CRUD (Criar, Ler, Atualizar, Deletar) para entidades de Aluno e Professor, facilitando a administração de dados educacionais.

### Funcionalidades Principais
- **Gerenciamento de Alunos**: Cadastro, consulta, atualização e remoção de alunos.
- **Gerenciamento de Professores**: Cadastro, consulta, atualização e remoção de professores.
- **Integração com Banco de Dados**: Utiliza PostgreSQL para persistência de dados.
- **API REST**: Endpoints para interação com o sistema via HTTP.

## Detalhamento do Código

O projeto segue uma arquitetura em camadas, típica de aplicações Spring Boot, separando responsabilidades para melhor manutenção e escalabilidade.

### Estrutura do Projeto
```
src/
├── main/
│   ├── java/br/com/alunoonline/api/
│   │   ├── AlunoOnlineApplication.java          # Classe principal da aplicação
│   │   ├── controller/
│   │   │   ├── AlunoController.java             # Controlador REST para Alunos
│   │   │   └── ProfessorController.java         # Controlador REST para Professores
│   │   ├── model/
│   │   │   ├── Aluno.java                       # Entidade Aluno
│   │   │   └── Professor.java                   # Entidade Professor
│   │   ├── repository/
│   │   │   ├── AlunoRepository.java             # Repositório JPA para Alunos
│   │   │   └── ProfessorRepository.java         # Repositório JPA para Professores
│   │   └── service/
│   │       ├── AlunoService.java                # Serviço de lógica de negócio para Alunos
│   │       └── ProfessorService.java            # Serviço de lógica de negócio para Professores
│   └── resources/
│       ├── application.properties               # Configurações da aplicação
│       ├── static/                              # Recursos estáticos (se aplicável)
│       └── templates/                           # Templates (se aplicável)
└── test/
    └── java/br/com/alunoonline/api/
        └── AlunoOnlineApplicationTests.java     # Testes da aplicação
```

### Descrição das Camadas

#### 1. **Model (Entidades)**
   - **Aluno.java** e **Professor.java**: Representam as entidades do domínio. Utilizam anotações JPA para mapeamento objeto-relacional.
     - Campos comuns: `id` (chave primária), `nome`, `email`, etc.
     - Utilizam Lombok para geração automática de getters, setters, construtores e métodos `toString()`.

#### 2. **Repository (Camada de Dados)**
   - **AlunoRepository.java** e **ProfessorRepository.java**: Interfaces que estendem `JpaRepository`, fornecendo métodos CRUD prontos.
     - Herdam operações como `findAll()`, `findById()`, `save()`, `deleteById()`.

#### 3. **Service (Lógica de Negócio)**
   - **AlunoService.java** e **ProfessorService.java**: Contêm a lógica de negócio.
     - Injetam os repositórios via `@Autowired`.
     - Implementam métodos como `getAllAlunos()`, `newAluno()`, `altAlunoById()`, etc.

#### 4. **Controller (Camada de Apresentação)**
   - **AlunoController.java** e **ProfessorController.java**: Controladores REST que expõem endpoints HTTP.
     - Mapeamentos: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`.
     - Endpoints para `/alunos` e `/professores`.
     - Retornam dados em JSON e utilizam códigos de status HTTP apropriados.

#### 5. **Configuração**
   - **application.properties**: Define configurações como conexão com PostgreSQL, propriedades do Hibernate (DDL auto-update, mostrar SQL).

### Tecnologias Utilizadas
- **Java 21**: Linguagem de programação.
- **Spring Boot 4.0.5**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Data JPA**: Para acesso a dados e mapeamento objeto-relacional.
- **Spring Web MVC**: Para criação de APIs REST.
- **PostgreSQL**: Banco de dados relacional.
- **Hibernate**: ORM para JPA.
- **Lombok**: Biblioteca para redução de código boilerplate.
- **Maven**: Gerenciador de dependências e build.

## Descrição da Arquitetura

A arquitetura do projeto segue o padrão **MVC (Model-View-Controller)** adaptado para APIs REST, com separação clara de responsabilidades:

- **Model**: Representa os dados e regras de negócio (entidades JPA).
- **View**: Não aplicável diretamente, pois é uma API; os "views" são as respostas JSON.
- **Controller**: Gerencia as requisições HTTP e coordena com a camada de serviço.

### Padrões de Design
- **Repository Pattern**: Abstrai o acesso a dados através de interfaces.
- **Service Layer**: Centraliza a lógica de negócio, facilitando testes e manutenção.
- **Dependency Injection**: Utilizada pelo Spring para injeção de dependências (ex.: `@Autowired`).

### Fluxo de Dados
1. Uma requisição HTTP chega ao Controller.
2. O Controller chama o Service correspondente.
3. O Service interage com o Repository para acessar o banco de dados.
4. Dados são retornados através das camadas até a resposta HTTP.

### Banco de Dados
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
- **Configuração**: Conexão local (`localhost:5432`), banco `alunoonline`.
- **DDL Auto**: Hibernate atualiza o esquema automaticamente com base nas entidades.

### Segurança e Boas Práticas
- Embora não implementada neste projeto básico, recomenda-se adicionar autenticação/autorização (ex.: Spring Security) para produção.
- Validação de entrada com Bean Validation.
- Tratamento de exceções global com `@ControllerAdvice`.

## Como Executar

### Pré-requisitos
- Java 21 instalado.
- PostgreSQL rodando localmente (porta 5432), com banco `alunoonline` criado.
- Maven instalado.

### Passos
1. Clone o repositório.
2. Configure o banco de dados conforme `application.properties`.
3. Execute `mvn clean install` para baixar dependências.
4. Execute `mvn spring-boot:run` ou rode a classe `AlunoOnlineApplication.java`.
5. A API estará disponível em `http://localhost:8080`.

### Endpoints da API
- **Alunos**:
  - `GET /alunos`: Lista todos os alunos.
  - `GET /alunos/{id}`: Busca aluno por ID.
  - `POST /alunos`: Cria novo aluno.
  - `PUT /alunos/{id}`: Atualiza aluno.
  - `DELETE /alunos/{id}`: Remove aluno.
- **Professores**: Endpoints similares em `/professores`.

## Contribuição
Contribuições são bem-vindas! Abra issues ou pull requests no repositório.

## Licença
Este projeto está sob a licença [MIT](LICENSE) (ou adicione conforme necessário).
