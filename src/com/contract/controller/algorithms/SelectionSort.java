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
 * @author Snehal Subedi
 */
public class SelectionSort {
    
    List<ContractModel> contractSortList;

    public SelectionSort() {
        contractSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of ContractModel objects by their Contract ID in ascending or descending order.
     *
     * @param contractList the list of DroneModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<ContractModel> sortByContractId(List<ContractModel> contractList, boolean isDesc) {
        this.contractSortList.clear();
        this.contractSortList.addAll(contractList);

        if (contractSortList == null || contractSortList.isEmpty()) {
            throw new IllegalArgumentException("Contract list cannot be null or empty.");
        }

        // Selection sort algorithm
        for (int i = 0; i < contractSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(contractSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(contractSortList, i, extremumIndex);
            }
        }

        return contractSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list from the start index.
     *
     * @param contractSortList the list of StudentModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<ContractModel> contractSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < contractSortList.size(); j++) {
            if (shouldSwap(contractSortList.get(j).getContractId(), contractSortList.get(extremumIndex).getContractId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should replace the extremum; false otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param contractSortList the list of ContractModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<ContractModel> contractSortList, int i, int j) {
        ContractModel temp = contractSortList.get(i);
        contractSortList.set(i, contractSortList.get(j));
        contractSortList.set(j, temp);
    }
}