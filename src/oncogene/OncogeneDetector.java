package oncogene;

import java.util.ArrayList;

public class OncogeneDetector {
	boolean isOncogene(ArrayList<String> healthySequences, ArrayList<String> cancerSequences, String candidate){
		int occurrencesInHealthySequences = 0;
		int occurrencesInCancerSequences = 0;
		for(String str : healthySequences)
			for(int i = 0; i < str.length(); i++)
				for(int j = i + 1; j <= str.length(); j++)
					if(str.substring(i, j) == candidate)
						occurrencesInHealthySequences++;
		for(String str : cancerSequences)
			for(int i = 0; i < str.length(); i++)
				for(int j = i + 1; j <= str.length(); j++)
					if(str.substring(i, j) == candidate)
						occurrencesInCancerSequences++;
		double portionOfHealthySequences = occurrencesInHealthySequences / healthySequences.size();
		double portionOfCancerSequences = occurrencesInCancerSequences / cancerSequences.size();
		return portionOfCancerSequences > portionOfHealthySequences;
	}
}
