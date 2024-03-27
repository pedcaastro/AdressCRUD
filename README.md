
<body>
    <h1>AdressPerson CRUD em Java</h1>
    <p>O projeto <strong>AdressPerson</strong> é uma aplicação Java que implementa operações básicas de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciamento de um cadastro de pessoas. A aplicação permite adicionar novas pessoas ao banco de dados, consultar pessoas pelo sobrenome, e listar todas as pessoas cadastradas. Utilizando um modelo de dados simples, cada pessoa é registrada com um identificador único (<em>AdressID</em>), primeiro nome, último nome, número de telefone e email.</p>

<h2>Funcionalidades</h2>
    <ul>
        <li><strong>Adicionar Pessoas</strong>: Permite inserir novas pessoas ao banco de dados com informações de primeiro nome, último nome, número de telefone e email.</li>
        <li><strong>Consultar Pessoas pelo Sobrenome</strong>: Funcionalidade de busca que permite aos usuários consultar pessoas cadastradas utilizando como filtro o sobrenome.</li>
        <li><strong>Listar Pessoas</strong>: Lista todas as pessoas presentes no banco de dados, exibindo suas informações cadastrais.</li>
    </ul>

 <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Java</strong>: Linguagem de programação utilizada para o desenvolvimento da aplicação.</li>
        <li><strong>JDBC</strong>: API para conexão e execução de operações no banco de dados.</li>
        <li><strong>MySQL</strong>: Sistema de gerenciamento de banco de dados onde os registros das pessoas são armazenados.</li>
    </ul>

 <h2>Como Executar</h2>
    <p>Para executar a aplicação <strong>AdressPerson</strong>, siga os passos abaixo:</p>
    <ol>
        <li><strong>Clone o repositório</strong>: Clone este repositório Git para sua máquina local utilizando o comando:
            <pre><code>git clone [URL_DO_REPOSITÓRIO]</code></pre>
        </li>
        <li><strong>Configure o Banco de Dados</strong>: Certifique-se de que o MySQL está instalado e configurado em sua máquina. Crie um banco de dados chamado <em>wm</em> e importe o schema localizado no arquivo <em>schema.sql</em>.</li>
        <li><strong>Configure a Conexão com o Banco de Dados</strong>: Abra o arquivo <em>DatabaseConnection.java</em> (nome genérico, substitua pelo nome correto conforme seu projeto) e atualize as credenciais de conexão do banco de dados (URL, usuário, senha).</li>
        <li><strong>Compile e Execute a Aplicação</strong>: Compile o projeto e execute a classe principal para iniciar a aplicação.</li>
    </ol>
    
<h2>Contribuições</h2>
    <p>Contribuições para o projeto são bem-vindas. Para contribuir:</p>
    <ol>
        <li>Faça um fork do repositório.</li>
        <li>Crie uma branch para sua feature (<code>git checkout -b feature/nomeDaFeature</code>).</li>
        <li>Faça commit das suas alterações (<code>git commit -am 'Adicionando uma nova feature'</code>).</li>
        <li>Faça push para a branch (<code>git push origin feature/nomeDaFeature</code>).</li>
        <li>Abra um Pull Request.</li>
    </ol>

</body>
</html>
