package com.company.controleponto.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControlePontoExceptionHandler extends ResponseEntityExceptionHandler {

  private MessageSource messageSource;

  @Autowired
  public ControlePontoExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

    String mensagemUsuario =
        messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
    String mensagemDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
    Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);
    List<Erro> erros = Arrays.asList(erro);
    return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    List<Erro> erros = criarListaDeErros(fieldErrors);
    return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler({EmptyResultDataAccessException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleEmptyResultDataAccessException(
          EmptyResultDataAccessException exception, WebRequest request) {
    String message =
            messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
    Erro erro = new Erro(message, exception.toString());
    List<Erro> erros = Arrays.asList(erro);
    return handleExceptionInternal(
            exception, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }


  @ExceptionHandler({EntityNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleEntityNotFoundException(
          EntityNotFoundException exception, WebRequest request) {
    String message =
            messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
    Erro erro = new Erro(message, exception.toString());
    List<Erro> erros = Arrays.asList(erro);
    return handleExceptionInternal(
            exception, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler({NoSuchElementException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleNoSuchElementException(
          NoSuchElementException exception, WebRequest request) {
    String message =
            messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
    Erro erro = new Erro(message, exception.toString());
    List<Erro> erros = Arrays.asList(erro);
    return handleExceptionInternal(
            exception, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  private List<Erro> criarListaDeErros(List<FieldError> listaErros) {
    List<Erro> lista = new ArrayList<>();
    listaErros.forEach(
        fieldError -> {
          String mensagemUsuario =
              messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
          String mensagemDesenvolvedor = fieldError.toString();
          Erro erro = new Erro(mensagemUsuario, mensagemDesenvolvedor);
          lista.add(erro);
        });
    return lista;
  }

  public static class Erro {
    private String mensagemUsuario;
    private String mensagemDesenvolvedor;

    public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
      this.mensagemUsuario = mensagemUsuario;
      this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public String getMensagemUsuario() {
      return mensagemUsuario;
    }

    public String getMensagemDesenvolvedor() {
      return mensagemDesenvolvedor;
    }
  }
}
