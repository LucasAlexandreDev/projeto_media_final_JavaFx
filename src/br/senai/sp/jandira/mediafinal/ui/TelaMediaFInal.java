package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TelaMediaFInal extends Application {

    VBox painelResultado;
    TextField tfNomeAluno;
    TextField tfNota1;
    TextField tfNota2;
    TextField tfNota3;
    TextField tfNota4;

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

        tfNomeAluno= new TextField();
        tfNota1= new TextField();
        tfNota2= new TextField();
        tfNota3= new TextField();
        tfNota4= new TextField();

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
        painelBotoes.setPadding(new Insets(0,12,0,0));
        painelBotoes.setStyle("-fx-background-color: #aca8f9");

        Button btCalcular = new Button("Calcular média");
        btCalcular.setPrefWidth(150);
        btCalcular.setPrefHeight(75);
        btCalcular.setStyle("-fx-background-color: #00cc84");

        Button btLimpar= new Button("Limpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(55);
        btLimpar.setStyle("-fx-background-color:#f3be3e");


        Button btSair = new Button("Sair");
        btSair.setPrefWidth(150);
        btSair.setPrefHeight(55);
        btSair.setStyle("-fx-background-color: #ff4e32");

        painelBotoes.getChildren().addAll(
                btCalcular,
                btLimpar,
                btSair
        );

        painelResultado = new VBox();
        painelResultado.setPadding(new Insets(15));
        painelResultado.setStyle("-fx-background-color: #5a51f4");

        Label lblResultados = new Label("Resultados: ");
        lblResultados.setStyle("-fx-font-size:18; -fx-text-fill: white; -fc-font-weight: bold");

        Label lblNomeResultado = new Label("Aluno (a): ");
        lblNomeResultado.setStyle("-fx-text-fill: white");

        Label lblMediaFinal = new Label("Media FInal: ");
        lblMediaFinal.setStyle("-fx-text-fill: white");

        Label lblSituacao = new Label("Situação: ");
        lblSituacao.setStyle("-fx-text-fill: white");

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

        // Interceptar cliques nos botões//
        btCalcular.setOnAction(e -> {

            if (validarEntrada()){
                String nomeAluno = tfNomeAluno.getText();
                lblNomeResultado.setText("Aluno(a): " + nomeAluno);

                String nota1= tfNota1.getText();
                String nota2= tfNota2.getText();
                String nota3= tfNota3.getText();
                String nota4= tfNota4.getText();

                double media = calcularMediaFinal(nota1,nota2,nota3,nota4);
                String mediaFormatada = String.format("%.2f", media);
                lblMediaFinal.setText("Media FInal: " + media);

                String situacao = definirSituacao(media);
                lblSituacao.setText("Situação: " +situacao);

            }
        });

        btLimpar.setOnAction(e -> {
            tfNomeAluno.setText("");
            tfNota1.setText("");
            tfNota2.setText("");
            tfNota3.setText("");
            tfNota4.setText("");

            lblNomeResultado.setText("Nome do Aluno (a): ");
            lblMediaFinal.setText("Media FInal: ");
            painelResultado.setStyle("-fx-background-color: #5a51f4");
            lblSituacao.setText("Situação: ");

            tfNomeAluno.requestFocus();
        });

        btSair.setOnAction(e -> {

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente sair do programa?", ButtonType.YES, ButtonType.NO);
            Optional <ButtonType> confirmacao = alerta.showAndWait();
            System.out.println(confirmacao.get().getText());

            if (confirmacao.get() == ButtonType.YES){
                System.exit(0);
            }
        });

    }

    private double calcularMediaFinal(String n1, String n2, String n3, String n4) {
        double nota1= Double.parseDouble(n1);
        double nota2= Double.parseDouble(n2);
        double nota3= Double.parseDouble(n3);
        double nota4= Double.parseDouble(n4);
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }

    private String definirSituacao(double media) {
        if (media < 4) {
            painelResultado.setStyle("-fx-background-color: #ff4e32");
            return "REPROVADO !!";
        } else if (media >= 6) {
            painelResultado.setStyle("-fx-background-color: #00cc84");
            return "APROVADO !!";
        }else{
            painelResultado.setStyle("-fx-background-color: #f3be3e");
            return "RECUPERAÇÃO !!";
        }
    }

    private boolean validarEntrada(){
        if (tfNomeAluno.getText().isEmpty()){
        mostrarMensagem(Alert.AlertType.ERROR, "Preencha o nome do aluno!");
        tfNomeAluno.requestFocus();
        return false;
        }else if(tfNota1.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 1 do aluno!");
            tfNota1.requestFocus();
            return false;
        }else if (tfNota2.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 2 do aluno!");
            tfNota2.requestFocus();
            return false;
        }else if (tfNota3.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 3 do aluno!");
            tfNota3.requestFocus();
            return false;
        }else if (tfNota4.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a nota 4 do aluno!");
            tfNota4.requestFocus();
            return false;
        }
        return true;
    }

    private void mostrarMensagem(Alert.AlertType tipo, String mensagem){
        Alert alerta = new Alert(tipo, mensagem);
        alerta.showAndWait();
    }

}
