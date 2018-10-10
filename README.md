# Aplicativo da PRAE

  Aplicativo da PRAE, desenvolvido para a plataforma Android.
  
  ## Funcionalidades
  
  - Listar as notícias presentes no site da PRAE (http://prae.ufc.br)
  - Enviar notificações sobre novidades, como abertura e fechamento de editais, aditivos, eventos, etc
  - Informar as atividades que serão realizadas pela PRAE durante o ano, com data e local
  - Textos resumidos, informando quais serviços são prestados pela PRAE
  - Explicações sobre o funcionamento da PRAE
  - Mapas, para auxiliar o usuário do aplicativo a se guiar nas imediações da PRAE
  - Informações para contato e horário de atendimento

  ## Estrutura do projeto

  - menu_pages : páginas que compõem as telas do aplicativo
	
	- auxilios : telas do submenu "Auxílios" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- avisos : telas do submenu "Avisos" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- bolsas : telas do submenu "Bolsas" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- calendario_de_atividades : telas do submenu "Atividades" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- categorias : Activities que geram as telas de cada categoria (bolsas, auxílios, serviços)
	- fale_conosco : telas do submenu "Fale conosco"![#c5f015](https://placehold.it/15/c5f015/000000?text=+) 
	- mapa_da_prae : telas do submenu "Mapas da PRAE" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- noticias : tela do submenu "Notícias" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- notificacoes_por_email : telas das notificações por email ![#f03c15](https://placehold.it/15/f03c15/000000?text=+)
	- servicos : telas do submenu "Serviços" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- voce_sabia : telas do submenu "Você sabia?" ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)
	- webview : Activity responsável por mostrar todos os links ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)

  - models : classes que representam os dados enviados pelo webservice

	- Aviso : notificação de alguma novidade da PRAE 
	- Categoria : Bolsa, Auxílio, ou Serviço 
	- Compromisso : Item que irá compor o submenu "Atividades" 
	- Documento : Documento de uma categoria
	- Item : item de uma lista
	- Lista : lista de um parágrafo
	- Mapa : item do submenu "Mapas da PRAE"
	- Notícia : item do submenu "Notícias" 
	- Paragrafo : bloco de texto de uma seção
	- Secao : seção com informações sobre uma item de determinada categoria 

  - providers : classes que pegam os dados do webservice

	- AvisosWebServiceProvider : pega os dados dos avisos
	- CategoriasWebServiceProvider : pega os dados das categorias
	- CompromissosWebServiceProvider : pega os dados dos compromissos
	- DocumentosWebServiceProvider : pega os dados dos documentos
	- MapasWebServiceProvider : pega os dados dos mapas
	- NoticiasWebServiceProvider : pega os dados das notícias
	- ParagrafosWebServiceProvider : pega os dados dos paragrafos (já inclui as listas e seus itens)
	- SecoesWebServiceProvider : pega os dados das seções 

  - view : classes auxiliares das views, como adapters, listeners, etc.

	- adapters : responsáveis por receber listas com objetos de algum model e carregar seus dados em uma view

		- AvisosAdapter : adapta os avisos à view
		- CategoriasAdapter : adapta as categorias(bolsas, serviços, auxílios) à view
		- MapasAdapter : adapta os mapas à view
		- NoticiasAdapter : adapta as notícias à view
		- SecaoAdapter : adapta as seções à view

	- listeners : responsáveis por escutar eventos gerados por iterações com a view

		- AvisoClickListener : escuta os clicks feitos nos avisos
		- AvisoLinkClickListener : escuta os clicks feitos nos links dos avisos
		- CategoriaClickListener : escuta os clicks feitos nas categorias
		- DocumentosClickListener : escuta os clicks feitos nos documentos
		- EnviarEmailListener : escuta os clicks feitos nos emails
		- ItemClickListener : escuta os clicks feitos nos items
		- LinkClickListener : escuta os clicks feitos nos links 
		- MapaDownloadClickListener : escuta os clicks feitos no botão de download dos mapas
		- MapaItemClickListener : escuta os clicks feitos nos mapas
		- NoticiaItemClickListener : escuta os clicks feitos nas notícias
		- SecaoClickListener : escuta os clicks feitos nas seções

	- view_holders : servem como models para views 

	 	- AvisosViewHolder : model da view de um aviso
		- BolsasViewHolder : model da view de uma bolsa
		- CategoriaViewHolder : model da view de uma categoria
		- CompromissoViewHolder : model da view de um compromisso
		- ItemViewHolder : model da view de um item
		- ListaViewHolder : model da view de uma lista
		- MapaItemViewHolder : model da view de um mapa
		- NoticiaItemViewHolder : model da view de uma notícia
		- ParagrafoViewHolder : model da view de um parágrafo

  - workers : classes responsáveis por executar tarefas de forma periódica
	
	- AtualizarDados

  - MainActivity : Activity da tela inicial
  
