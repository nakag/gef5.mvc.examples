package tmdmaker.ui.editor.gef5.visuals;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import tmdmaker.ui.editor.gef5.model.Entity;

public class EntityShape extends Pane {
	Text entityName = new Text();
	Text type = new Text();
	VBox identifieres = new VBox();
	VBox attributes = new VBox();

	public EntityShape() {
		super();
		setBackground(new Background(new BackgroundFill(Color.CYAN, null, null)));
		setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		BorderPane bp = new BorderPane();
		BorderPane titlePane = new BorderPane();
		titlePane.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null,
				new BorderWidths(0, 0, 1, 0), new Insets(0, -1, 0, 0))));
		bp.setTop(titlePane);
		getChildren().add(bp);

		// the entityName
		{
			entityName.setTextOrigin(VPos.CENTER);
			entityName.setTextAlignment(TextAlignment.CENTER);
			titlePane.setCenter(entityName);
			titlePane.setPadding(new Insets(1));
			BorderPane.setAlignment(entityName, Pos.CENTER);
		}
		// the enityType
		{
			type.setTextOrigin(VPos.CENTER);
			type.setTextAlignment(TextAlignment.RIGHT);
			titlePane.setRight(type);
			BorderPane.setAlignment(type, Pos.CENTER_RIGHT);
		}
		// the identifieres
		{
			identifieres.setSpacing(1);
			identifieres.setPadding(new Insets(2));
			bp.setLeft(identifieres);
			identifieres.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, null,
					new BorderWidths(0, 1, 0, 0), new Insets(0, 0, -1, 0))));
		}
		// the attributes
		{
			attributes.setSpacing(1);
			attributes.setPadding(new Insets(2));
			bp.setRight(attributes);

		}

	}

	public void update(Entity e) {

		entityName.setText(e.getName());
		type.setText("R");
		setBackground(new Background(new BackgroundFill(e.getColor(), null, null)));
		// the attribute
		{
			attributes.getChildren().clear();
			Text rightName = new Text();
			rightName.setText(e.getName() + "名");
			rightName.setTextOrigin(VPos.CENTER);
			attributes.getChildren().add(rightName);
			
			ObservableList<Node> attributeList = attributes.getChildren();
			for (String attribute : e.getAttributes()) {
				attributeList.add(new Text(attribute));
			}
		}
		// the text
		{
			identifieres.getChildren().clear();
			Text leftName = new Text();
			leftName.setText(e.getName() + "番号");
			leftName.setTextOrigin(VPos.CENTER);
			identifieres.getChildren().add(leftName);
		}

	}

}
