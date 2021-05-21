package com.t1908e.exam_wad.controller;

import com.t1908e.exam_wad.entity.Employee;
import com.t1908e.exam_wad.repository.GenericRepository;
import com.t1908e.exam_wad.repository.IGenericRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "List", urlPatterns = "/employee")
public class ListEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        IGenericRepository<Employee> genericRepository = new GenericRepository<Employee>(Employee.class);
        List<Employee> employees = genericRepository.toList();
        req.setAttribute("list", employees);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
