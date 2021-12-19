package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    AbstractWorldMap map;

    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 30;
        int height = 30;
        Vector2d right_corner = map.mapBoundary.getRightCorner();
        Vector2d left_corner = map.mapBoundary.getLeftCorner();
        GridPane gridPane = new GridPane();

        Label start_grid = new Label("y/x");
        GridPane.setHalignment(start_grid, HPos.CENTER);
        gridPane.add(start_grid, 0, 0, 1, 1);

        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));

        int x_distance = right_corner.x - left_corner.x;
        int y_distance = right_corner.y - left_corner.y;

        for( int j = 1; j <= x_distance ; j++ ){
            Label label = new Label(Integer.toString(j));
            gridPane.addRow(0,label);
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        }

        for( int j = 1; j <= y_distance ; j++ ){
            Label label = new Label(Integer.toString(y_distance - j));
            gridPane.addColumn(0,label);
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
        }

        for( int i = 1; i <= x_distance ; i++ ){
            for( int j = 1; j <= y_distance ; j++ ){
                Vector2d position = new Vector2d(i, y_distance - j);
                String result = null;
                Object object = map.objectAt(position);
                if(object != null){
                    result = object.toString();
                }
                Label label = new Label(result);
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, i   , j  ,1, 1);
            }
        }

        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            //IWorldMap map = new RectangularMap(10,5);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,2) , new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

    }

}
