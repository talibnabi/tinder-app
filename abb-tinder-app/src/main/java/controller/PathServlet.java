package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static constants.controllerConstants.ControllerLayerConstants.pathServlet;

public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Files.copy(Paths.get(pathServlet, req.getPathInfo()), resp.getOutputStream());
    }
}
