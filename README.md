Projeto de Agendamento de Recolhimentos de Resíduos Sólidos
🚛 Sistema de Gestão de Resíduos Sólidos
Este projeto é uma aplicação Web dinâmica desenvolvida em Java para facilitar o agendamento e a gestão de recolhimento de resíduos sólidos (entulhos). O sistema evoluiu de um armazenamento temporário para um sistema de persistência robusto, permitindo o gerenciamento completo dos pedidos dos cidadãos e mantendo o controle logístico da prefeitura.

🎯 Objetivo do Projeto: Atender aos requisitos de avaliação da disciplina, aplicando conceitos de arquitetura em camadas, persistência em Banco de Dados Relacional, comunicação via protocolos HTTP (GET e POST), manipulação dinâmica de dados com JSP e aplicação de regras de negócio estritas.

🏗️ Arquitetura MVC e Persistência
O projeto foi totalmente reestruturado seguindo o padrão clássico MVC (Model-View-Controller) com uma camada de persistência isolada, garantindo alta organização do código:

Model (Entulho.java & DAO.java): A classe Entulho representa o objeto de negócio (ID, logradouro, material e volume). A classe DAO é responsável pela infraestrutura de persistência, abrindo conexões seguras via JDBC com o banco de dados MySQL e executando instruções SQL puras.

Controller (controlador.java): Um Servlet unificado (jakarta.servlet) que atua como o cérebro da aplicação. Ele intercepta as requisições das rotas HTTP (/main, /insert, /select, /update, /delete), valida as regras de negócio e decide as ações que o DAO e as Views devem tomar.

View (HTML/JSP/CSS): Telas dinâmicas que entregam respostas personalizadas ao usuário. Os dados vindos do banco são renderizados em tempo real utilizando tags Java embarcadas (Scriptlets) em páginas estilizadas de forma independente.

🚀 Funcionalidades (O CRUD Completo)
📥 CREATE (Agendar Coleta): Formulário limpo que recolhe os dados do morador e dispara uma requisição segura via método POST para criar uma nova ordem de recolhimento.

📋 READ (Listar Agendamentos): Uma tabela dinâmica alimentada em tempo real por consultas estruturadas no banco de dados. Os registros são exibidos em ordem cronológica inversa (os mais novos aparecem primeiro).

✏️ UPDATE (Editar Solicitação): Permite alterar o endereço, o tipo do material ou o volume de um agendamento existente. O sistema recupera os dados antigos por meio de uma busca seletiva por ID e salva as modificações diretamente sobre o registro original usando chaves ocultas (hidden inputs).

❌ DELETE (Excluir Registro): Botão de remoção direta com gatilho de confirmação visual em JavaScript para evitar exclusões acidentais na base de dados.

🛡️ Regras de Negócio Implementadas
O controlador e o frontend foram blindados com critérios rigorosos para evitar dados inconsistentes no banco:

Validação de Endereço: O campo Logradouro não aceita valores nulos e exige uma extensão mínima de 5 caracteres.

Obrigatoriedade de Carga: O volume da coleta não pode ser enviado em branco.

Restrição de Logística Municipal: Se o tipo de entulho selecionado for "Poda de Árvores", o sistema impede o salvamento (tanto no cadastro quanto na edição) caso o volume digitado seja "grande", exibindo um alerta informativo na tela e abortando a operação para proteger a capacidade de transporte da coleta pública.

🛠️ Tecnologias Utilizadas
Java SE & Jakarta Servlet API: Para controle de rotas, interceptação de requisições e lógica estrutural.

JavaServer Pages (JSP): Para renderização de elementos visuais dinâmicos no lado do servidor.

MySQL Database: Banco de dados relacional responsável pelo armazenamento definitivo das informações através do Driver JDBC (com.mysql.cj.jdbc.Driver).

HTML5 & CSS3: Estruturação semântica e estilização moderna por meio de arquivos CSS externos organizados modularmente.


Eclipse IDE & Apache Tomcat v10.0: Ambiente de desenvolvimento integrado e servidor de aplicação local para implantação do projeto.

👨‍💻 Desenvolvido por: Eduardo Melo
