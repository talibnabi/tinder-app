package com.company.controller.path;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


import java.nio.file.Files;
import java.nio.file.Paths;

import static com.company.constants.controller.ControllerLayerConstants.pathServlet;

@WebServlet
public class PathServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Files.copy(Paths.get(pathServlet, req.getPathInfo()), resp.getOutputStream());
    }
}
