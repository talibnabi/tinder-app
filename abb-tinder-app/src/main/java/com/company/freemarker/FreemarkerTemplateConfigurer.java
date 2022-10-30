package com.company.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class FreemarkerTemplateConfigurer {
    private final Configuration configuration;

    @SneakyThrows
    public FreemarkerTemplateConfigurer(final String path) {
        this.configuration = new Configuration(Configuration.VERSION_2_3_28) {{
            setDirectoryForTemplateLoading(new File(path));
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    @SneakyThrows
    public static FreemarkerTemplateConfigurer folder(final String path_from_project_root) {
        return new FreemarkerTemplateConfigurer(path_from_project_root);
    }

    @SneakyThrows
    public static FreemarkerTemplateConfigurer resources(final String path_from_project_resources) {
        String path = Paths
                .get(Objects.requireNonNull(FreemarkerTemplateConfigurer.class.getResource(path_from_project_resources)).toURI())
                .toFile().getAbsolutePath();
        return new FreemarkerTemplateConfigurer(path);
    }


    @SneakyThrows
    public void render(final String templateFile, final Map<String, Object> data, final HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
            configuration.getTemplate(templateFile).process(data, resp.getWriter());
        } catch (TemplateException ex) {
            throw new IllegalArgumentException("Freemarker render error", ex);
        }
    }
}
