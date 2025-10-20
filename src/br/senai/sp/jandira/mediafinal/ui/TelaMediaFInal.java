package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaMediaFInal extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(600);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.setTitle("Média Final");

        // Criando o painel principal (root)//
        BorderPane root = new BorderPane();

        // Criar o label com o título da tela//
        Label titulo = new Label();
        titulo.setText("Escola SENAI \"Prof. Vicente Amato\"");
        titulo.setStyle("-fx-font-size:18; -fx-text-fill: white");
        titulo.setPadding(new Insets(10,0,10,10));

        HBox painelSuperior = new HBox();
        painelSuperior.getChildren().addAll(titulo);
        painelSuperior.setStyle("-fx-background-color: #5a51f4");

        // Criação do formulário//
        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets(15));
        painelFormulario.setStyle("-fx-background-color: #aca8f9");
        painelFormulario.setSpacing(4);
        Label lblNomeAluno = new Label("Nome do Aluno (a):");
        Label lblNota1 = new Label("Nota 1:");
        Label lblNota2 = new Label("Nota 2:");
        Label lblNota3 = new Label("Nota 3:");
        Label lblNota4 = new Label("Nota 4:");

        TextField tfNomeAluno= new TextField();
        TextField tfNota1= new TextField();
        TextField tfNota2= new TextField();
        TextField tfNota3= new TextField();
        TextField tfNota4= new TextField();

        painelFormulario.getChildren().addAll(
                lblNomeAluno,tfNomeAluno,
                lblNota1, tfNota1,
                lblNota2, tfNota2,
                lblNota3, tfNota3,
                lblNota4, tfNota4
        );

        VBox painelBotoes= new VBox();
        //painelBotoes.setStyle("-fx-background-color: #8b85f7");//
        painelBotoes.setSpacing(15);
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.setPadding(new Insets(0,10,0,0));
        painelBotoes.setStyle("-fx-background-color: #aca8f9");


        Button btCalcular = new Button("Calcular média");
        btCalcular.setPrefWidth(150);
        btCalcular.setPrefHeight(90);
        btCalcular.setStyle("-fx-background-color: #00cc84");


        Button btLimpar= new Button("Limpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(90);
        btLimpar.setStyle("-fx-background-color:#f3be3e");


        Button btSair = new Button("Sair");
        btSair.setPrefWidth(150);
        btSair.setPrefHeight(90);
        btSair.setStyle("-fx-background-color: #ff4e32");


        painelBotoes.getChildren().addAll(
                btCalcular,
                btLimpar,
                btSair
        );

        VBox painelResultado = new VBox();
        painelResultado.setStyle("-fx-background-color: #5a51f4");
        Label lblResultados = new Label("Resultados: ");
        Label lblNomeResultado = new Label("Aluno (a): ");
        Label lblMediaFinal = new Label("Media FInal: ");
        Label lblSituacao = new Label("Situação: ");

        painelResultado.getChildren().addAll(
                lblResultados,
                lblNomeResultado,
                lblMediaFinal,
                lblSituacao
        );

        // Criar o objeto scene //
        Scene scene = new Scene(root);

        // Colar scene no stage//
        stage.setScene(scene);

        // Adicionando o conteúdo ao root//
        root.setTop(painelSuperior);
        root.setCenter(painelFormulario);
        root.setRight(painelBotoes);
        root.setBottom(painelResultado);

        stage.show();
    }
}
