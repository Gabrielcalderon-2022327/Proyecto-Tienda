package com.gabrielcalderon.Tienda.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validarAnotacionesEntidad(MethodArgumentNotValidException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String mensaje = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).reduce((a, b) -> a + " | " + b).orElse("Error de validación");
        redirectAttributes.addFlashAttribute("error", mensaje);
        return "redirect:" + getReferer(request);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String validarErroresConstraint(SQLIntegrityConstraintViolationException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("error", "No existe esa llave foranea");
        return "redirect:" + getReferer(request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String validarTipoDato(RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("error", "Tipo de dato no valido");
        return "redirect:" + getReferer(request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String captarThrows(ResourceNotFoundException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:" + getReferer(request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String validacionesNegocio(IllegalArgumentException ex, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:" + getReferer(request);
    }

    private String getReferer(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (referer == null || referer.isEmpty()) {
            referer = request.getContextPath() + "/";
        }
        return referer;
    }
}
