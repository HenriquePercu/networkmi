<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script>
			var urlUsuarios = window.location.href + "service/usuarios/todos";
			$.getJSON(urlUsuarios, function(data){
				if (data.length !== 0){
					$.each(data, function(i, usuario) {
						$("<li/>", { "text": usuario.nome })
							.append(" ").append($("<a/>", {
					  		 	"text" : window.location.href + "service/usuarios/obterusuario/" + usuario.id,
							  	"href" : window.location.href + "service/usuarios/obterusuario/" + usuario.id
						})).appendTo("#usuarios");
					});
				} else {
					$("<li/>", {"text" : "Nenhum usuario."}).appendTo("#usuarios");
				}
			});
			
			var urlCategorias = window.location.href + "service/categorias/todos";
			$.getJSON(urlCategorias, function(data){
				if (data.length !== 0){
					$.each(data, function(i, categoria) {
						$("<li/>", { "text": categoria.descricaoCategoria })
							.append(" ").append($("<a/>", {
					  		 	"text" : window.location.href + "service/categorias/obtercategoria/" + categoria.id,
							  	"href" : window.location.href + "service/categorias/obtercategoria/" + categoria.id
						})).appendTo("#categorias");
					});
				} else {
					$("<li/>", {"text" : "Nenhuma categoria."}).appendTo("#categorias");
				}
			});
		</script>
	</head>
	<body>
		<h2>Links NetworkMi 1.0.2</h2>
		<br />
		<a href="https://raw.githubusercontent.com/rodrigomacena/NetworkMi_Android/master/app/networkmi-release.apk">Baixar Networkmi APK</a>
		<h3>Usuário</h3>
		<a href="novoUsuario">Criar novo usuário</a>
		<br />
		<a href="listaUsuarios">Listar Usuários</a>
		<br />
		<a href="service/usuarios/todos">Listar Usuários (REST)</a>
		<br />
		<br />
		<span>Obter Usuário (REST)</span>
		<br />
		<ul id='usuarios'></ul>
		<br/><br/><br/><br/>
		<h3>Categorias</h3>
		<a href="novaCategoria">Criar nova categoria</a>
		<br />
		<a href="listaCategorias">Listar Categorias : TODO</a>
		<br />
		<a href="service/categorias/todos">Listar Categorias (REST)</a>
		<br />
		<br />
		<span>Obter Categoria (REST)</span>
		<br />
		<ul id='categorias'></ul>
	</body>
</html>