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
public class InsertionSort {
    
    List<ContractModel> contractSortList;

    public InsertionSort() {
        contractSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of ContractModel objects by their ItemName in ascending or descending order.
     *
     * @param contractList the list of ContractModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<ContractModel> sortByTitleName(List<ContractModel> contractList, boolean isDesc) {
        this.contractSortList.clear();
        this.contractSortList.addAll(contractList);

        if (contractSortList == null || contractSortList.isEmpty()) {
            throw new IllegalArgumentException("Contract list cannot be null or empty.");
        }

        // Insertion sort algorithm
        for (int i = 1; i < contractSortList.size(); i++) {
            ContractModel currentContract = contractSortList.get(i);
            int j = i - 1;

            // Move elements that are greater than currentContract (or less, based on order)
            while (j >= 0 && shouldSwap(currentContract.getTitle(), contractSortList.get(j).getTitle(), isDesc)) {
                contractSortList.set(j + 1, contractSortList.get(j));
                j = j - 1;
            }
            contractSortList.set(j + 1, currentContract);
        }

        return contractSortList;
    }

    /**
     * Determines whether the current Title should be swapped based on the order.
     *
     * @param current the current Title value
     * @param comparison the Title to compare with
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current Title should be swapped; false otherwise
     */
    private boolean shouldSwap(String current, String other, boolean isDesc){
     int comparisonResult=current.compareTo(other);//lexicographical comparison
     return isDesc?comparisonResult>0:comparisonResult<0;
    }
}