package cardgames;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SolitaireController {

    private Solitaire game = new Solitaire();

    @FXML
    private Pane tableau1;
    @FXML
    private Pane tableau2;
    @FXML
    private Pane tableau3;
    @FXML
    private Pane tableau4;
    @FXML
    private Pane tableau5;
    @FXML
    private Pane tableau6;
    @FXML
    private Pane tableau7;
    @FXML
    private Pane handPile;
    @FXML
    private Pane wastePile;
    @FXML
    private Pane suitPile1;
    @FXML
    private Pane suitPile2;
    @FXML
    private Pane suitPile3;
    @FXML
    private Pane suitPile4;

    @FXML
    void initialize() {
        resetBoard();
        drawBoard();
    }

    private void resetBoard() {
        handPile.getChildren().clear();
        wastePile.getChildren().clear();
        tableau1.getChildren().clear();
        tableau2.getChildren().clear();
        tableau3.getChildren().clear();
        tableau4.getChildren().clear();
        tableau5.getChildren().clear();
        tableau6.getChildren().clear();
        tableau7.getChildren().clear();
        suitPile1.getChildren().clear();
        suitPile2.getChildren().clear();
        suitPile3.getChildren().clear();
        suitPile4.getChildren().clear();
    }

    private void drawBoard() {

        drawHandPile();
        drawWastePile();
        drawSuitPiles();
        drawTableaus();
    }

    private void drawHandPile() {
        if (!game.getHandPile().getDeck().isEmpty()) {
            addCardImage(handPile, "cardback", 0.0, 0.0);
        }
    }

    private void drawWastePile() {
        if (!game.getWastePile().getDeck().isEmpty()) {
            int threeMax = Math.min(game.getWastePile().getDeck().size(), 3);
            for (int i = game.getWastePile().getDeck().size() - 1; i > game.getWastePile().getDeck().size() - 1
                    - threeMax; i--) {
                addCardImage(wastePile,
                        game.getWastePile().getDeck().get(game.getWastePile().getDeck().size() - 1).toString(), 20.0,
                        0.0);

            }
        }
    }

    private void drawSuitPiles() {
        for (int suitNum = 0; suitNum < 4; suitNum++) {
            if (!game.getSuitPiles().get(suitNum).getDeck().isEmpty()) {
                switch (suitNum) {
                    case 1:
                        addCardImage(suitPile2, game.getSuitPiles().get(suitNum)
                                .getCard(game.getSuitPiles().get(suitNum).getDeck().size()).toString(), 0.0, 0.0);
                        break;
                    case 2:
                        addCardImage(suitPile3, game.getSuitPiles().get(suitNum)
                                .getCard(game.getSuitPiles().get(suitNum).getDeck().size()).toString(), 0.0, 0.0);
                        break;
                    case 3:
                        addCardImage(suitPile4, game.getSuitPiles().get(suitNum)
                                .getCard(game.getSuitPiles().get(suitNum).getDeck().size()).toString(), 0.0, 0.0);
                        break;

                    default:
                        addCardImage(suitPile1, game.getSuitPiles().get(suitNum)
                                .getCard(game.getSuitPiles().get(suitNum).getDeck().size()).toString(), 0.0, 0.0);
                        break;
                }
            }

        }
    }

    private void drawTableaus() {
        double offset = 30.0;
        for (int tabNum = 0; tabNum < game.getTableaus().size(); tabNum++) {
            for (int cardNum = 0; cardNum < game.getTableaus().get(tabNum).getDeck().size(); cardNum++) {
                Card card = game.getTableaus().get(tabNum).getCard(cardNum);
                switch (tabNum) {
                    case 1:
                        addCardImage(tableau2, card.toString(), 0.0, cardNum * offset);
                        break;
                    case 2:
                        addCardImage(tableau3, card.toString(), 0.0, cardNum * offset);
                        break;
                    case 3:
                        addCardImage(tableau4, card.toString(), 0.0, cardNum * offset);
                        break;
                    case 4:
                        addCardImage(tableau5, card.toString(), 0.0, cardNum * offset);
                        break;
                    case 5:
                        addCardImage(tableau6, card.toString(), 0.0, cardNum * offset);
                        break;
                    case 6:
                        addCardImage(tableau7, card.toString(), 0.0, cardNum * offset);
                        break;
                    default:
                        addCardImage(tableau1, card.toString(), 0.0, cardNum * offset);
                        break;
                }
            }
        }
    }

    private void addCardImage(Pane pane, String cardText, double xOffSet, double yOffSet) {
        ImageView imv1 = new ImageView();
        if (cardText.equals("??")) {
            cardText = "cardback";
        }
        Image image = new Image(SolitaireController.class.getResourceAsStream("images/" + cardText + ".png"));
        imv1.setImage(image);
        pane.getChildren().add(imv1);
        imv1.setX(xOffSet);
        imv1.setY(yOffSet);
    }
}
