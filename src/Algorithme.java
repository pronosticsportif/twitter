import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Algorithme {
public static float getResult(String filePath , String filePath2)
{
float resultPositifEquipe1 = 0 ;	
float resultNegatifEquipe1 = 0 ;
float resultPositifEquipe2 = 0 ;
float resultNegatifEquipe2 = 0 ;
int total1 = 0 ;
int total2 = 0 ;
float resultFinal = 0 ;
int linee1 = 0 ;
int linee2 = 0 ;
float coef = 0 ;
try{
		
		BufferedReader buff = new BufferedReader(new FileReader(filePath));
		BufferedReader buff2 = new BufferedReader(new FileReader(filePath2));
		try {
			String line2;
		String line;
	 
		String[] x = new String[2];
		
		while ((line = buff.readLine()) != null) {
		 if(!line.isEmpty())
		 { 
			 total1++;
		  System.out.println(line);
		   x =  line.split(",");
		   if(Integer.valueOf(x[0]).intValue() == 1)
		   {   linee1 ++ ;
			   resultPositifEquipe1 += Integer.valueOf(x[0]).floatValue() * 
					(Integer.valueOf(x[1]).floatValue() + Integer.valueOf(x[2]).floatValue()) ;
		   }
		   else if (Integer.valueOf(x[0]).intValue() == -1)
		   {
			   linee1 ++ ;
			   resultNegatifEquipe1 +=  Integer.valueOf(x[0]).floatValue() * 
		   
				(Integer.valueOf(x[1]).floatValue() + Integer.valueOf(x[2]).floatValue()) ;
		 }}
		}
		while ((line2 = buff2.readLine()) != null) {
			 if(!line2.isEmpty())
			 { 
				 total2++;
			   
			   x =  line2.split(",");	
			if(Integer.valueOf(x[0]).intValue() == 1)
			{	resultPositifEquipe2 +=  Integer.valueOf(x[0]).intValue() * 
						(Integer.valueOf(x[1]).intValue() + Integer.valueOf(x[2]).intValue()) ;
			linee2 ++ ;
			}
			   else if (Integer.valueOf(x[0]).intValue() == -1)
				   {resultNegatifEquipe2 +=  Integer.valueOf(x[0]).intValue() * 
					(Integer.valueOf(x[1]).intValue() + Integer.valueOf(x[2]).intValue()) ;
				   linee2 ++ ;
				   }
				   }
		}} finally {
	
		buff.close();
		}
		} catch (IOException ioe) {
			
		
		System.out.println("Erreur --" + ioe.toString());
		}
	System.out.println(linee1);
	System.out.println(linee2);
	System.out.println("total 1 : " + total1 + " total 2 = " + total2);
	coef =(float) linee1 / linee2 ;
	resultFinal = (resultPositifEquipe1 - (resultNegatifEquipe2 * coef)) / (resultPositifEquipe1 - resultNegatifEquipe1 + (resultPositifEquipe2 * coef)- (resultNegatifEquipe2 * coef));
	System.out.println("coef = " + coef);


	

return resultFinal ;

}

public static void main(String[] args)
{  
	System.out.println("result = " + getResult("RealvsBayern1.txt",("BayernvsReal2.txt"))* 100 + " %" );
}
}
