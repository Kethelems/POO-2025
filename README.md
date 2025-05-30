# Sistema de Clínica Médica - Análise Detalhada

## 📋 *INTERFACES*

### Agendavel
*O que faz:* Define o contrato para tudo que pode ser agendado no sistema
*Por que usar:* Garante que consultas e exames tenham comportamentos padronizados para agendamento
*Métodos:*
- agendar() - agenda o item
- getData() - retorna a data
- getHora() - retorna o horário  
- cancelar() - cancela o agendamento

### IResponsavelExame
*O que faz:* Define que médicos e técnicos podem ser responsáveis por exames
*Por que usar:* Permite polimorfismo - tanto médico quanto técnico podem gerar laudos, mas de formas diferentes
*Método:*
- gerarLaudo(Exame exame) - cada profissional gera seu tipo de laudo

## 🏗 *ENUMS (Tipos Fixos)*

### TipoConsulta
*O que faz:* Define os tipos possíveis de consulta
*Por que usar:* Evita erros de digitação e garante apenas valores válidos
*Valores:* RETORNO, PRIMEIRA_CONSULTA, URGENCIA

### Sexo
*O que faz:* Define os sexos possíveis para pacientes
*Por que usar:* Padronização e validação de dados
*Valores:* MASCULINO, FEMININO, OUTRO

### TipoSanguineo
*O que faz:* Define todos os tipos sanguíneos possíveis
*Por que usar:* Informação médica crítica que deve ser precisa
*Valores:* A_POS, A_NEG, B_POS, B_NEG, AB_POS, AB_NEG, O_POS, O_NEG

## 👥 *CLASSES DE PESSOAS*

### Pessoa (Classe Base)
*O que faz:* Armazena dados básicos comuns a todos (médico, técnico, paciente)
*Por que usar:* Evita repetição de código - herança
*Atributos:* nome, cpf, email, telefone
*Funcionalidade:* Getters, setters e toString básico

### Medico (Herda de Pessoa)
*O que faz:* Representa um médico com funcionalidades específicas
*Por que usar:* Médicos têm características únicas (CRM, especialidades, agenda)
*Funcionalidades específicas:*
- Gerencia agenda de disponibilidade
- Pode gerar laudos médicos
- Tem CRM e especialidades
- Controla horários disponíveis

### Tecnico (Herda de Pessoa)
*O que faz:* Representa um técnico de laboratório/radiologia
*Por que usar:* Técnicos também fazem exames, mas geram laudos técnicos
*Funcionalidade específica:*
- Gera laudos técnicos (diferentes dos médicos)

### Paciente (Herda de Pessoa)
*O que faz:* Representa um paciente com histórico médico
*Por que usar:* Pacientes precisam de dados médicos específicos e histórico
*Funcionalidades específicas:*
- Armazena dados médicos (nascimento, sexo, tipo sanguíneo)
- Mantém histórico de consultas e exames
- Pode visualizar todo seu histórico

## 🏥 *CLASSES DE SERVIÇOS MÉDICOS*

### Consulta (Implementa Agendavel)
*O que faz:* Representa uma consulta médica completa
*Por que usar:* Centraliza todo o processo de consulta médica
*Funcionalidades:*
- Agenda consulta com médico e paciente
- Gera prontuário após encerramento
- Adiciona automaticamente ao histórico do paciente

### Exame (Implementa Agendavel)
*O que faz:* Representa um exame médico
*Por que usar:* Exames podem ser feitos por médicos OU técnicos
*Funcionalidades:*
- Pode ter médico ou técnico como responsável
- Gera laudo específico baseado no responsável
- Controla todo o ciclo do exame

### Prontuario
*O que faz:* Armazena informações detalhadas da consulta
*Por que usar:* Registro médico oficial da consulta
*Conteúdo:* detalhes, sintomas, exames solicitados, medicamentos

## ⚠ *EXCEÇÃO*

### AgendaNaoDisponivelException
*O que faz:* Exceção personalizada para problemas de agendamento
*Por que usar:* Tratamento específico de erros de agenda
*Quando usar:* Quando tentar agendar em horário não disponível

## 🎯 *PRINCIPAIS PADRÕES UTILIZADOS*

### *1. Herança*
- Pessoa → Medico, Tecnico, Paciente
- *Por que:* Reutilização de código e organização hierárquica

### *2. Interface/Polimorfismo*
- Agendavel → Consulta, Exame
- IResponsavelExame → Medico, Tecnico
- *Por que:* Flexibilidade e tratamento uniforme

### *3. Composição*
- Consulta tem Prontuario
- Paciente tem listas de Consulta e Exame
- *Por que:* Relacionamentos "tem-um" bem definidos

### *4. Encapsulamento*
- Atributos privados com getters/setters
- *Por que:* Controle de acesso e validação

## 🔄 *FLUXO DO SISTEMA*

1. *Criação:* Médico, Técnico e Paciente são criados
2. *Agenda:* Médico abre agenda e remove horários ocupados  
3. *Consulta:* Consulta é agendada → realizada → encerrada com prontuário
4. *Exames:* Exames são agendados com responsáveis → realizados → geram laudos
5. *Histórico:* Tudo é automaticamente adicionado ao histórico do paciente

## 💡 *VANTAGENS DO DESIGN*

- *Extensível:* Fácil adicionar novos tipos de profissionais
- *Reutilizável:* Código compartilhado via herança
- *Flexível:* Polimorfismo permite diferentes implementações
- *Organizado:* Separação clara de responsabilidades
- *Robusto:* Tratamento de exceções e validações
