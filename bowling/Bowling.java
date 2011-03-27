import java.io.*;
import java.util.*;

public class Bowling {
    private static final String STRIKE = "X";
    private static final String SPARE = "/";

    public int calcScore(String str) {
    	String[] arr = str.split("\\s");
    	List<String> list = new LinkedList<String>();
    	for (String s : arr) {
    		list.add(s);
    	}
        return getScore(1, 0, list);
    }

    private int getScore(int frame, int currScore, List<String> balls) {
        if (frame == 10) {
            if (balls.size() == 2) {
                return currScore + getBallValue(balls.get(0)) + getBallValue(balls.get(1));
            } else {
                String ball_1 = balls.get(0);
                String ball_2 = balls.get(1);
                String ball_3 = balls.get(2);

                if (STRIKE.equals(ball_3)) {
                    if (STRIKE.equals(ball_2)) {
                        return currScore + 30;
                    } else if (SPARE.equals(ball_2)) {
                        return currScore + 20;
                    } else {
                        throw new RuntimeException("Invalid frame: " + ball_1 + "," + ball_2 + "," + ball_3);
                    }
                } else if (SPARE.equals(ball_3)) {
                    return currScore + 20;
                } else if (SPARE.equals(ball_2)) {
                    return currScore + 10 + getBallValue(ball_3);
                } else {
                	return currScore + getBallValue(ball_1) + getBallValue(ball_2) + getBallValue(ball_3); 
                }
            }
        } else {
            String ball_1 = balls.remove(0);

            if (STRIKE.equals(ball_1)) {
            	String ball_2 = balls.get(0);
            	String ball_3 = balls.get(1);
            	if (SPARE.equals(ball_3)) {
            		currScore += 20;
            	} else {
            		currScore += 10 + getBallValue(ball_2) + getBallValue(ball_3);
            	}
            } else {
                String ball_2 = balls.remove(0);
                if (SPARE.equals(ball_2)) {
                    currScore += 10 + getBallValue(balls.get(0));
                } else {
                    currScore += getBallValue(ball_1) + getBallValue(ball_2);
                }
            }

            return getScore(frame + 1, currScore, balls);
        }
    }

    private int getBallValue(String ball) {
        if (STRIKE.equals(ball) || SPARE.equals(ball)) {
            return 10;
        } 

        return Integer.parseInt(ball);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line;
        Bowling bowling = new Bowling();
        while ((line = br.readLine()) != null) {
        	if (!(line.startsWith("#"))) {
                System.out.println(bowling.calcScore(line));        		
        	}
        }
    }
}