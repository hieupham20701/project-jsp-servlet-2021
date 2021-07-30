package com.project2021.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project2021.constant.SystemConstant;
import com.project2021.model.NewModel;
import com.project2021.service.INewService;


@WebServlet(urlPatterns = {"/admin-new"} )
public class NewController extends HttpServlet {
	@Inject
	private INewService newService;
	
	
	private static final long serialVersionUID = 1L;

    public NewController() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel model = new NewModel();
		String pageStr = request.getParameter("page");
		String maxPageItemStr = request.getParameter("maxPageItem");
		if(pageStr != null) {
			model.setPage(Integer.parseInt(pageStr));
		}else {
			model.setPage(1);
		}
		if(maxPageItemStr != null){
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		}else {
			
		}
		Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
		model.setListResult(newService.findAll(offset, model.getMaxPageItem()));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/new/list.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
