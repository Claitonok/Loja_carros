package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Criptografar_senha;
import model.Loja;
import model.LojaDao;
import model.UsuarioDao;
import model.Usuarios;

@WebServlet("/LojaServlet")
public class LojaServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao") == null ? "login" : request.getParameter("acao");
		HttpSession session = request.getSession();

		if (acao.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
			rd.forward(request, response);

		} else if (acao.equals("mostratodos")) {
			
			int pagId = (Integer.valueOf(request.getParameter("idPag") == null ?
			"0" : request.getParameter("idPag")));
			
			/* Total de itens 101 int limitPag = 10; */

			/* Total de itens 101 */
			int limitPag = 10;

			/* Paginação que vai - "0-10-20-30" - que são as paginas */
			int paginaInicio = 0;
			int pagFinal = 100;
			
			/*variavel que recebe o valor da nossa paginacao*/
			int paginacao = 0;

			System.out.println("Pagina: " + pagId);

			
			 
			if (pagId > 1) {
				paginacao = pagId - 1; 
				request.setAttribute("listUsers", paginacao); 
			}

			for (int i = 1; i < limitPag + 1; i++) {
				paginacao = pagId;
				System.out.println("for: " + paginacao);
				request.setAttribute("listUsers", paginacao);
			}
			
			if (pagId == 10) {
				paginacao = 0; 
				request.setAttribute("listUsers", paginacao);
			}
			 
			
			/*
			 * if (pagId < limitPag) { 
			 * paginaInicio = pagId + 1;
			 * request.setAttribute("listUsers", paginacao); 
			 * }
			 */
			 
				 
			LojaDao usersLoja = new LojaDao();

			List<Loja> listUsers = usersLoja.mostrarTodos(limitPag, paginacao);
			request.setAttribute("listUsers", listUsers);
			request.setAttribute("paginacao", paginacao);
			request.setAttribute("paginaInicio", paginaInicio);
			request.setAttribute("pagFinal", pagFinal);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
			rd.forward(request, response);

			/*
			 * Total de itens 101 int limitPag = 10;
			 * 
			 * Paginação que vai - "0-10-20-30" - que são as paginas 
			 * 
			 * int paginaInicio = 0;
			 * 
			 * int pagFinal = 100;
			 *
			 * LojaDao usersLoja = new LojaDao();
			 * 
			 * List<Loja> listUsers = usersLoja.mostrarTodos(limitPag, paginaInicio);
			 * request.setAttribute("listUsers", listUsers);
			 * 
			 * 
			 * request.setAttribute("limit", limitPag); request.setAttribute("paginaInicio",
			 * paginaInicio); request.setAttribute("pagFinal", pagFinal);
			 * 
			 * RequestDispatcher rd =
			 * request.getRequestDispatcher("/WEB-INF/view/mostratodos.jsp");
			 * rd.forward(request, response);
			 */

		} else if (acao.equals("pag_cadastra_carro")) {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastro.html");
			rd.forward(request, response);

		} else if (acao.equals("excluir")) {

			int id = Integer.valueOf(request.getParameter("id"));
			LojaDao usersLoja = new LojaDao();
			usersLoja.excluirPorId(id);

			response.sendRedirect("http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos");

		} else if (acao.equals("altera")) {

			int id = Integer.valueOf(request.getParameter("id"));

			LojaDao usersLoja = new LojaDao();
			Loja users = usersLoja.MostrarAlterarId(id);

			request.setAttribute("users", users);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/altera.jsp");
			rd.forward(request, response);

		} else if (acao.equals("pag_cadastra_user")) {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroUser.html");
			rd.forward(request, response);

		} else if (acao.equals("logout")) {

			session.invalidate();
			response.sendRedirect("http://localhost:8080/loja_de_carros/");

		} else if (acao.equals("recuperar")) {

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pag_altera_Users.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");

		if (acao.equals("login")) {

			String email = request.getParameter("txtemail");
			String senha = request.getParameter("txtsenha");

			UsuarioDao usuario = new UsuarioDao();
			Usuarios resp_verif_email = usuario.Verifica_email_logar(email);

			if (resp_verif_email != null) {

				Criptografar_senha criptografar = new Criptografar_senha();

				// ESSE METODO ELE DESCRIPTOGRAFA A SENHA!!
				String Descriptografada = criptografar.criptografar_Base64_Decode(resp_verif_email.getSenha());

//				System.out.println("Senha do usuario Criptografada: " + resp_verif_email.getSenha());
//				System.out.println("Senha Descriptografada: " + Descriptografada);
//				System.out.println("Senha do usuario: " + senha);

				if (Descriptografada.equals(senha)) {

					Usuarios resposta = usuario.autentica(email, resp_verif_email.getSenha());

					HttpSession session = request.getSession();

					session.setAttribute("resposta", resposta);

					response.sendRedirect("http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos");

				} else {
					// AQUI ESTOU ENVIANDO UMA MENSAGEM PARA O USUARIO CASO NÃO CONSIGA LOGAR!!
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroUser.html");
					rd.forward(request, response);
				}

			} else {
				// AQUI ESTOU ENVIANDO UMA MENSAGEM PARA O USUARIO CASO NÃO CONSIGA LOGAR!!
				HttpSession session_validade_email = request.getSession();
				String validade_email = (resp_verif_email == null
						? "Olá seu email: " + email + " não encontrado por favor se cadastre"
						: "");
				session_validade_email.setAttribute("validade_email", validade_email);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroUser.html");
				rd.forward(request, response);
			}

		} else if (acao.equals("cadastrar_carro")) {

			String marca = request.getParameter("txtmarca");
			String modelo = request.getParameter("txtmodelo");
			String cor = request.getParameter("txtcor");

			Double km = Double.valueOf(request.getParameter("txtkm"));
			Double valor = Double.valueOf(request.getParameter("txtvalor"));

			Loja loja = new Loja(marca, modelo, cor, km, valor);
			LojaDao usersLoja = new LojaDao();
			usersLoja.cadastra(loja);

			response.sendRedirect("http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos");

		} else if (acao.equals("Altera")) {

			int id = Integer.parseInt(request.getParameter("txtid"));

			String marca = request.getParameter("txtmarca");
			String modelo = request.getParameter("txtmodelo");
			String cor = request.getParameter("txtcor");

			Double km = Double.valueOf(request.getParameter("txtkm"));
			Double valor = Double.valueOf(request.getParameter("txtvalor"));

			Loja loja = new Loja(id, marca, modelo, cor, km, valor);

			LojaDao usersLoja = new LojaDao();
			usersLoja.alterar(loja);

			response.sendRedirect("http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos");

		} else if (acao.equals("User_cadastro")) {

			String nome = request.getParameter("txtnome") == null ? request.getParameter("txtnome") : null;

			String email = request.getParameter("txtemail") == null ? request.getParameter("txtemail") : null;

			String senha = request.getParameter("txtsenha") == null ? request.getParameter("txtsenha") : null;

			if (nome == null && email == null && senha == null) {

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cadastroUser.html");
				rd.forward(request, response);

			} else {

				// VARIALVEL QUE VAI RECEBER A SENHA CRIPTOGRAFADA
				String senhaCriptografada;

				Criptografar_senha criptografar = new Criptografar_senha();
				// ESSE METODO ELE CRIPTOGRAFA A SENHA!!
				senhaCriptografada = criptografar.criptografar_Bse64_Encode(senha);

				Usuarios Usuarios = new Usuarios(nome, email, senhaCriptografada);

				UsuarioDao usuarioDao = new UsuarioDao();
				usuarioDao.cadastar_Users(Usuarios);
				response.sendRedirect("http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos");
			}

		} else if (acao.equals("Validar_email_User")) {
			// TODO Auto-generated catch block
			String email = request.getParameter("txtemail");

			UsuarioDao usuarioDao = new UsuarioDao();
			Usuarios retorno_user = usuarioDao.verifai_Users(email);

			if (retorno_user != null) {

				HttpSession session_email = request.getSession();
				session_email.setAttribute("retorno_user", retorno_user);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/atualiza_User.jsp");
				rd.forward(request, response);

			} else {

				HttpSession session_validade = request.getSession();

				String resp = (retorno_user == null
						? "Olá seu email: " + email + " não encontrado por favor se cadastre"
						: null);

				session_validade.setAttribute("resp", resp);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/pag_altera_Users.jsp");
				rd.forward(request, response);

				session_validade.invalidate();

			}

		} else if (acao.equals("User_atualiza")) {
			// TODO Auto-generated catch block

			int id_user = Integer.parseInt(request.getParameter("txtid"));

			String nome = request.getParameter("txtnome");

			String email = request.getParameter("txtemail");

			String senha = request.getParameter("txtsenha");

			// VARIALVEL QUE VAI RECEBER A SENHA CRIPTOGRAFADA
			String senhaCriptografada_nova;

			Criptografar_senha criptografar = new Criptografar_senha();
			// ESSE METODO ELE CRIPTOGRAFA A SENHA!!
			senhaCriptografada_nova = criptografar.criptografar_Bse64_Encode(senha);

			Usuarios Usuarios = new Usuarios(id_user, nome, email, senhaCriptografada_nova);

			UsuarioDao usuarioDao = new UsuarioDao();

			usuarioDao.alterar_Users(Usuarios);

			response.sendRedirect("http://localhost:8080/loja_de_carros/");

		} else {
			response.sendRedirect("http://localhost:8080/loja_de_carros/");
		}
	}
}
