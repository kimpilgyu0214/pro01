package org.samsung.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.samsung.dto.Notice;
import org.samsung.dto.Qna;


@WebServlet("/PRO02")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Main() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String author = "돌아온 아톰 김필규";
			ServletContext application = request.getServletContext();
			String realpath = request.getSession().getServletContext().getRealPath("/");
			application.setAttribute("realpath",realpath);
			application.setAttribute("title","삼성동 소개");
			
			List<Notice> latestNotiList = new ArrayList<>();
			List<Qna> latestQnaList = new ArrayList<>();
			
//			request.setAttribute("latestNotiList", latestNotiList);
//			request.setAttribute("latestQnaList", latestQnaList);
			request.setAttribute("author", author);
			request.setAttribute("NJ", "./images/NJ.jpg");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
			view.forward(request, response);
		}
	}