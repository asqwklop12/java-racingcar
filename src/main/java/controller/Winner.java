package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Track;

public class Winner {

	private final static String WINPLAYER = "승리자는 ";
	private final static String END = "입니다.";
	private final static int FIRST = 0;
	private final static String COMMA = ",";

	private int winCount(List<Track> tracks) {
		int max = tracks.get(FIRST).getPosition();
		for (Track track : tracks) {
			int current = track.getPosition();
			if (max < current) {
				max = current;
			}
		}
		return max;
	}

	private List<String> addWinPlayer(List<Track> tracks, int max) {
		List<String> winPlayers = new ArrayList<String>();

		for (Track track : tracks) {

			if (max == track.getPosition()) {
				winPlayers.add(track.getCar().getName());
			}
		}
		return winPlayers;
	}

	public String winner(List<Track> tracks) {
		int max = winCount(tracks);
		return WINPLAYER + addWinPlayer(tracks, max).stream().collect(Collectors.joining(COMMA)) + END;
	}

}
