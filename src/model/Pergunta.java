package model;

import java.util.List;

public class Pergunta {
    private String tema;
    private Dificuldade nivel;
    private String enunciado;
    private List<String> alternativas;
    private int indiceRespostaCorreta;
    private Tipo tipo;

    public Pergunta(String tema, String subtema, Dificuldade nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta) {
        this.tema = tema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.tipo = null;
    }
    
    public Pergunta(String tema, String subtema, Dificuldade nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta, String personalidade, Tipo tipo) {
        this.tema = tema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.tipo = tipo;
    }

    public String getTema() {
        return tema;
    }
    
    public Dificuldade getNivel() {
    	return nivel;
    }
    
    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public int getIndiceRespostaCorreta() {
        return indiceRespostaCorreta;
    }

    public Tipo getTipo() {
    	return tipo;
    }
    
    public boolean isRespostaCorreta(int indiceEscolhido) {
        return indiceEscolhido == indiceRespostaCorreta;
    }

	@Override
	public String toString() {
		return "Pergunta [tema=" + tema  + ", nivel=" + nivel + ", enunciado=" + enunciado
				+ ", alternativas=" + alternativas + ", indiceRespostaCorreta=" + indiceRespostaCorreta
				 + ", tipo=" + tipo + "]";
	}
    
}