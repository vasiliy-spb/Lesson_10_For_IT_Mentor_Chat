package dev.chearcode.battleship;

import dev.chearcode.battleship.addressconverter.AddressConverter;
import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.board.Coordinates;
import dev.chearcode.battleship.dialog.CoordinatesDialog;
import dev.chearcode.battleship.dialog.Dialog;
import dev.chearcode.battleship.dialog.EmptyDialog;
import dev.chearcode.battleship.player.Bot;
import dev.chearcode.battleship.player.Player;
import dev.chearcode.battleship.renderer.BoardRenderer;
import dev.chearcode.battleship.renderer.NormalBoardRenderer;
import dev.chearcode.battleship.renderer.OpponentBoardRenderer;

public class Game {
    private static final String ERROR_MESSAGE = "Неправильный ввод";
    private static final String TITLE = "Введите координату:";
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player current;
    private Player opponent;
    private final BoardRenderer normalBoardRenderer;
    private final BoardRenderer opponenetBoardRenderer;
    private final Dialog<Coordinates> coordinatesDialog;
    private final Dialog<String> emptyDialog;
    private final Shooter shooter;
    private final SunkChecker winChecker;
    private final AddressConverter addressConverter;

    public Game(Player firstPlayer, Player secondPlayer, AddressConverter addressConverter) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.addressConverter = addressConverter;
        this.normalBoardRenderer = new NormalBoardRenderer(addressConverter::toAddress);
        this.opponenetBoardRenderer = new OpponentBoardRenderer(addressConverter::toAddress);
        this.coordinatesDialog = new CoordinatesDialog(TITLE, ERROR_MESSAGE, addressConverter::toCoordinates);
        this.emptyDialog = new EmptyDialog("Введите Enter для передачи хода");
        this.shooter = new Shooter();
        this.winChecker = new SunkChecker();
        switchPlayers();
    }

    public void start() {
        System.out.println("--- МОРСКОЙ БОЙ ---");


        while (true) {
            System.out.println("Ход игрока: " + current.getName());

            System.out.println("Карта игрока:");
            normalBoardRenderer.render(current.getBoard());
            System.out.println("Карта противника:");
            opponenetBoardRenderer.render(opponent.getBoard());

            performPlayerMove();

            if (winChecker.isAllSunk(opponent.getBoard())) {
                System.out.println("ПОБЕДИЛ ИГРОК: " + current.getName());
                break;
            }

            emptyDialog.input();
            switchPlayers();
        }
    }

    private void performPlayerMove() {
        while (true) {
            Coordinates coordinates = getCoordinates();
            Shooter.Result shotResult = shooter.shoot(opponent.getBoard(), coordinates);

            String moveResultMessage = getMoveResultMessage(shotResult);
            System.out.println(moveResultMessage);

            opponenetBoardRenderer.render(opponent.getBoard());

            if (shotResult == Shooter.Result.MISS || shotResult == Shooter.Result.REPEAT_MISS) {
                break;
            }

            if (winChecker.isAllSunk(opponent.getBoard())) {
                break;
            }
        }
    }

    private String getMoveResultMessage(Shooter.Result shotResult) {
        if (shotResult == Shooter.Result.MISS || shotResult == Shooter.Result.REPEAT_MISS) {
            return "Мимо";
        } else if (shotResult == Shooter.Result.SUNK) {
            return "ПОТОПИЛ!";
        } else if (shotResult == Shooter.Result.HIT || shotResult == Shooter.Result.REPEAT_HIT) {
            return "Ранил..";
        }
        throw new IllegalArgumentException("Unknown shot result: " + shotResult);
    }

    private Coordinates getCoordinates() {
        if (current instanceof Bot bot) {
            Coordinates hitCoordinates = bot.getHitCoordinates(opponent.getBoard());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(TITLE);
            System.out.println(addressConverter.toAddress(hitCoordinates));
            return hitCoordinates;
        }
        while (true) {
            Coordinates coordinates = coordinatesDialog.input();
            if (isValidCoordinates(coordinates, current.getBoard())) {
                return coordinates;
            }
            System.out.println(ERROR_MESSAGE);
        }
    }

    private boolean isValidCoordinates(Coordinates coordinates, Board board) {
        return coordinates.x() >= 0 && coordinates.x() < board.getSize() && coordinates.y() >= 0 && coordinates.y() < board.getSize();
    }

    private void switchPlayers() {
        if (current == null || current == secondPlayer) {
            current = firstPlayer;
            opponent = secondPlayer;
        } else {
            current = secondPlayer;
            opponent = firstPlayer;
        }
    }
}
