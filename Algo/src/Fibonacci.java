
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {

	static private long controlMatrix[][] = new long[2][2];
	static long[][] finalmatrix = new long[2][2];
	static int MainCounter=0;
	static int MainMultipleCounter = 0;
	
	public static void multiply_Operations(long [][] firstTempMatrix,long[][] SecondTempMatrix) {
		controlMatrix[0][0] = firstTempMatrix[0][0] * SecondTempMatrix[0][0] + firstTempMatrix[0][1] * SecondTempMatrix[1][0];
		controlMatrix[0][1] = firstTempMatrix[0][0] * SecondTempMatrix[0][1] + firstTempMatrix[0][1] * SecondTempMatrix[1][1];
		controlMatrix[1][0] = firstTempMatrix[1][0] * SecondTempMatrix[0][0] + firstTempMatrix[1][1] * SecondTempMatrix[1][0];
		controlMatrix[1][1] = firstTempMatrix[1][0] * SecondTempMatrix[0][1] + firstTempMatrix[1][1] * SecondTempMatrix[1][1];
		
		firstTempMatrix[0][0] = controlMatrix[0][0];
		firstTempMatrix[0][1] = controlMatrix[0][1];
		firstTempMatrix[1][0] = controlMatrix[1][0];
		firstTempMatrix[1][1] = controlMatrix[1][1];
		
		MainCounter += 4;
		MainMultipleCounter += 8;
	}
	
	public static void powerCalculator(int passedPower, long[][] passedMatrix) {
		if(passedPower == 1) {
			return;
		}
		else {
			long[][] shlellMatrix = new long[2][2];
			shlellMatrix[0][0]= 0;
			shlellMatrix[0][1]= 1;
			shlellMatrix[1][0]= 1;
			shlellMatrix[1][1]= 1;
			
			powerCalculator(passedPower/2,passedMatrix);
			multiply_Operations(passedMatrix,passedMatrix);
			
			if(passedPower % 2 != 0 ) {
				multiply_Operations(passedMatrix,shlellMatrix);
			}
			
		}
	}
	
	
	
    public static void main(String[] args) throws IOException {
        
    	
    	
    	finalmatrix[0][0] = 0;
    	finalmatrix[0][1] = 1;
    	finalmatrix[1][0] = 1;
    	finalmatrix[1][1] = 1;
    	
    	
    	StringBuilder builder = new StringBuilder();
        builder.append("Index holder,add-operations ,multiply-operations\n");
        for (int i = 2; i < 65; i++) {
    
            powerCalculator(i,finalmatrix);
            builder.append(i).append(",").append(MainCounter).append(",").append(MainMultipleCounter).append("\n");
            
            finalmatrix[0][0] = 0;
        	finalmatrix[0][1] = 1;
        	finalmatrix[1][0] = 1;
        	finalmatrix[1][1] = 1;
        	
        	MainCounter=0;
        	MainMultipleCounter = 0;
            
        }
        File results = new File("result.csv");
        results.createNewFile();
        FileWriter writer = new FileWriter(results);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }


}