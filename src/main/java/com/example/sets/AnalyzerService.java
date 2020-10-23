package com.example.sets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnalyzerService {
	public AnalyzerService() {}

	
	PartitionService partitions; 
	
	public List<String> analizeOne(List<String> list) {
		
		List<String> resultOne = new ArrayList<String>();
			
		int cardinality = list.size();
		String members = list.toString();
		members=members.replaceAll("\\[", "{").replaceAll("\\]","}");
		List<List<String>> powerSet =  new ArrayList<List<String>>();
		powerSet = getPowerSet(list);
		String power = powerSet.toString();
		power = power.replaceAll("\\[", "{").replaceAll("\\]","}");
		resultOne.add(String.valueOf(cardinality));
		resultOne.add(members);
		resultOne.add(2, power);
		List<String> partitionsSet = PartitionService.getPartitions(list);
		resultOne.add(partitionsSet.toString().replaceAll("\\[", "{").replaceAll("\\]","}"));
		
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
		List<String> intersectionAB = getIntersectionAB(set1,set2);
		boolean disjoin = areDisjoin(intersectionAB);
		List<String> productAB = getProductAB(set1,set2);
		List<String> productBA = getProductAB(set2,set1);
				
		result.add(String.valueOf(comparation));
		result.add(String.valueOf(subsetA));
		result.add(String.valueOf(subsetB));
		result.add(String.valueOf(properSubsetA));
		result.add(String.valueOf(properSubsetB));
		
		result.add(changeBracket(differenceAB.toString()));
		result.add(changeBracket(differenceBA.toString()));
		result.add(changeBracket(diffSymetricAB.toString()));
		result.add(changeBracket(diffSymetricBA.toString()));
		result.add(changeBracket(unionAB.toString()));
		result.add(changeBracket(intersectionAB.toString()));
		result.add(String.valueOf(disjoin));
		result.add(changeBracket(productAB.toString()));
		result.add(changeBracket(productBA.toString()));
		return result;
	}
	

	private String changeBracket(String string) {
		String string1 =  string.replaceAll("\\[", "{").replaceAll("\\]","}");
		return string1;
	}

	private List<String> getProductAB(List<String> set1, List<String> set2) {
		List<String> inter1 = new ArrayList<String>();
		if(set2.isEmpty()||set2.isEmpty()) {
			return inter1;
		}
		
		String data="(";
		
		for(int i=0;i<set1.size();i++) {
			for (int j=0;j<set2.size();j++) {
				data = data+set1.get(i)+","+set2.get(j)+"),(";
			}
			data = data.substring(0,data.length()-2);
			inter1.add(data);
			data="(";
		}
		return inter1;
	}

	private boolean areDisjoin(List<String> intersectionAB) {
		if(intersectionAB.size()>0) return false;
		return true;
	}

	
	private List<String> getIntersectionAB(List<String> set1, List<String> set2) {
		List<String> inter1 = new ArrayList<String>(); 
		for(int i=0;i<set2.size();i++) {
			String target = set2.get(i);
				if(set1.contains(target)) {
					int pos = set2.indexOf(target);
					inter1.add(set2.get(pos));
				}
		}
		return inter1;
	}

	
	private List<String> getUnionAB(List<String> set1, List<String> set2) {
		List<String> inter1 = new ArrayList<String>(set1); 
		for(int i=0;i<set2.size();i++) {
			String target = set2.get(i);
				if(inter1.contains(target)) {
						//do nothing
				}else {
					int pos = set2.indexOf(target);
					inter1.add(set2.get(pos));
				}
		}
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
				if(set2.contains(target)){
					//do nothing
				}else {
					int pos = set1.indexOf(target);
					res.add(set1.get(pos));
			}
		}
		return res;
	}
	
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

	 