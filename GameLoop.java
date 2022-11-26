import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class GameLoop extends Application
{
    @Override
    public void start(Stage primaryStage) {
        final double HEIGHT = 300.0, WIDTH = 400.0;
        primaryStage.setTitle("hi");
        Button btn1 = new Button("press to start");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("hello world");
            }
        });
        Group root = new Group();
        root.getChildren().add(btn1);
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        Canvas canvas = new Canvas(400, 300);
        root.getChildren().add(canvas);
        ArrayList<String> input = new ArrayList<String>();
        primaryScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!input.contains(code)) {
                            input.add(code);
                        }
                    }
                }
        );
        primaryScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                }
        );
        final GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setFill(Color.BLACK);
        ctx.fillRect(0.0, 0.0, WIDTH, HEIGHT);
        ctx.setFill(Color.WHITE);
        ctx.setLineWidth(1);
        Font mainFont = Font.font("Courier Sans MS", FontWeight.THIN, 20);
        ctx.setFont(mainFont);
        ctx.fillText("hello", WIDTH/2, HEIGHT/2);
        Vector2D velocity = new Vector2D(1, 1);
        final long startNanoTime = System.nanoTime();
        Text word = new Text(10, 50, "hello");
        root.getChildren().add(word);
        word.setSelectionFill(Color.BLACK);
        word.setFont(new Font(20));
        ctx.setFill(Color.WHITE);
        ctx.fillRect(0, 0, WIDTH, HEIGHT);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (word.getX() + word.getLayoutBounds().getWidth() + velocity.get(0) > WIDTH || word.getX() + velocity.get(0) < 0) {
                    velocity.set(0, velocity.get(0) * -1);
                }
                if (word.getY() + word.getLayoutBounds().getHeight()/2 + velocity.get(1) - 10 > HEIGHT || word.getY() + velocity.get(1) < 15) {
                    velocity.set(1, velocity.get(1) * -1);
                }
                word.setX(word.getX() + velocity.get(0));
                word.setY(word.getY() + velocity.get(1));
            }
        }.start();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 