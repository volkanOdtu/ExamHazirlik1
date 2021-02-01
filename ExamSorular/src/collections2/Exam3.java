package collections2;

import java.util.Arrays;
import java.util.List;

public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam3 e = new Exam3();
		e.totalScore(8 ,null);
	}

	public int totalScore(int num, List<String> blocksNew)
    {
		RobotScore robot = new RobotScore();
		List<String> blocks =Arrays.asList( "5" ,"-2" ,"4" ,"Z" ,"X" ,"9" ,"+" ,"+");

		//List<String> blocks =Arrays.asList( "4" ,"1" ,"+" ,"Z" );

		for(String s: blocks)
			robot.addScore(s);
		
		return robot.getScore();
				
    }
	static class RobotScore{
		int score;
		int lastStep ;
		int lastStepMinus1;
		int lastStepMinus2;
		
		
		public void setScore(int val) {
			score = score + val;
			lastStepMinus2 = lastStepMinus1;
			lastStepMinus1 = lastStep;
			lastStep =  val;
		}
		
		public void setScoreForZ(int val) {
			score = score + val;
			int temp = lastStepMinus1;
			lastStepMinus1 = lastStepMinus2;
			lastStep = temp;
//			lastStepMinus2 = lastStepMinus1;
//			lastStepMinus1 = lastStep;
//			lastStep =  val;
		}
		
		 
		public int getScore() {
			return score;
		}
		public void addScore(String block) {
			if(block.equals("X")) {
				this.setScore( lastStep * 2 );
			} else if(block.equals("+")){
				this.setScore( lastStep + lastStepMinus1);
			} else if( block.equals("Z") ) {
				this.setScoreForZ( -1 * lastStep  );
			} else
				this.setScore(Integer.parseInt(block));
				
		}
	}
}
