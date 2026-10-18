package dev.chearcode.battleship.addressconverter;

import dev.chearcode.battleship.board.Coordinates;

public interface AddressConverter {
    Coordinates toCoordinates(String address);

    String toAddress(Coordinates coordinates);
}
