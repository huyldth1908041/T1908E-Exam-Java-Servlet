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

@WebServlet("/employee/create")
public class CreateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
       req.getRequestDispatcher("/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        Employee employee = new Employee(name, birthday, address, position, department);
        IGenericRepository<Employee> repository = new GenericRepository<Employee>(Employee.class);
        boolean save = repository.save(employee);
        if(!save) {
            req.getRequestDispatcher("/employee.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("/employee");

    }
}
