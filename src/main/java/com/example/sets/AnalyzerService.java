package com.example.sets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class AnalyzerService {
	public AnalyzerService() {}

	public List<String> analizeOne(List<String> list) {
		
		List<String> resultOne = new ArrayList<String>();
		
//		System.out.println("set:" + list);
		// TODO Auto-generated method stub
	//	resultOne.add(list);
		
		
		int cardinality = list.size();
		String members = list.toString();
		List<List<String>> powerSet =  new ArrayList<List<String>>();
		powerSet = getPowerSet(list);

/*		System.out.println("cardinality:" + cardinality);
		System.out.println("members:" + members);
		System.out.println("powerSet:" + powerSet);
*/		
		resultOne.add(String.valueOf(cardinality));
		resultOne.add(members);
		resultOne.add(2, powerSet.toString());	
		
		return resultOne;
	}
	
	
	
	public List<List<String>> getPowerSet(List<String> set) {
	    List<List<String>> powerSet = new ArrayList<List<String>>();
	    int max = 1 << set.size();
	    for(int i=0; i < max; i++) {
	        List<String> subSet = getSubSet(i, set);
	        powerSet.add(subSet);
	    }
	    return powerSet;
	}
	
	private List<String> getSubSet(int p, List<String> set) {
	    List<String> subSet = new ArrayList<String>();
	    int position = 0;
	    for(int i=p; i > 0; i >>= 1) {
	        if((i & 1) == 1) {
	            subSet.add(set.get(position));
	        }
	        position++;
	    }
	    return subSet;
	}

	public List<String> analyzeBoth(List<String> set1, List<String> set2) {
		
		List<String> result = new ArrayList<String>();
	
		System.out.println("set1:" + set1);
		System.out.println("set2:" + set2);
		
		
		boolean comparation = getComparationResult(set1,set2);
		boolean subsetA = getSubsetResult(set1,set2);
		boolean subsetB = getSubsetResult(set2,set1);
		boolean properSubsetA = getProperSubsetResult(set1,set2);
		boolean properSubsetB = getProperSubsetResult(set2,set1);
		List<String> differenceAB = getDifference(set1,set2);
		List<String> differenceBA = getDifference(set2,set1);
		List<String> diffSymetricAB = getSymetDifference(set1,set2);
		List<String> diffSymetricBA = getSymetDifference(set2,set1);
		List<String> unionAB = getUnionAB(set1,set2);
		
		/*Comparation a=b?.......		DONE
		 * Subset ac=b? bc=a?........	DONE
		 * proper subset acb? bca?.....	DONE
		 * difference a-b?, b-a?.......DONE
		 * symetric diff a-b? b-a?......DONE
		 * union aub
		 * intersection a^b? are disjoint?
		 * product a*b, b*a
		 * */
		
		result.add("A=B? "+String.valueOf(comparation));
		result.add("AC=B? "+String.valueOf(subsetA));
		result.add("BC=A? "+String.valueOf(subsetB));
		result.add("ACB? "+String.valueOf(properSubsetA));
		result.add("BCA? "+String.valueOf(properSubsetB));
		result.add("A-B: "+differenceAB.toString());
		result.add("B-A: "+differenceBA.toString());
		result.add("Symetric diff(A-B):"+diffSymetricAB.toString());
		result.add("Symetric diff(B-A):"+diffSymetricBA.toString());
		result.add("A U B:"+unionAB.toString());
		return result;
	}


private List<String> getUnionAB(List<String> set1, List<String> set2) {
		List<String> inter1 = new ArrayList<String>();
		/*
		for(int i=0;i<set1.size();i++) {
			String target = set1.get(i);
				if(set2.contains(target)&&set1.contains(target)) {
					//do nothing
				}else {
					int pos = set1.indexOf(target);
					inter1.add(set1.get(pos));
			}
		}*/
		inter1.addAll(set1);
		inter1.addAll(set2);
		
		return inter1;
	}

private List<String> getSymetDifference(List<String> set1, List<String> set2) {
		List<String> inter1 = new ArrayList<String>();
		inter1.addAll(getIntermediateSymet(set1,set2));
		inter1.addAll(getIntermediateSymet(set2,set1));
		return inter1;
	}

private List<String> getIntermediateSymet(List<String> set1, List<String> set2) {
	List<String> res = new ArrayList<String>();
	for(int i=0;i<set1.size();i++) {
		String target = set1.get(i);
			if(set2.contains(target)&&set1.contains(target)) {
				//do nothing
			}else {
				int pos = set1.indexOf(target);
				res.add(set1.get(pos));
		}
	}
	return res;
}

//	String expresion1 = "estos son mis datos";//mychar.content1;
//	String expresion2 ="estos,datos,son";// "1,2,3,4,5";//mychar.content2;

	


	
	private List<String> getDifference(List<String> set1, List<String> set2) {
		List<String> cloned_list = new ArrayList<String>(set1); 
		for(int j=0;j<set2.size();j++) {
			String target = set2.get(j);
			cloned_list.remove(target);
		}	
		return cloned_list ;
	}
	
	private boolean getSubsetResult(List<String> set1, List<String> set2) {
		boolean result = false;
		int cont = 0;
		for (int i=0;i<set2.size();i++) {
			for(int j=0;j<set1.size();j++) {
				if(set1.get(j).equals(set2.get(i))) {
					cont++;
				}
			}
		}
		if(cont == set1.size()) {
			result = true;
		}
		return result;
	}
	
	private boolean getProperSubsetResult(List<String> set1, List<String> set2) {
		boolean result = false;
		int cont = 0;
		for (int i=0;i<set2.size();i++) {
			for(int j=0;j<set1.size();j++) {
				if(set1.get(j).equals(set2.get(i))) {
					cont++;
				}
			}
		}
		if(cont == set1.size()&&cont<set2.size()) {
			result = true;
		}
		return result;
	}

	public boolean getComparationResult(List<String> elements1, List<String> elements2) {
	    // Optional quick test since size must match
	    if (elements1.size() != elements2.size()) {
	        return false;
	    }
	    List<String> work = new ArrayList<String>(elements2);
	    for (String element : elements1) {
	        if (!work.remove(element)) {
	            return false;
	        }
	    }
	    return work.isEmpty();
	}
}
//	 	


	 