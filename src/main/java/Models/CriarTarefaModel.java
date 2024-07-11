package Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title","description","deadline","done"})
public class CriarTarefaModel {

    private String title;
    private String description;
    private String deadline;
    private boolean done;



    public CriarTarefaModel(){

        this.title="Tarefa para Teste";
        this.description="Tarefa para testar API";
        this.deadline="2022-10-19 01:00:00";
        this.done= false;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }
}
