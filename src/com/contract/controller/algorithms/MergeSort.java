/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contract.controller.algorithms;
import com.contract.model.ContractModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snehal subedi
 */
public class MergeSort {
    
    // Sort a list of ContractModel objects based on Location (String) in ascending or descending order
    public List<ContractModel> sortByDraftedBy(List<ContractModel> contractList, boolean isDesc) {
        if (contractList == null || contractList.isEmpty()) {
            throw new IllegalArgumentException("Contract list cannot be null or empty.");
        }

        // Convert the List to an array for merge sort (MergeSort works with arrays)
        List<ContractModel> sortedList = new ArrayList<>(contractList);
        mergeSort(sortedList, 0, sortedList.size() - 1, isDesc);
        return sortedList;
    }

    // The mergeSort function recursively splits the list and merges it back
    private void mergeSort(List<ContractModel> list, int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(list, left, mid, isDesc);   // Sort the left half
            mergeSort(list, mid + 1, right, isDesc); // Sort the right half
            
            merge(list, left, mid, right, isDesc); // Merge the sorted halves
        }
    }

    // The merge function combines two sorted halves of the list
    private void merge(List<ContractModel> list, int left, int mid, int right, boolean isDesc) {
        // Temporary arrays for the two halves
        List<ContractModel> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<ContractModel> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));
        
        int i = 0, j = 0, k = left;
        
        // Merge the two halves based on Location (String comparison)
        while (i < leftList.size() && j < rightList.size()) {
            if (shouldSwap(leftList.get(i).getDraftedBy(), rightList.get(j).getDraftedBy(), isDesc)) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        
        // Copy any remaining elements from the left half
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        
        // Copy any remaining elements from the right half
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    // Determine whether to swap based on the sorting order (ascending/descending)
    private boolean shouldSwap(String leftLocation, String rightLocation, boolean isDesc) {
        return isDesc ? leftLocation.compareTo(rightLocation) > 0 : leftLocation.compareTo(rightLocation) < 0;
    }
}