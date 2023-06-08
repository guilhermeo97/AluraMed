package br.com.alura.aluramed.domain.consulta;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
