# Ponto de venda

### **Para criar uma API do 0, vamos seguir o seguinte fluxo:**

****
1. Vamos acessar o site:
- https://start.spring.io/

E configurar o projeto de acordo com o necessário.
De dependências, utilizaremos:

- spring-boot-starter-data-jpa
- spring-boot-starter-web
- mysql-connector-java

2. Após abrir o projeto Baixado anteriormente na IDE e esperar a conclusão do download das dependências:
- Vamos configurar o arquivo application.properties, começaremos renomeando-o para application.yml.
- Para a configuração básica você pode copiar o exemplo deste repositório.

3. Agora podemos seguir o fluxo padrão da criação de uma API Spring:
- Configuração da Model e da DTO;
- Configuração do Repository;
- Configuração do Service;
- Configuração do Controller;
- A configuração de uma Exception padrão é opcional, mas é uma boa prática.


### **Para modificar a api atual, vamos seguir o seguinte fluxo:**

****
1. Vamos clonar este repositório.
- Após isso, vamos abri-lo na IDE e esperar o download das dependências.

****
2. **Alterar o ProdutoDomain**
- Vamos adicionar os campos:

``private String valor``

``private String descricao``
****
3. Em seguida basta atualizar os métodos get, set, equal, hashCode e toString.
- Podemos ainda realizar o mesmo procedimento na classe "ProdutoDTO".

4. **Como a repository já está criada, podemos ignorar esta etapa.**
****
5. Vamos alterar a classe ProdutoService:
- Aqui precisamos alterar os métodos "save" e "replace".
****
6. Não são necessárias alterações na classe ProdutoController.