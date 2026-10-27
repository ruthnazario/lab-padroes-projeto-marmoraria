# Padrões de Projeto em Java: Orçamentos de Marmoraria

Projeto final do desafio **Padrões de Projeto (Design Patterns)** da DIO.
Aplicação simples em Java puro que gera orçamentos de mármores e granitos,
inspirada no meu trabalho com marmoraria.

## Padrões aplicados

| Padrão | Onde | Para quê |
|---|---|---|
| Singleton | `OrcamentoRepository` | Única instância que guarda os orçamentos |
| Factory Method | `PedraFactory` | Cria cada tipo de pedra com seu preço |
| Builder | `Orcamento.Builder` | Monta o orçamento passo a passo, com validação |
| Strategy | `Acabamento` e implementações | Cada acabamento (polido, escovado, flameado) tem seu adicional |
| Chain of Responsibility | `DescontoHandler` e filhos | Descontos de volume, cliente fiel e à vista em cadeia |
| Observer | `OrcamentoObserver` | Notifica por e-mail e WhatsApp ao gerar orçamento |
| Facade | `OrcamentoFacade` | Interface única que esconde toda a complexidade |

## Como executar

Requisitos: Java 17+.

```bash
mvn compile exec:java -Dexec.mainClass=com.ruthnazario.marmoraria.Main
```

Ou abra no IntelliJ (File > Open > pasta do projeto) e rode a classe `Main`.

## Estrutura

```
src/main/java/com/ruthnazario/marmoraria/
├── Main.java
├── facade/      OrcamentoFacade
├── factory/     PedraFactory
├── model/       Orcamento (Builder), Pedra, TipoPedra
├── strategy/    Acabamento + 3 implementações
├── desconto/    cadeia de descontos
├── observer/    notificadores
└── repository/  OrcamentoRepository (Singleton)
```

Autora: [Ruth Nazario](https://github.com/ruthnazario)
