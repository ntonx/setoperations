package com.example.sets;

import java.util.ArrayList;
import java.util.List;

public class PartitionService {
	
	public PartitionService() {}
	
	public static List<String> getPartitions(List<String> list) {
      
        List<String> partition = new ArrayList<>();
        
        List<List<List<String>>> auxiliar = new ArrayList<>();
        for(int i=1; i<=list.size(); i++) {
        	auxiliar = getPartition(list, i);
            
            String sub = auxiliar.toString();
            sub = sub.substring(1, sub.length()-1);
            partition.add(sub);
        }
        return partition;
    }

    private static List<List<List<String>>> getPartition(List<String> aux, int pos) {
        List<List<List<String>>> allPartitions = new ArrayList<>();
        if(aux.size() < pos ) return allPartitions;

        if(pos == 1) {
            List<List<String>> partition = new ArrayList<>();
            partition.add(new ArrayList<>(aux));
            allPartitions.add(partition);
            return allPartitions;
        }

        List<List<List<String>>> list_n_1 = getPartition(aux.subList(0, aux.size() - 1), pos);
        for(int i=0; i<list_n_1.size(); i++) {
            for(int j=0; j<list_n_1.get(i).size(); j++) {
                List<List<String>> a = new ArrayList<>();
                for(List<String> inner : list_n_1.get(i)) {
                    a.add(new ArrayList<>(inner));
                }
                a.get(j).add(aux.get(aux.size()-1));
                allPartitions.add(a);
            }
           
        }

        List<String> set1 = new ArrayList<>();
        set1.add(aux.get(aux.size() - 1));
        List<List<List<String>>> prev2 = getPartition(aux.subList(0, aux.size() - 1), pos - 1);
        for(int i=0; i<prev2.size(); i++) {
            List<List<String>> l = new ArrayList<>(prev2.get(i));
            l.add(set1);
            allPartitions.add(l);
        }

        return allPartitions;
    }
}
