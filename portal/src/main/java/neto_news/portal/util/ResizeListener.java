package neto_news.portal.util;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public final class ResizeListener implements EventHandler<MouseEvent> {
  private Stage stage;
  private Cursor cursorEvent = Cursor.DEFAULT;
  private int border = 4;
  private double startX = 0;
  private double startY = 0;
  /* RESIZEEE */
  private static double xOffset = 0;
  private static double yOffset = 0;

  public ResizeListener() {
  }

  public void handle(MouseEvent mouseEvent) {
    EventType<? extends MouseEvent> mouseEventType = mouseEvent.getEventType();
    Scene scene = stage.getScene();

    double mouseEventX = mouseEvent.getSceneX(), mouseEventY = mouseEvent.getSceneY(),
        sceneWidth = scene.getWidth(), sceneHeight = scene.getHeight();

    if (MouseEvent.MOUSE_MOVED.equals(mouseEventType) == true) {
      if (mouseEventX < border && mouseEventY < border) {
        cursorEvent = Cursor.NW_RESIZE;
      } else if (mouseEventX < border && mouseEventY > sceneHeight - border) {
        cursorEvent = Cursor.SW_RESIZE;
      } else if (mouseEventX > sceneWidth - border && mouseEventY < border) {
        cursorEvent = Cursor.NE_RESIZE;
      } else if (mouseEventX > sceneWidth - border && mouseEventY > sceneHeight - border) {
        cursorEvent = Cursor.SE_RESIZE;
      } else if (mouseEventX < border) {
        cursorEvent = Cursor.W_RESIZE;
      } else if (mouseEventX > sceneWidth - border) {
        cursorEvent = Cursor.E_RESIZE;
      } else if (mouseEventY < border) {
        cursorEvent = Cursor.N_RESIZE;
      } else if (mouseEventY > sceneHeight - border) {
        cursorEvent = Cursor.S_RESIZE;
      } else {
        cursorEvent = Cursor.DEFAULT;
      }
      scene.setCursor(cursorEvent);
    } else if (MouseEvent.MOUSE_EXITED.equals(mouseEventType)
        || MouseEvent.MOUSE_EXITED_TARGET.equals(mouseEventType)) {
      scene.setCursor(Cursor.DEFAULT);
    } else if (MouseEvent.MOUSE_PRESSED.equals(mouseEventType) == true) {
      startX = stage.getWidth() - mouseEventX;
      startY = stage.getHeight() - mouseEventY;
      xOffset = mouseEvent.getSceneX();
      yOffset = mouseEvent.getSceneY();

    } else if (MouseEvent.MOUSE_DRAGGED.equals(mouseEventType) == true) {
      if (Cursor.DEFAULT.equals(cursorEvent) == false) {
        if (Cursor.W_RESIZE.equals(cursorEvent) == false
            && Cursor.E_RESIZE.equals(cursorEvent) == false) {
          double minHeight =
              stage.getMinHeight() > (border * 2) ? stage.getMinHeight() : (border * 2);
          if (Cursor.NW_RESIZE.equals(cursorEvent) == true
              || Cursor.N_RESIZE.equals(cursorEvent) == true
              || Cursor.NE_RESIZE.equals(cursorEvent) == true) {
            if (stage.getHeight() > minHeight || mouseEventY < 0) {
              stage.setHeight(stage.getY() - mouseEvent.getScreenY() + stage.getHeight());
              stage.setY(mouseEvent.getScreenY());
            }
          } else {
            if (stage.getHeight() > minHeight || mouseEventY + startY - stage.getHeight() > 0) {
              stage.setHeight(mouseEventY + startY);
            }
          }
        }

        if (Cursor.N_RESIZE.equals(cursorEvent) == false
            && Cursor.S_RESIZE.equals(cursorEvent) == false) {
          double minWidth = stage.getMinWidth() > (border * 2) ? stage.getMinWidth() : (border * 2);
          if (Cursor.NW_RESIZE.equals(cursorEvent) == true
              || Cursor.W_RESIZE.equals(cursorEvent) == true
              || Cursor.SW_RESIZE.equals(cursorEvent) == true) {
            if (stage.getWidth() > minWidth || mouseEventX < 0) {
              stage.setWidth(stage.getX() - mouseEvent.getScreenX() + stage.getWidth());
              stage.setX(mouseEvent.getScreenX());
            }
          } else {
            if (stage.getWidth() > minWidth || mouseEventX + startX - stage.getWidth() > 0) {
              stage.setWidth(mouseEventX + startX);
            }
          }
        }
      } else if (mouseEvent.getSceneY() < 70) {
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
      }
    }
  }
  
  
  public void aplicarAoStage(Stage stage) {
    this.stage = stage;
    stage.getScene().addEventHandler(MouseEvent.MOUSE_MOVED, this);
    stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED, this);
    stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
    stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED, this);
    stage.getScene().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, this);

    ObservableList<Node> children = stage.getScene().getRoot().getChildrenUnmodifiable();
    for (Node child : children) {
      addListenerDeeply(child, this);
    }
  }
  
  private void addListenerDeeply(Node node, EventHandler<MouseEvent> listener) {
    node.addEventHandler(MouseEvent.MOUSE_MOVED, listener);
    node.addEventHandler(MouseEvent.MOUSE_PRESSED, listener);
    node.addEventHandler(MouseEvent.MOUSE_DRAGGED, listener);
    node.addEventHandler(MouseEvent.MOUSE_EXITED, listener);
    node.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, listener);
    if (node instanceof Parent) {
      Parent parent = (Parent) node;
      ObservableList<Node> children = parent.getChildrenUnmodifiable();
      for (Node child : children) {
        addListenerDeeply(child, listener);
      }
    }
  }
  
}
