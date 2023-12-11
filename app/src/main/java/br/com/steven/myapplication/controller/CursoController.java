package br.com.steven.myapplication.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.steven.myapplication.model.Curso;

public class CursoController {

    private List<Curso> listOfCourses;

    public List<Curso> getListOfCourses() {
        listOfCourses = new ArrayList<>();
        listOfCourses.add(new Curso("Android"));
        listOfCourses.add(new Curso("Java"));
        listOfCourses.add(new Curso("C"));
        listOfCourses.add(new Curso("C++"));
        listOfCourses.add(new Curso("Python"));
        listOfCourses.add(new Curso("PHP"));
        listOfCourses.add(new Curso("JavaScript"));
        listOfCourses.add(new Curso("Assembly"));
        return listOfCourses;
    }
    
    public List<String> dadosParaSpinner() {
        List<String> dados = new ArrayList<>();
        for (int i = 0; i < listOfCourses.size(); i++) {
            Curso curso = listOfCourses.get(i);
            dados.add(curso.getNomeDoCurso());
        }
        return dados;
    }

}
