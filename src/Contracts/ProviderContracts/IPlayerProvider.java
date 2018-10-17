package Contracts.ProviderContracts;

import Models.Player;

public interface IPlayerProvider {
    Player getPlayer(Integer id);
    Player[] getPlayers();
    boolean checkPin(Integer id, Integer pin);
    boolean setPin(Integer id, Integer oldPin, Integer newPin);
}
