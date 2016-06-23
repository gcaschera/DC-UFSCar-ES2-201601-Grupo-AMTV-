##Trabalho Prático - Engenharia de Software 2
**Professor:** Fabiano Ferrari


**Grupo:**
> - Arthur Regatieri Munhoz
> - Murilo Guedes Toloni
> - Silvio Delfito
> - Tomas Borba
> - Vinicius Barbosa


##Tarefas Realizadas:

  > **Testes:**
  
    - Inserção de itens bibliográficos (book e article)
      Arquivo: src/test/java/net/sf/jabref/model/entry/BibtexEntryTests.java
      
    - Importação de itens bibliográficos na base corrente
      Arquivo: src/test/java/net/sf/jabref/importer/fileformat/BibtexImporterTest.java
  
  > **Manutenções:**
  
    - Em inserção de itens bibliográficos, validar os seguintes campos de acordo com as seguintes regras:
      - Year: deve ser um ano válido (de acordo com o calendário da linguagem Java)
      - Bibtexkey: definido pelo usuário ou automaticamente, deve ter no mínimo 2 caracteres, sendo o primeiro uma letra maiúscula ou minúscula
      Arquivo: src/main/java/net/sf/jabref/model/entry/BibEntry.java
      
    - Em importação de itens bibliográficos, oferecer a opção de importar arquivo em formato CSV
      Arquivo: src/main/java/net/sf/jabref/importer/fileformat/CSVimporter.java
      
    - Em importação de itens bibliográficos, oferecer a opção de criação de um novo arquivo (database) quando existirem entradas duplicadas no arquivo corrente (current database) e o arquivo que está sendo importado (considerar formatos BibTeX e CSV).
      Arquivo: 
      
  > **Testes das manutenções:**
  
    - Manutenção Validação Campo BibtexKey
      Arquivo: src/test/java/net/sf/jabref/model/entry/ManutencaoBibtexkeyTestes.java
    
    - Manutenção Validação Campo Year
      Arquivo: src/test/java/net/sf/jabref/model/entry/ManutencaoYearTestes.java
