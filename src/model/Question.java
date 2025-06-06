package model;

import java.util.List;

public class Question {
    private String tema;
    private Difficulty nivel;
    private String enunciado;
    private List<String> alternativas;
    private int indiceRespostaCorreta;
    private Category category;

    public Question(String tema, String subtema, Difficulty nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta) {
        this.tema = tema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.category = null;
    }
    
    public Question(String tema, String subtema, Difficulty nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta, String personalidade, Category category) {
        this.tema = tema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.category = category;
    }

    public String getTema() {
        return tema;
    }
    
    public Difficulty getNivel() {
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

    public Category getTipo() {
    	return category;
    }
    
    public boolean isRespostaCorreta(int indiceEscolhido) {
        return indiceEscolhido == indiceRespostaCorreta;
    }

	@Override
	public String toString() {
		return "Pergunta [tema=" + tema  + ", nivel=" + nivel + ", enunciado=" + enunciado
				+ ", alternativas=" + alternativas + ", indiceRespostaCorreta=" + indiceRespostaCorreta
				 + ", tipo=" + category + "]";
	}
    
}