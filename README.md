O Readme que você me enviou na primeira solicitação e a melhoria que fiz já estão totalmente formatados em **Markdown (MD)**.

Você pode copiar e colar o texto abaixo diretamente no seu arquivo `README.md`.

-----

## 🚀 Monolito Empresa (Spring Boot)

Este projeto implementa uma aplicação monolítica utilizando **Spring Boot**, focada no gerenciamento de **Departamentos** e **Funcionários** (CRUD - Create, Read, Update, Delete).

A aplicação oferece duas interfaces de interação: uma **API REST** para integração e uma **Interface Web** construída com **Thymeleaf**.

-----

### 🌟 Funcionalidades Principais

| Interface | Descrição | Rotas Principais |
| :--- | :--- | :--- |
| **API REST** | Endpoints para manipulação de dados via JSON. | `/api/departamentos`, `/api/funcionarios` |
| **Web (Thymeleaf)** | Interface de usuário para visualização e CRUD de dados. | `/departamentos`, `/funcionarios` |

### 🛠️ Tecnologias Utilizadas

  * **Framework:** Spring Boot
  * **Template Engine:** Thymeleaf
  * **Persistência:** Spring Data JPA
  * **Banco de Dados (Produção):** MariaDB
  * **Banco de Dados (Testes):** H2 Database (em memória)
  * **Build Tool:** Maven
  * **Auxiliar:** Lombok

-----

### ⚙️ Como Abrir no VS Code

1.  **Baixe e Extraia:** Obtenha e descompacte o arquivo do projeto.
2.  **Abra a Pasta:** No VS Code, utilize a opção `File -> Open Folder...` e selecione a pasta raiz do projeto (`monolito-empresa`).

### ▶️ Como Executar a Aplicação

Certifique-se de ter o **Maven** instalado e configurado.

Abra o terminal na pasta raiz do projeto e execute o seguinte comando:

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará acessível em:
➡️ **`http://localhost:8080`**

-----

### 📝 Observações Importantes

  * **Configuração do Banco de Dados:** É **necessário** atualizar as credenciais do MariaDB no arquivo de configuração.
      * **Arquivo:** `src/main/resources/application.properties`
      * **Altere:** As propriedades de `spring.datasource.username` e `spring.datasource.password`.
  * **Lombok:** Este projeto utiliza **Lombok** para reduzir código boilerplate. Para que o VS Code não exiba erros de compilação dentro do IDE, certifique-se de que o **plugin/extensão do Lombok** esteja instalado e configurado em seu ambiente.

-----

**Arthur Fernandes**
