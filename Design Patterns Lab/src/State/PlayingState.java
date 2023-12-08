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


public class PlayingState extends State {
    private TrackIterator trackIterator;

    PlayingState(Player player) {
        super(player);
        trackIterator = new TrackIterator(player);
    }

    @Override
    public String onLock() {
        trackIterator.stop();
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        trackIterator.start();
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}

