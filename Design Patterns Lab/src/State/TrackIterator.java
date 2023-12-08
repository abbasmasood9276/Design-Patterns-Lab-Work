/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author fa20-bse-001
 */
import java.util.Timer;
import java.util.TimerTask;

public class TrackIterator {
    private Player player;
    private Timer timer;

    public TrackIterator(Player player) {
        this.player = player;
    }

    public void start() {
        timer = new Timer();
        timer.schedule(new TrackCheckTask(), 3000, 3000); // Check every 3 seconds
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private class TrackCheckTask extends TimerTask {
        private int consecutiveSeconds = 0;

        @Override
        public void run() {
            int currentTrack = player.getCurrentTrack();

            if (currentTrack == 4 && player.getState() instanceof PlayingState) {
                consecutiveSeconds += 3;  // Increment by the interval (3 seconds)

                if (consecutiveSeconds >= 3) {
                    stopPlayerAndAlert(currentTrack);
                }
            } else {
                consecutiveSeconds = 0;  // Reset the count if not in track 5 playing mode
            }
        }
    }

    private void stopPlayerAndAlert(int currentTrack) {
        player.changeState(new LockedState(player));
        player.stopPlayback();
        player.setCurrentTrackAfterStop();
        System.out.println("Player damaged at Track " + currentTrack + "! Please reset.");
    }
}


