package Providers;

import Contracts.ProviderContracts.IPlayerProvider;
import Models.Player;

public class PlayerProvider implements IPlayerProvider {
    public Player getPlayer(Integer id) {
        return new Player();
    }

    public Player[] getPlayers() {
        return new Player[5];
    }

    public boolean checkPin(Integer id, Integer pin) {
        return false;
    }

    public boolean setPin (Integer id, Integer oldPin, Integer newPin) {
        if (checkPin(id, oldPin)) {
            try {
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
