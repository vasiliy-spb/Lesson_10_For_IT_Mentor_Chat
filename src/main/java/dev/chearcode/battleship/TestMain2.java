package dev.chearcode.battleship;

import dev.chearcode.battleship.addressconverter.AddressConverter;
import dev.chearcode.battleship.addressconverter.EnAddressConverter;
import dev.chearcode.battleship.board.Board;
import dev.chearcode.battleship.factory.FirstBoardFactory;
import dev.chearcode.battleship.factory.SecondBoardFactory;
import dev.chearcode.battleship.renderer.BoardRenderer;
import dev.chearcode.battleship.renderer.NormalBoardRenderer;
import dev.chearcode.battleship.renderer.OpponentBoardRenderer;

public class TestMain2 {
    public static void main(String[] args) {
        System.out.println("Капитан на мостике!");

        AddressConverter addressConverter = new EnAddressConverter();
        BoardRenderer renderer = new NormalBoardRenderer(addressConverter::toAddress);
        BoardRenderer opponentBoardRenderer = new OpponentBoardRenderer(addressConverter::toAddress);

        Board firstBoard = new FirstBoardFactory().get();
        Board secodnBoard = new SecondBoardFactory().get();

        renderer.render(firstBoard);
        renderer.render(secodnBoard);
    }
}
