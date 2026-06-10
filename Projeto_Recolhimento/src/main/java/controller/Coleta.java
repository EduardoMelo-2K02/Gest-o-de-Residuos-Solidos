package controller;

import java.util.ArrayList;
import model.Entulho;

public class Coleta {
   
    public static ArrayList<Entulho> agendamentos = new ArrayList<Entulho>();

    public void cadastrarSolicitacao(String logradouro, String material, String volume) {
        Entulho novo = new Entulho(logradouro, material, volume);
        agendamentos.add(novo);
    }
}